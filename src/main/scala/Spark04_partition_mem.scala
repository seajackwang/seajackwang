import org.apache.spark.rdd.RDD
import org.apache.spark.{Partitioner, SparkConf, SparkContext}

/**
 * Author:sww
 * date:2021/10/6
 * desc: 分区02
 */
object Spark04_partition_mem {
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
