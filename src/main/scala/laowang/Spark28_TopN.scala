package laowang

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author:sww
 * date:2021/10/6
 * desc: join
 */
object Spark28_TopN {
  def main(args:Array[String]): Unit={
    //创建程序入口对象SparkContext,设置配置信息SparkConf
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("Wc")

    val sc: SparkContext = new SparkContext(conf)

    val logRDD: RDD[String] = sc.textFile("D:\\桌面\\下载\\agent.log")

    //    logRDD.collect()
    val mapRDD: RDD[(String, Int)] = logRDD.map {
      line => {
        val fields: Array[String] = line.split(" ")
        (fields(1) + "-" + fields(4), 1)
      }
    }

    val reduceRDD: RDD[(String, Int)] = mapRDD.reduceByKey(_ + _)

    val map1RDD: RDD[(String, (String, Int))] = reduceRDD.map {
      case (proAndAD, clickCount) => {
        val proAndADString: Array[String] = proAndAD.split("-")

        (proAndADString(0), (proAndADString(1), clickCount))
      }
    }

    val groupRDD: RDD[(String, Iterable[(String, Int)])] = map1RDD.groupByKey()

    val resRDD: RDD[(String, List[(String, Int)])] = groupRDD.mapValues(
      mv => {
        mv.toList.sortWith {
          (left, right) => {
            left._2 > right._2
          }
        }.take(3)
      }
    )

    resRDD.collect().foreach(println )
    //关闭连接
    sc.stop()
  }


}
