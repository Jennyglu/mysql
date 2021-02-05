package Mr_friends;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/**
 * 粘合类
 * 负责整合三阶段八步骤
 * 是整个程序的入口
 */
public class friends_main extends Configured implements Tool {
    @Override
    public int run(String[] strings) throws Exception {
        // 创建job对象，用来连接三阶段八步骤
        Job job = Job.getInstance(super.getConf());
        // 创建集群专属
        job.setJarByClass(friends_main.class);
        // 指定输入
        job.setInputFormatClass(TextInputFormat.class);
        TextInputFormat.addInputPath(job,new Path(""));
        /**
         * 第一阶段：map阶段
         */
        // 定义map逻辑
        job.setMapperClass(friends_Mapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);
        /**
         * 第二阶段：sulffle阶段
         */
        // 分区
        // 排序
        // 规约
        // 分组
        /**
         * 第三阶段：ruduce阶段
         */
        // 定义reduce逻辑
        job.setReducerClass(friends_reducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        // 指定输出
        job.setOutputFormatClass(TextOutputFormat.class);
        TextOutputFormat.setOutputPath(job,new Path(""));

        // 等待执行
        boolean b = job.waitForCompletion(true);
        return b ? 0 :1;
    }

    public static void main(String[] args) throws Exception {
        int run = ToolRunner.run(new Configuration(), new friends_main(), args);
        System.exit(run);
    }
}
