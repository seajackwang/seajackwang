package laowang

import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

object test008 {
  def main(args: Array[String]): Unit = {
    //注意local[*]这里local里首字母是小写
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("test_cs")
    val sc: SparkContext = new SparkContext(conf)

    val spark: SparkSession = SparkSession.builder().getOrCreate()

    val a = "asdw_12kja_kjfn_dytn_dsd23_dffd".toInt
    println(a)
  }

}
