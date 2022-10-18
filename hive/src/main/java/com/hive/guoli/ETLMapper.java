package com.hive.guoli;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Counter;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class ETLMapper extends Mapper<LongWritable, Text, NullWritable, Text> {

    private StringBuffer sb = new StringBuffer();
    private Text text = new Text();

    private Counter total;
    private Counter pass;

    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        total = context.getCounter("ETL", "Total");
        pass = context.getCounter("TEL", "Pass");
    }

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        // 1.分割
        String[] split = value.toString().split("\t");

        // 累计
        total.increment(1);

        if (split.length < 9) {
            pass.increment(1);
            return;
        }
        // 初始化容器
        sb.setLength(0);
        // 对视频分类字段去掉空格
        split[3] = split[3].replaceAll(" ", "");

        for (int i = 0; i < split.length; i++) {
            String field = split[i];

            // 如果遍历到最后一个字段
            if (split.length - 1 == i) {
                sb.append(field);
                // 如果是前9列
            } else if (i < 9) {
                sb.append(field).append("\t");
                // 剩余的列
            } else {
                sb.append(field).append("&");
            }
        }
        text.set(sb.toString());
        context.write(NullWritable.get(), text);
    }
}
