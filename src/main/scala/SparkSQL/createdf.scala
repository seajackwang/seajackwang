package SparkSQL

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object createdf {
  def main(args:Array[String]):Unit={
    //创建上下文环境配置变量
    val conf: SparkConf = new SparkConf().setMaster("Local[*]").setAppName("dfDmeo")
    //创建SparkSession对象
    val spark: SparkSession = SparkSession.builder().config(conf).getOrCreate()

    //RDD-DataFrame-DataSet转换需要引入隐式转换规则
    import spark.implicits._


  }

}
