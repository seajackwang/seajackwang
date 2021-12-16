package laowang

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author:sww
 * date:2021/10/6
 * desc: Transformation_aggregateBykey
 */
object Spark24_Transformation_combineBykey {
  def main(args:Array[String]): Unit={
    //创建程序入口对象SparkContext,设置配置信息SparkConf
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("Wc")

    val sc: SparkContext = new SparkContext(conf)

    val RDD: RDD[(String, Int)] = sc.makeRDD(List(("jingjing", 100), ("behui", 79), ("jingjing", 93), ("behui", 65), ("behui", 76)))

    //方法 1
    val groupRDD: RDD[(String, Iterable[Int])] = RDD.groupByKey()

    val res1: RDD[(String, Int)] = groupRDD.map {
      case (name, scoreseq) => {
        (name, scoreseq.sum / scoreseq.size)
      }
    }

    //方法2
    val mapRDD: RDD[(String, (Int, Int))] = RDD.map {
      case (name, score) => {
        (name, (score, 1))
      }
    }

    val newRDD: RDD[(String, (Int, Int))] = mapRDD.reduceByKey {
      (t1, t2) => {
        (t1._1 + t2._1, t1._2 + t2._2)
      }
    }

    val res2: RDD[(String, Any)] = newRDD.map {
      case (name, (score, count)) => {
        (name, score/count)
      }
    }

    //方法3
    val combineRDD: RDD[(String, (Int, Int))] = RDD.combineByKey(
      (_, 1),
      (t1: (Int, Int), v) => {
        (t1._1 + v, t1._2 + 1)
      },
      (t2: (Int, Int), t3: (Int, Int)) => {
        (t2._1 + t3._1, t2._2 + t3._2)
      }
    )
    val res3: RDD[(String, Int)] = combineRDD.map {
      case (name, (score, count)) => {
        (name, score / count)
      }
    }
    //输出
    res3.collect().foreach(println)

    //关闭连接
    sc.stop()
  }


}
