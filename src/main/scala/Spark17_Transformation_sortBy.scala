import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author:sww
 * date:2021/10/6
 * desc: 转换算子   sortBy
 * --对RDD中的元素进行 排序
 */
object Spark17_Transformation_sortBy {
  def main(args:Array[String]): Unit={
    //创建程序入口对象SparkContext,设置配置信息SparkConf
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("CreateRDD")

    val sc: SparkContext = new SparkContext(conf)
    val RDD: RDD[Int] = sc.makeRDD(List(1,2,3,4,5,9,68,11,12),3)

    //升序排序
    val RDD2: RDD[Int] = RDD.sortBy(num => num)
    //降序排序
    val RDD3: RDD[Int] = RDD.sortBy(num => -num)
    val RDD4: RDD[Int] = RDD.sortBy(num => num, false)

    //字符串字典排序
    val mkRDD: RDD[String] = sc.makeRDD(List("1", "4", "3", "22"))

    val RDD5: RDD[String] = mkRDD.sortBy(x => x)
    val RDD6: RDD[String] = mkRDD.sortBy(_.toInt,false)
    //打印结果
    RDD6.collect().foreach(println)
    //关闭连接
    sc.stop()
  }


}
