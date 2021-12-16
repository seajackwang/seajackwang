import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author:sww
 * date:2021/10/6
 * desc: Transformation算子 groupBy
 */
object Spark011_Transformation_groupBY {
  def main(args:Array[String]): Unit={
    //创建程序入口对象SparkContext,设置配置信息SparkConf
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("CreateRDD")

    val sc: SparkContext = new SparkContext(conf)
    val RDD: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4, 5, 6, 7, 8,9), 2)

    println("------groupBy分组前----")
    RDD.mapPartitionsWithIndex(
      (index,datas)=>{
        println(index + "---->" + datas.mkString(","))
        datas
      }
    ).collect()
    val groupByRDD: RDD[(Int, Iterable[Int])] = RDD.groupBy(_ % 3)

    println("-------groupBy分组后-----")
    groupByRDD.mapPartitionsWithIndex(
      (index,datas)=>{
        println(index + "--->" +  datas.mkString(","))
        datas
      }
    ).collect()

    val newRdd: RDD[String] = sc.makeRDD(List("hello", "laowang", "hello", "jingjing"), 2)
    val RDD2 = newRdd.groupBy(k => k)
    RDD2.collect().foreach(println)
    //关闭连接
    sc.stop()
  }


}
