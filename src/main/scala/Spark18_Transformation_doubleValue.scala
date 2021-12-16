import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author:sww
 * date:2021/10/6
 * desc: 转换算子   双value类型
 * --合集 union
 * --交集 intersect -->intersection
 * -- 差集 diff --> subtract
 * --拉链 zip
 */
object Spark18_Transformation_doubleValue {
  def main(args:Array[String]): Unit={
    //创建程序入口对象SparkContext,设置配置信息SparkConf
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("CreateRDD")

    val sc: SparkContext = new SparkContext(conf)
    val RDD1: RDD[Int] = sc.makeRDD(List(1,2,3,4),2)
    val rdd2: RDD[Int] = sc.makeRDD(List(4,5, 6, 7), 2)

    //合集
//    val newRDD: RDD[Int] = RDD1.union(rdd2)
    //交集
//    val newRDD: RDD[Int] = RDD1.intersection(rdd2)

    //差集
//    val newRDD: RDD[Int] = rdd2.subtract(RDD1)

    //拉链
    //要求分区数一致，分区中元素的个数必须一致
    val newRDD: RDD[(Int, Int)] = RDD1.zip(rdd2)
    //打印结果
    newRDD.collect().foreach(println)
    //关闭连接
    sc.stop()
  }


}
