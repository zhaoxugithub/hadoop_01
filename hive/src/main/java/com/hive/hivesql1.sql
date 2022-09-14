-- 射手座,A            大海|凤姐
-- 白羊座,A            孙悟空|猪八戒
-- 白羊座,B            宋宋|苍老师
SELECT concat(p.constellation, ",", p.blood_type),

       concat_ws("|", collect_list(p.name))
FROM person_info p
group by constellation,
         blood_type;
------------------------------------------------------------
create table movie_info
(
    movie    string,
    category array<string>
)
    row format delimited fields terminated by "\t"
        collection items terminated by ",";

load data local inpath '/home/hadoop/app/hivedata/movie.txt' into table movie_info;


select *
from movie_info;


select movie,
       category_name
from movie_info lateral view explode(category) table_tmp as category_name;

----------------------------------------------------------------


create table business
(

    name      string,
    orderdate string,
    cost      int
) ROW FORMAT DELIMITED FIELDS TERMINATED BY ',';
load data local inpath "/home/hadoop/app/hivedata/business.txt" into table business;

select *
from business;

-- （1）查询在2017年4月份购买过的顾客及总人数
select name, count(1)
from business
where orderdate like '2017-04%'
group by name;

-- mart    2
-- jack    2
select name, count(*) over ()
from business
where substring(orderdate, 1, 7) = '2017-04'
group by name;

--(2) 查询顾客的购买明细及月购买总额
select *, sum(cost) over (partition by name,month(orderdate))
from business;

-- （3）上述的场景, 将每个顾客的cost按照日期进行累加
select *,
       sum(cost) over (partition by name order by orderdate rows between unbounded preceding and
           current row )
from business;

-- （4）查看顾客上次的购买时间
select *, lag(orderdate, 1, '1970-01-01') over (partition by name order by orderdate)
from business;

-- （5）查询前20%时间的订单信息

SELECT *, NTILE(5) over (order by orderdate) nt
from business;

select *
from (SELECT *, NTILE(5) over (order by orderdate) nt
      from business) t1
where nt = 1;

-------------------------------------------------
create table score
(
    name    string,
    subject string,
    score   int
)
    row format delimited fields terminated by "\t";
load data local inpath '/home/hadoop/app/hivedata/score.txt' into table score;


select *
from score;
-- 孙悟空 数学 95
-- 宋宋  数学 86
-- 婷婷  数学 85
-- 大海  数学 56
-- 宋宋  英语 84
-- 大海  英语 84
-- 婷婷  英语 78
-- 孙悟空 英语 68
-- 大海  语文 94
-- 孙悟空 语文 87
-- 婷婷  语文 65
-- 宋宋  语文 64


-- 计算每门学科成绩排名
select *,
       rank() over (partition by subject order by score desc ) r
--        dense_rank() over (partition by subject order by score desc rows 3 preceding) dr,
--        row_number() over (partition by subject order by score desc rows 3 preceding)  rr
from score;

-- 求出每一学科前三名的信息
select *
from (select *,
             rank() over (partition by subject order by score desc ) r
--        dense_rank() over (partition by subject order by score desc rows 3 preceding) dr,
--        row_number() over (partition by subject order by score desc rows 3 preceding)  rr
      from score) t
where r <= 3;

---------------------------------额外拓展-------------------------------
create external table if not exists order_detail
(
    user_id   string,
    device_id string,
    user_type string,
    price     double,
    sales     int
)
    row format delimited fields terminated by "\t"
        lines terminated by "\n"
    stored as textfile;
load data local inpath '/home/hadoop/app/hivedata/exercise.txt' into table order_detail;


select *
from order_detail;


-- ## > < =
-- ##注意： String 的比较要注意(常用的时间比较可以先 to_date 之后再比较)
select long_time>short_time, long_time<short_time,long_time=short_time, to_date(long_time)=to_date(short_time)
from
    (
        select '2017-01-11 00:00:00' as long_time, '2017-01-11' as short_time
        from
            order_detail limit 1
    )bb;
-- result:
-- true    false   false   true

-- ## 空值判断
select 1 from order_detail where NULL is NULL limit 1;


-- ## 非空判断
select 1 from order_detail where 1 is not NULL limit 1;

-- 日期函数

