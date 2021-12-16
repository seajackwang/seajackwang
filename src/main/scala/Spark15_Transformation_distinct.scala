import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author:sww
 * date:2021/10/6
 * desc: 转换算子   distinct
 * --去重
 */
object Spark15_Transformation_distinct {
  def main(args:Array[String]): Unit={
    //创建程序入口对象SparkContext,设置配置信息SparkConf
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("CreateRDD")

    val sc: SparkContext = new SparkContext(conf)
    val RDD: RDD[Int] = sc.makeRDD(List(1,2,3,4,3,3,4,11,2),3)
    RDD.mapPartitionsWithIndex{
      (index,datas)=>{
        println(index +  "--->" + datas.mkString(","))
        datas
      }
    }.collect()
    println("-------------")
    //对RDD中的数据进行去重
    val newRDD: RDD[Int] = RDD.distinct()
    newRDD.mapPartitionsWithIndex{
      (index,datas)=> {
        println(index +  "--->"  +  datas.mkString(","))
        datas
      }
    }.collect()
    //打印结果
//    newRDD2.collect().foreach(println)
    //关闭连接
    sc.stop()
  }


}
