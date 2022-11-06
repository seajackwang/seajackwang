package laowang

import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

object SparkDataFrame {
  def main(args:Array[String]):Unit={
    //Spark程序入口
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("createDataFrame")
    val sc: SparkContext = new SparkContext(conf)
    val spark: SparkSession = SparkSession.builder().getOrCreate()
    //导入隐私转换
    import spark.implicits._
    val df = List("001","laozhang","男").toDF()

    //算子练习
    val list: List[String] = List("hello word", "hello jingjing")
    val splitlist: List[Array[String]] = list.map(_.split(" "))
    //List(Array("hello" "word"),Array("hello" "jingjing"))
    splitlist.foreach(elem=>println(elem.mkString("--")))
//    hello--word
//    hello--jingjing
    val flatList: List[String] = splitlist.flatten
    println(flatList)

    //group by
    val newlist: List[String] = List("hello", "word", "hi", "jingjing", "laowang", "laozhang")
    val charToStrings: Map[Char, List[String]] = newlist.groupBy(_.charAt(0))
    println(charToStrings)

    val newlist2: List[Int] = List(1,2,3,4,5,6,7)
    val intToInts: Map[Int, List[Int]] = newlist2.groupBy(_ % 2)
    println(intToInts)

  }

}
