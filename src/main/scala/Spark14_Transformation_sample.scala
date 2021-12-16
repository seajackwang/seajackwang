import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author:sww
 * date:2021/10/6
 * desc: 转换算子   sample
 * --随机取样
 */
object Spark14_Transformation_sample {
  def main(args:Array[String]): Unit={
    //创建程序入口对象SparkContext,设置配置信息SparkConf
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("CreateRDD")

    val sc: SparkContext = new SparkContext(conf)
    val RDD: RDD[Int] = sc.makeRDD(1 to 10)

    /*
    -withReplacement 是否抽样放回
      true 放回
      false 不放回
     -fraction  期望出现 上面true 次数 false 概率
     -seed 抽样算法初始值
     */
    val newRDD: RDD[Int] = RDD.sample(true, 3)

    val newRDD2: RDD[Int] = RDD.sample(false, 0.6)
    val std: List[String] = List("laowang", "小龙", "马码", "dd", "王子为", "胡金泊",
      "徐斐",
      "李海峰",
      "王高鹏",
      "丁晨",
      "张浩然",
      "郭伟",
      "竹永亮",
      "张嘉峰",
      "廖保林",
      "罗翔",
      "夏瑞浩",
      "王振伟",
      "方旭翀",
      "张薄薄",
      "董佳琳",
      "刘俊芃",
      "赵煜",
      "毛兴达",
      "周奇巍",
      "马静",
      "刘阳",
      "刘昊",
      "何成江",
      "曹震",
      "李小龙",
      "郑玄毅")
    val listRDD: RDD[String] = sc.makeRDD(std)
    //从上面的RDD中抽取一名幸运朋友
    val LuckyMan: Array[String] = listRDD.takeSample(false, 1)
    LuckyMan.foreach(println)
    //打印结果
//    newRDD2.collect().foreach(println)
    //关闭连接
    sc.stop()
  }


}
