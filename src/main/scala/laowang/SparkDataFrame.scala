package laowang

import org.apache.spark.{SparkConf, SparkContext}

object SparkDataFrame {
  def main(args:Array[String]):Unit={

    val conf: SparkConf = new SparkConf().setMaster("Local[*]").setAppName("createDataFrame")
    val sc: SparkContext = new SparkContext()

  }

}
