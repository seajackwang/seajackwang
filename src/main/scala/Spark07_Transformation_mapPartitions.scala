import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author:sww
 * date:2021/10/6
 * desc: Transformation算子mapPartitions
 */
object Spark07_Transformation_mapPartitions {
  def main(args:Array[String]): Unit={
    //创建程序入口对象SparkContext,设置配置信息SparkConf
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("CreateRDD")

    val sc: SparkContext = new SparkContext(conf)
    //默认分区
    val RDD: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4),2)

    //    val newRDD: RDD[Int] = RDD.map(_ * 2)
    val newRDD: RDD[Int] = RDD.mapPartitions(datas => {
      datas.map(elem => elem * 2)
    })

    newRDD.collect().foreach(println)
    //关闭连接
    sc.stop()
  }


}
