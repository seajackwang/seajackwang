package laowang

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author:sww
 * date:2021/10/6
 * desc: mapValues
 */
object Spark26_Transformation_mapValues {
  def main(args:Array[String]): Unit={
    //创建程序入口对象SparkContext,设置配置信息SparkConf
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("Wc")

    val sc: SparkContext = new SparkContext(conf)

    val RDD: RDD[(Int, String)] = sc.makeRDD(List((1, "a"), (1,"d"), (2, "b"), (3, "c")))

    val resRDD: RDD[(Int, String)] = RDD.mapValues("|||" + _)

    resRDD.collect().foreach(println)
    //关闭连接
    sc.stop()
  }


}
