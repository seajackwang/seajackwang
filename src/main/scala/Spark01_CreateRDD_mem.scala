import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author:seajeak
 * date:2021/10/6
 * desc: 通过读取集合众的数据创建RDD
 */
object Spark01_CreateRDD_mem {
  def main(args:Array[String]): Unit={
    //创建程序入口对象SparkContext,设置配置信息SparkConf
    //注意local[*]这里local里首字母是小写
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("CreateRDD")

    val sc: SparkContext = new SparkContext(conf)

    val list: List[Int] = List(1, 2, 3, 4, 5)

    //集合创建RDD 方式一
    val rdd: RDD[Int] = sc.parallelize(list)

    //方式二
    val rdd2: RDD[Int] = sc.makeRDD(list)

    rdd2.collect().foreach(println)
    //关闭连接
    sc.stop()
  }


}
