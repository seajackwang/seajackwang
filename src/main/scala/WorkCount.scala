import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object WorkCount {
  def main(args:Array[String]):Unit={
    //sparkConf
    val conf: SparkConf = new SparkConf().setAppName("workCount").setMaster("local[*]")
    //SparkContext
    val sc: SparkContext = new SparkContext(conf)

    val RDD: RDD[String] = sc.textFile("src/main/input/1.txt")
    val newRDD: RDD[String] = RDD.flatMap(_.split(" "))
    val mapRDD: RDD[(String, Int)] = newRDD.map((_, 1))
    val res: RDD[(String, Int)] = mapRDD.reduceByKey(_ + _)

    //输出res
    res.collect.foreach(println)

    //sleep

    //关闭
    sc.stop()
  }

}
