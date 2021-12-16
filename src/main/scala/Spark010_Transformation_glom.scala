import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author:sww
 * date:2021/10/6
 * desc: Transformation算子 glom
 */
object Spark010_Transformation_glom {
  def main(args:Array[String]): Unit={
    //创建程序入口对象SparkContext,设置配置信息SparkConf
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("CreateRDD")

    val sc: SparkContext = new SparkContext(conf)
    //默认分区
    val RDD: RDD[Int] = sc.makeRDD(List(1,2,3,4,5,6),2)
    println("----------没glom之前 -------")
    RDD.mapPartitionsWithIndex(
      (index,datas)=>{
        println(index + "--->"+ datas.mkString(","))
        datas
      }
    ).collect()

    println("--------glom之后-------")
    val newRDD: RDD[Array[Int]] = RDD.glom()
    newRDD.mapPartitionsWithIndex(
      (index,datas)=> {
        println(index  +  "--->" + datas.next().mkString(","))
        datas
      }
    ).collect()

//    newRDD.collect().foreach(println)
    //关闭连接
    sc.stop()
  }


}
