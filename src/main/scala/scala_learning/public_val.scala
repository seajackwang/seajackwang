package scala_learning

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object public_val {
  def main(args: Array[String]): Unit = {
    var a = 10
    println(a)
    val name = "laowang"
    val age = 28
    val sarary = 17500.50
    //    printf("%d的%s还单身,他的月薪是%f",age,name,sarary)
    println(s"${age}的${name}还单身,他的月薪是${sarary}")
    val sql =
      """
        |
        |""".stripMargin

    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("test")

    val sc: SparkContext = new SparkContext(conf)
    val RDD: RDD[Char] = sc.makeRDD("1,w,3,4")
    println(RDD.toString())

  }

}
