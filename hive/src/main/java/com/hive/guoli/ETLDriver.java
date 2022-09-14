package com.hive.guoli;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.File;
import java.io.IOException;

public class ETLDriver {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration);

        job.setJarByClass(ETLDriver.class);

        job.setMapperClass(ETLMapper.class);

        job.setOutputKeyClass(NullWritable.class);
        job.setOutputValueClass(Text.class);

        job.setNumReduceTasks(0);

        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        // 7 566666666提交
        boolean result = job.waitForCompletion(true);
        System.exit(result ? 0 : 1);
    }


    /**
     * 初始化输入路径
     *
     * @param job
     * @param hDFSInputPath
     */
    public static void initInputPath(Job job, String hDFSInputPath, String localPath) throws IOException {

        FileSystem fileSystem = FileSystem.get(job.getConfiguration());
        //判断输入路径是否存在
        boolean exists = fileSystem.exists(new Path(hDFSInputPath));
        //如果文件不存就上传
        if (!exists) {
            //上传本地文件之前进行验证
            File file = new File(localPath);
            if (localPath == null || localPath.equals("") || !file.exists() || file.isDirectory()) {
                //todo 抛出异常
                throw new IllegalArgumentException("本地文件找不到");
            }
            //正常上传
            fileSystem.copyFromLocalFile(new Path(localPath), new Path(hDFSInputPath));
        }
        //设置文件上传路径
        FileInputFormat.setInputPaths(job, hDFSInputPath);
    }

    /**
     * 初始化输出路径
     *
     * @param job
     * @param hDFSOutputPath
     * @throws IOException
     */
    public static void initOutPath(Job job, String hDFSOutputPath) throws IOException {
        if (hDFSOutputPath == null || hDFSOutputPath.equals("")) {
            throw new IllegalArgumentException("未指定输出路径");
        }
        FileSystem fileSystem = FileSystem.get(job.getConfiguration());
        //如果输出路径存在删除输出路径
        if (fileSystem.exists(new Path(hDFSOutputPath))) {
            fileSystem.delete(new Path(hDFSOutputPath), true);
        }
        FileOutputFormat.setOutputPath(job, new Path(hDFSOutputPath));
    }
}
