package com.mapreducer.demo15;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.output.FileOutputCommitter;

import java.io.IOException;

public class MySQLTextOutputFormat extends OutputFormat<TableBean, NullWritable> {


    public RecordWriter<TableBean, NullWritable> getRecordWriter(TaskAttemptContext taskAttemptContext) throws IOException, InterruptedException {
        return new MySQLRecordWriter();
    }

    public void checkOutputSpecs(JobContext jobContext) throws IOException, InterruptedException {

    }

    //下面这段代码，摘抄自源码
    private FileOutputCommitter committer = null;

    public static Path getOutputPath(JobContext job) {
        String name = job.getConfiguration().get("mapred.output.dir");
        return name == null ? null : new Path(name);
    }

    public OutputCommitter getOutputCommitter(TaskAttemptContext taskAttemptContext) throws IOException, InterruptedException {
        if (committer == null) {
            Path output = getOutputPath(taskAttemptContext);
            committer = new FileOutputCommitter(output, taskAttemptContext);
        }
        return committer;
    }
}
