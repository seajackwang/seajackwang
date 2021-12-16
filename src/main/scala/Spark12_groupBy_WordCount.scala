import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author:sww
 * date:2021/10/6
 * desc: groupBy完成wordcount案例
 */
object Spark12_groupBy_WordCount {
  def main(args:Array[String]): Unit={
    //创建程序入口对象SparkContext,设置配置信息SparkConf
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("CreateRDD")

    val sc: SparkContext = new SparkContext(conf)
    val RDD: RDD[String] = sc.makeRDD(List("hello world","hello scala","hello spark"), 2)

    //简单版--实现方式1
    //扁平化映射
    val flatMapRDD: RDD[String] = RDD.flatMap(_.split(" "))
    //结构转换，单词计数
    val mapRDD: RDD[(String, Int)] = flatMapRDD.map((_, 1))
    //按key对RDD的元素进行分组
    val groupByRDD: RDD[(String, Iterable[(String, Int)])] = mapRDD.groupBy(_._1)
    //对分组后的元素再次映射
    val resRDD: RDD[(String, Int)] = groupByRDD.map {
      case (word, datas) => {
        (word, datas.size)
      }
    }
    //简单版--实现方式2
    //扁平化映射
    val flatRDD: RDD[String] = RDD.flatMap(_.split(" "))
    //按key对RDD的元素进行分组
    val RDD2: RDD[(String, Iterable[String])] = flatRDD.groupBy(word => word)
    //对分组后的元素再次映射
    val resRDD2: RDD[(String, Int)] = RDD2.map {
      case (word, datas) => {
        (word, datas.size)
      }
    }
    //打印结果
    resRDD2.collect().foreach(println)
    //关闭连接
    sc.stop()
  }


}
