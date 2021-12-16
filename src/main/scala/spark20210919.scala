import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object spark20210919 {
  def main(args:Array[String]):Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("spark2021")
    val sc: SparkContext = new SparkContext(conf)

    //创建RDD
    val newRDD: RDD[(String, Int)] = sc.makeRDD(List(("laowang", 100), ("laosong", 90)))

    //打印
    val unit = newRDD.collect().foreach(println)
    //关闭
    sc.stop()
  }
}
    

