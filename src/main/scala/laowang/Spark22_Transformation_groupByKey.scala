package laowang

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author:sww
 * date:2021/10/6
 * desc: Transformation_groupByKey
 */
object Spark22_Transformation_groupByKey {
  def main(args:Array[String]): Unit={
    //创建程序入口对象SparkContext,设置配置信息SparkConf
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("Wc")

    val sc: SparkContext = new SparkContext(conf)

    val RDD: RDD[(String, Int)] = sc.makeRDD(List(("a", 1), ("b", 2), ("c", 3), ("a", 5), ("b", 6)))

//    val res: RDD[(String, Int)] = RDD.reduceByKey(_ + _)

    val groupRDD: RDD[(String, Iterable[Int])] = RDD.groupByKey()

    val resRDD: RDD[(String, Int)] = groupRDD.map {
      case (key, datas) => {
        (key, datas.sum)
      }
    }
    resRDD.collect().foreach(println )
    //关闭连接
    sc.stop()
  }


}
