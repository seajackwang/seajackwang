package laowang

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author:sww
 * date:2021/10/6
 * desc: join
 */
object Spark27_Transformation_join {
  def main(args:Array[String]): Unit={
    //创建程序入口对象SparkContext,设置配置信息SparkConf
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("Wc")

    val sc: SparkContext = new SparkContext(conf)

    val RDD: RDD[(Int, String)] = sc.makeRDD(Array((1, "a"), (1,"d"), (2, "b"), (3, "c")))

    val RDD2: RDD[(Int, Int)] = sc.makeRDD(Array((1, 4), (2, 5), (2, 8), (4, 6)))

    //join算子 相当于内连接
    val newRDD: RDD[(Int, (String, Int))] = RDD.join(RDD2)
    val res2: RDD[(Int, (Int, String))] = RDD2.join(RDD)

    //cogroup
    val res3: RDD[(Int, (Iterable[String], Iterable[Int]))] = RDD.cogroup(RDD2)

    res3.collect().foreach(println)
    //关闭连接
    sc.stop()
  }


}
