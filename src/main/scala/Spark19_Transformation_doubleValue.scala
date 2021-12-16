import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author:sww
 * date:2021/10/6
 * desc: 第一个Spark wc案例
 */
object Spark19_Transformation_doubleValue {
  def main(args:Array[String]): Unit={
    //创建程序入口对象SparkContext,设置配置信息SparkConf
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("Wc")

    val sc: SparkContext = new SparkContext(conf)

    //读取外部文件
    val textRDD: RDD[String] = sc.textFile("src/main/input/1.txt")

    val flatMapRDD: RDD[String] = textRDD.flatMap(_.split(" "))

    val mapRDD: RDD[(String, Int)] = flatMapRDD.map((_, 1))

    val reduceRDD: RDD[(String, Int)] = mapRDD.reduceByKey(_ + _)

    val resRDD: Array[(String, Int)] = reduceRDD.collect()

    resRDD.foreach(println )
    //关闭连接
    sc.stop()
  }


}
