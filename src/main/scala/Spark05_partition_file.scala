import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author:sww
 * date:2021/10/6
 * desc:  通过读取外部文件，创建RDD
 *   -默认分区规则
 *       math.min(分配给应用的CPU核数,2)
 *   -指定分区
 *     >1.在textFile方法中，第二个参数minPartitions,表示最小分区数
 *       注意：是最小，不是实际的分区个数
 *     >2.在实际计算分区个数的时候，会根据文件的总大小和最小分区数进行相除运算
 *       &如果余数为0
 *         那么最小分区数，就是最终实际的分区数
 *       &如果余数不为0
 *         那么实际的分区数，要计算
 *
 *   -原始数据
 *       0 	1 	2 	3 	4 	5   6 	7 	8
 *       a	b 	c	d 	e 	f 	g 	X	X
 *
 *       9 	10 	11	12 	13	14
 *       h 	i 	j 	k	X 	X
 *
 *       15 	16 	17 	18	19
 *       l 	m 	n 	X 	X
 *
 *       20 	21
 *       o 	p
 *
 *       设置最小切片数为3
 *
 *
 *       切片规划 FileInputFormat->getSplits
 *       0 = {FileSplit@5103} "file:/D:/dev/workspace/bigdata-0105/spark-0105/input/test.txt:0+7"
 *       1 = {FileSplit@5141} "file:/D:/dev/workspace/bigdata-0105/spark-0105/input/test.txt:7+7"
 *       2 = {FileSplit@5181} "file:/D:/dev/workspace/bigdata-0105/spark-0105/input/test.txt:14+7"
 *       3 = {FileSplit@5237} "file:/D:/dev/workspace/bigdata-0105/spark-0105/input/test.txt:21+1"
 *
 *
 *       最终分区数据
 *       0
 *       abcdefg
 *       1
 *       hijk
 *       2
 *       lmn
 *       op
 *       3
 *       空
 */
object Spark05_partition_file {
  def main(args:Array[String]): Unit={
    //创建程序入口对象SparkContext,设置配置信息SparkConf
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("CreateRDD")

    val sc: SparkContext = new SparkContext(conf)
    //默认分区8分区
    val RDD: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4))
    //设置4分区
    val RDD2: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4),4)

    //设置3分区
    val RDD3: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4),3)
    //设置3分区,5个数据
    val RDD4: RDD[String] = sc.makeRDD(List("a", "b", "c", "d","e"),3)
//    val newRDD: RDD[(Int, String)] = RDD.map((_,"sww"))

    RDD4.saveAsTextFile("D:\\javaxxx\\SparkCoretest\\src\\main\\output")
    //关闭连接
    sc.stop()
  }


}
