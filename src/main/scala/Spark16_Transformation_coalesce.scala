import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author:sww
 * date:2021/10/6
 * desc: 转换算子   coalesce
 * --重新分区  默认不执行shuffle
 * 和repartition一样，其底层调用就 是coalesce,默认 执行shuffle
 */
object Spark16_Transformation_coalesce {
  def main(args:Array[String]): Unit={
    //创建程序入口对象SparkContext,设置配置信息SparkConf
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("CreateRDD")

    val sc: SparkContext = new SparkContext(conf)
    val RDD: RDD[Int] = sc.makeRDD(List(1,2,3,4,5,9,68,11,12),3)
    RDD.mapPartitionsWithIndex{
      (index,datas)=>{
        println(index +  "--->" + datas.mkString(","))
        datas
      }
    }.collect()
    println("-------------")
    //缩进分区
val newRDD: RDD[Int] = RDD.coalesce(2,true)

    newRDD.mapPartitionsWithIndex{
      (index,datas)=>{
        println(index +  "--->" + datas.mkString(","))
        datas
      }
    }.collect()
    //扩大分区
    val reRDD: RDD[Int] = RDD.repartition(4)
    reRDD.mapPartitionsWithIndex{
      (index,datas)=>{
        println(index +  "--->" + datas.mkString(","))
        datas
      }
    }.collect()
    //打印结果
//    newRDD.collect().foreach(println)
    //关闭连接
    sc.stop()
  }


}
