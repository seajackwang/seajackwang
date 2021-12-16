import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author:sww
 * date:2021/10/6
 * desc: Transformation算子mapPartitionsWithIndex
 */
object Spark08_Transformation_mapPartitionsWithIndex {
  def main(args:Array[String]): Unit={
    //创建程序入口对象SparkContext,设置配置信息SparkConf
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("CreateRDD")

    val sc: SparkContext = new SparkContext(conf)
    //默认分区
    val RDD: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4,5,6,7,8),3)

    //    val newRDD: RDD[Int] = RDD.map(_ * 2)
    //    val newRDD: RDD[Int] = RDD.mapPartitions(datas => {
    //      datas.map(elem => elem * 2)
    //    })
    val newRDD: RDD[(Int, Int)] = RDD.mapPartitionsWithIndex((index, datas) => {
      datas.map((index, _))
    })

    //需求：第二个分区数据*2，其余分区数据不变
    val IndexRDD: RDD[Int] = RDD.mapPartitionsWithIndex((index, datas) => {
      index match {
        case 1 => datas.map(_ * 2)
        case _ => datas
      }
    })

    IndexRDD.collect().foreach(println)
    //关闭连接
    sc.stop()
  }


}
