package laowang

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author:sww
 * date:2021/10/6
 * desc: Transformation_aggregateBykey
 */
object Spark23_Transformation_aggregateByKey {
  def main(args:Array[String]): Unit={
    //创建程序入口对象SparkContext,设置配置信息SparkConf
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("Wc")

    val sc: SparkContext = new SparkContext(conf)

    val RDD: RDD[(String, Int)] = sc.makeRDD(List(("a", 1), ("b", 2), ("c", 3), ("a", 5), ("b", 6)))

    val newRDD: RDD[(String, Int)] = RDD.aggregateByKey(0)(_+_,_+_)
    //foldByKey是aggregateByKey的简化版，分区内和 分区间一样的规则
    val RDD3: RDD[(String, Int)] = RDD.foldByKey(0)(_ + _)
    RDD3.collect().foreach(println )
    //关闭连接
    sc.stop()
  }


}
