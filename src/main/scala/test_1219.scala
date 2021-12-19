import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object test_1219 {
  def main(args:Array[String]):Unit={
    //sparkConf
    val conf: SparkConf = new SparkConf().setAppName("workCount").setMaster("local[*]")
    //SparkContext
    val sc: SparkContext = new SparkContext(conf)

//    val RDD: RDD[String] = sc.textFile("src/main/input/1.txt")
//    val newRDD: RDD[String] = RDD.flatMap(_.split(" "))
//    val mapRDD: RDD[(String, Int)] = newRDD.map((_, 1))
//    val res: RDD[(String, Int)] = mapRDD.reduceByKey(_ + _)
//val是声明不可变的变量，var是可变的变量
//    var是一个可变变量，这是一个可以通过重新分配来更改为另一个值的变量。这种声明变量的方式和java中声明变量的方式一样。
//    val是一个只读变量，这种声明变量的方式相当于java中的final变量。一个val创建的时候必须初始化，因为以后不能被改变。
      val a = 10
      println(a)

      var b = 20
      println(b)
      b = 25
      println(b)

//    //输出res
//    res.collect.foreach(println)

    //sleep

    //关闭
    sc.stop()
  }

}
