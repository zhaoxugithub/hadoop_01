-- 一、开启Map输出阶段压缩
        -- 1．开启hive中间传输数据压缩功能
        set hive.exec.compress.intermediate=true;
        -- 2．开启mapreduce中map输出压缩功能
        set mapreduce.map.output.compress=true;

        -- 3．设置mapreduce中map输出数据的压缩方式
        set mapreduce.map.output.compress.codec=
            org.apache.hadoop.io.compress.SnappyCodec;
        -- 4．执行查询语句
        select * from order_detail;

-- 二、开启Reduce输出阶段压缩
        -- 1．开启hive最终输出数据压缩功能
        set hive.exec.compress.output=true;
        -- 2．开启mapreduce最终输出数据压缩
        set mapreduce.output.fileoutputformat.compress=true;
        -- 3．设置mapreduce最终数据输出压缩方式
        set mapreduce.output.fileoutputformat.compress.codec =
            org.apache.hadoop.io.compress.SnappyCodec;
        -- 4．设置mapreduce最终数据输出压缩为块压缩
        set mapreduce.output.fileoutputformat.compress.type=BLOCK;
        -- 5．测试一下输出结果是否是压缩文件
        insert overwrite local directory '/home/hadoop/app/hivedata/111.txt' select * from order_detail order by price;