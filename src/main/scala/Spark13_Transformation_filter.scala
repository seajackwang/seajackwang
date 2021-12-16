import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author:sww
 * date:2021/10/6
 * desc: 转换算子   filter
 * --按指定的过滤规则，对RDD中的元素过滤
 */
object Spark13_Transformation_filter {
  def main(args:Array[String]): Unit={
    //创建程序入口对象SparkContext,设置配置信息SparkConf
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("CreateRDD")

    val sc: SparkContext = new SparkContext(conf)
    val RDD: RDD[String] = sc.makeRDD(List("spark","scala","java","python","Sql"), 2)

    val newRDD: RDD[String] = RDD.filter(_.contains("s"))

    val RDDT = sc.makeRDD(List(1, 2, 3, 4, 5, 8), 2)
    val res: RDD[Int] = RDDT.filter(_ % 2 != 0)

    //打印结果
    res.collect().foreach(println)
    //关闭连接
    sc.stop()
  }


}
