import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author:sww
 * date:2021/10/6
 * desc: Transformation算子 flatmap
 */
object Spark09_Transformation_flatMap {
  def main(args:Array[String]): Unit={
    //创建程序入口对象SparkContext,设置配置信息SparkConf
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("CreateRDD")

    val sc: SparkContext = new SparkContext(conf)
    //默认分区
    val RDD: RDD[List[Int]] = sc.makeRDD(List(List(1,2),List(3,4),List(5,6)),2)

    val newRDD: RDD[Int] = RDD.flatMap { datas =>
      datas
    }

    newRDD.collect().foreach(println)
    //关闭连接
    sc.stop()
  }


}
