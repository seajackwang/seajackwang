package laowang

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object runGroup {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("testData")

    val sc: SparkContext = new SparkContext(conf)
    //方法一：从本地文件读取
    val rdd: RDD[String] = sc.textFile("src/main/input/ts.txt")

    val newRdd: RDD[String] = rdd.flatMap(_.split(" "))
    newRdd.mapPartitionsWithIndex {
      (index, datas) => {
        println(index + "--->" + datas.mkString(","))
        datas
      }
      //    newRdd.collect().foreach(println)
    }.collect


  }
}