select
    from_unixtime(1323308943),
    from_unixtime(1323308943,'yyyyMMdd'),
    unix_timestamp(),
    unix_timestamp('2017-12-07 16:01:03'),
    unix_timestamp('20171207 16-01-03','yyyyMMdd HH-mm-ss')
from
    order_detail limit 1;

-- ## 日期时间转日期:to_date  日期转年:year 日期转月:month 日期转天:day 日期转小时:hour  日期转分钟:minute  日期转秒:second

select
    to_date('2016-12-08 10:03:01'),
    year('2016-12-08 10:03:01'),
    month('2016-12-08'),
    day('2016-12-08 10:03:01'),
    hour('2016-12-08 10:03:01'),
    minute('2016-12-08 10:03:01'),
    second('2016-12-08 10:03:01')
from
    order_detail limit 1;

-- ## 日期转周:weekofyear  日期比较:datediff
select
    weekofyear('2016-12-08 10:03:01'),
    datediff('2016-12-08','2016-11-27')
from order_detail limit 1;


-- ## 日期增加: date_add 日期减少: date_sub
select date_add('2016-12-08',10),date_add('2016-12-08',-10),
       date_sub('2016-12-08',-10),date_sub('2016-12-08',10) from order_detail limit 1;

select
    date_add('20161208',10),
    from_unixtime(unix_timestamp(date_add('2016-12-08',10)),'yyyyMMdd'),
    from_unixtime(unix_timestamp(date_add('2016-12-08',10),'yyyy-MM-dd'),'yyyyMMdd')
from order_detail limit 1;


-- ## json解析:
-- get_json_object
-- 语法: get_json_object(string json_string, string path)
-- 说明：解析 json 的字符串 json_string,返回 path 指定的内容。如果输入的 json 字符串无效，那么返回 NULL。

select
    get_json_object(
            '{"store":
            {"fruit":\[{"weight":8,"type":"apple"},{"weight":9,"type":"pear"}],
            "bicycle":{"price":19.95,"color":"red"}
            },
            "email":"amy@only_for_json_udf_test.net",
            "owner":"amy"
            }',
            '$.owner'),
    get_json_object(
            '{"store":
            {"fruit":\[{"weight":8,"type":"apple"},{"weight":9,"type":"pear"}],
            "bicycle":{"price":19.95,"color":"red"}
            },
            "email":"amy@only_for_json_udf_test.net",
            "owner":"amy"
            }',
            '$.store.fruit[0].type')
from order_detail limit 1;


-- ## json_tuple
-- 语法: json_tuple(string jsonStr,string k1,string k2, ...)
-- 参数为一组键k1，k2……和JSON字符串，返回值的元组。该方法比 get_json_object 高效，因为可以在一次调用中输入多个键.

select a.user_id, b.*
from order_detail a
         lateral view
             json_tuple('{"store":
{"fruit":\[{"weight":8,"type":"apple"},{"weight":9,"type":"pear"}],
"bicycle":{"price":19.95,"color":"red"}
},
"email":"amy@only_for_json_udf_test.net",
"owner":"amy"
}', 'email', 'owner') b as email, owner limit 1;


-- ## parse_url_tuple

SELECT b.*
from
    (
        select 'http://facebook.com/path1/p.php?k1=v1&k2=v2#Ref1' as urlstr
        from
            order_detail
        limit 1
    )a
        LATERAL VIEW
            parse_url_tuple(a.urlstr, 'HOST', 'PATH', 'QUERY', 'QUERY:k1') b as host, path, query, query_k1 LIMIT 1;


-- 空格字符串:space   重复字符串:repeat 首字符ascii:ascii

select space(10), length(space(10)), repeat('abc',5), ascii('abcde')
from order_detail
limit 1;


-- 左补足函数:lpad  右补足函数:rpad
-- 语法: lpad(string str, int len, string pad)
-- 说明：lpad将 str 进行用 pad 进行左补足到 len 位, rpad将 str 进行用 pad 进行右补足到 len 位
-- 注意：与 GP,ORACLE 不同; pad不能默认

select lpad('abc',10,'td'),rpad('abc',10,'td')
from order_detail
limit 1;


select str_to_map('aaa:11&bbb:22', '&', ':')['aaa']
from order_detail limit 1;