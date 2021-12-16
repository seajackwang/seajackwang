import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author:sww
 * date:2021/10/6
 * desc: 01通过读取外部文件，创建RDD
 * 02读取内存集合中的数据创建RDD
 */
object Spark02_CreateRDD_file {
  def main(args:Array[String]): Unit={
    //创建程序入口对象SparkContext,设置配置信息SparkConf
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("CreateRDD")

    val sc: SparkContext = new SparkContext(conf)
    //方法一：从本地文件读取
    val RDD: RDD[String] = sc.textFile("src/main/input/ts.txt")
    //方法二：hdfs服务器读取数据
    val newRDD: RDD[String] = sc.textFile("hdfs://hadoop100:8020/input")

    //方法3
    val list: List[Int] = List(20, 19, 18)

    val RDD3: RDD[Int] = sc.parallelize(list)

    //打印输出
    RDD3.collect().foreach(println)
    //关闭连接
    sc.stop()
  }


}
