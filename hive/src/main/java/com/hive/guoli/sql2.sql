-- 一、果粒项目练习
show databases;

show tables;

-----------------------------基础工作----------------------------------------
-- 创建临时表
create table gulivideo_ori
(
    videoId   string,
    uploader  string,
    age       int,
    category  array<string>,
    length    int,
    views     int,
    rate      float,
    ratings   int,
    comments  int,
    relatedId array<string>
)
    row format delimited
        fields terminated by "\t"
        collection items terminated by "&"
    stored as textfile;

load data inpath "/guoli/video_etl/" into table gulivideo_ori;

select *
from gulivideo_ori;

create table gulivideo_user_ori
(
    uploader string,
    videos   int,
    friends  int
)
    row format delimited
        fields terminated by "\t"
    stored as textfile;
load data inpath "/guoli/user/" into table gulivideo_user_ori;

select *
from gulivideo_user_ori;


-- 创建user表
create table user_orc
(
    uploader string,
    videos   int,
    friends  int
)
    row format delimited
        fields terminated by "\t"
    stored as orc;

insert into table user_orc
select *
from gulivideo_user_ori;

select *
from user_orc;

-- 创建video表
create table video_orc
(
    videoId   string,
    uploader  string,
    age       int,
    category  array<string>,
    length    int,
    views     int,
    rate      float,
    ratings   int,
    comments  int,
    relatedId array<string>
)
    row format delimited fields terminated by "\t"
        collection items terminated by "&"
    stored as orc;

insert into table video_orc
select *
from gulivideo_ori;

select *
from video_orc;



--------------------------------需求---------------------------------------
--1.统计视频观看数Top10
select vo.videoId, vo.views
from video_orc vo
order by vo.views desc
limit 10;



select vo.videoId,
       vo.views
from video_orc vo
order by vo.views desc
limit 10;

--2.统计视频类别热度Top10

select t.category_name, count(t.category_name) as amount
from (
         select category_name from video_orc lateral view explode(category) t_category as category_name) t
group by t.category_name
order by amount desc
limit 10;


--3.统计出视频观看数最高的20个视频的所属类别以及类别包含Top20视频的个数
select re.category_name, count(category_name) as amount
from (
         select category_name
         from (select vo.videoId,
                      vo.views,
                      vo.category
               from video_orc vo
               order by vo.views desc
               limit 20) tt lateral view explode(tt.category) t_category as category_name) re
group by re.category_name
order by amount desc;



select category_name     as category,
       count(t2.videoId) as hot_with_views
from (
         select videoId,
                category_name
         from (
                  select *
                  from video_orc
                  order by video_orc.views
                      desc
                  limit
                      20) t1 lateral view explode(category) t_catetory as category_name) t2
group by category_name
order by hot_with_views
    desc;

--4.统计视频观看数Top50所关联视频的所属类别排序
select category_name, count(category_name) as amount
from (
         select t2.*, t3.related_Id
         from video_orc t2
                  inner join (
             select distinct related_Id
             from (
                      select vo.relatedId, vo.views
                      from video_orc vo
                      order by vo.views desc
                      limit 50) t1 lateral view explode(relatedId) related_table as related_Id) t3
                             on t2.videoId = t3.related_Id) t4 lateral view explode(t4.category) category_table as category_name
group by category_name
order by amount desc;


select category_name     as category,
       count(t5.videoId) as hot
from (
         select t4.videoId,
                category_name
         from (
                  select distinct(t2.videoId) as videoId,
                                 t3.category
                  from (
                           select explode(relatedId) as videoId
                           from (
                                    select *
                                    from video_orc
                                    order by video_orc.views
                                        desc
                                    limit
                                        50) t1) t2
                           inner join
                       video_orc t3 on t2.videoId = t3.videoId) t4 lateral view explode(category) t_catetory as category_name) t5
group by category_name
order by hot
    desc;


--5.统计每个类别中的视频热度Top10，以Music为例
create table video_orc_category
(
    videoId    string,
    uploader   string,
    age        int,
    categoryId string,
    length     int,
    views      int,
    rate       float,
    ratings    int,
    comments   int,
    relatedId  array<string>
)
    row format delimited
        fields terminated by "\t"
        collection items terminated by "&"
    stored as orc;

insert into table video_orc_category
select videoId,
       uploader,
       age,
       categoryId,
       length,
       video_orc.views,
       rate,
       ratings,
       comments,
       relatedId
from video_orc lateral view explode(category) catetory as categoryId;


select *
from video_orc_category;

select t.videoId, t.categoryId, t.views, t.r
from (
         select *, rank() over (partition by categoryId order by voc.views desc) as r
         from video_orc_category voc
     ) t
where t.r <= 10;



select *
from (select voc.views, voc.categoryId, row_number() over (partition by voc.categoryId order by voc.views desc) as sorts
      from video_orc_category as voc) t
where t.sorts <= 10;


--6.统计每个类别中视频流量Top10，以Music为例
select t.videoId, t.categoryId, t.rate, t.r
from (
         select *, row_number() over (partition by categoryId order by voc.rate desc) as r
         from video_orc_category voc
     ) t
where t.r <= 10;


--7.统计上传视频最多的用户Top10以及他们上传的观看次数在前20的视频

select tt.videoId, tt.views, tt.uploader, tt.total
from (
         select vo.videoId,
                vo.views,
                t.uploader,
                row_number() over (partition by vo.uploader order by vo.views desc) as total
         from video_orc vo
                  inner join (
             select vo2.uploader, count(vo2.uploader) as amount
             from video_orc vo2
             group by vo2.uploader
             order by amount desc
             limit 10) t on t.uploader = vo.uploader) tt
where tt.total <= 20;


--8.统计每个类别视频观看数Top10

select t.category_col, t.views
from (
         select *, row_number() over (partition by category_col order by vo.views) as num
         from video_orc vo lateral view explode(vo.category) category_table as category_col
     ) t
where t.num <= 10;

select
    t1.*
from (
         select
             videoId,
             categoryId,
             video_orc_category.views,
             row_number() over(partition by categoryId order by video_orc_category.views desc) rank from video_orc_category) t1
where
        rank <= 10;