import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author:sww
 * date:2021/10/6
 * desc: 默认分区
 * --从集合众创建RDD 取决于分配给应用的cpu核数
 * --读取外部文件创建 math.min(分配cpu核数，2)
 */
object Spark03_partition_default {
  def main(args:Array[String]): Unit={
    //创建程序入口对象SparkContext,设置配置信息SparkConf
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("CreateRDD")

    val sc: SparkContext = new SparkContext(conf)
    val RDD: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4))

    val fileRDD: RDD[String] = sc.textFile("src/main/input/1.txt")


    println(fileRDD.partitions.size)
    //关闭连接
    sc.stop()
  }


}
