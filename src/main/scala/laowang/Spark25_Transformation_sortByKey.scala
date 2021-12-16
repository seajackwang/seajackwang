package laowang

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author:sww
 * date:2021/10/6
 * desc: sortByKey
 */
object Spark25_Transformation_sortByKey {
  def main(args:Array[String]): Unit={
    //创建程序入口对象SparkContext,设置配置信息SparkConf
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("Wc")

    val sc: SparkContext = new SparkContext(conf)

    val RDD: RDD[(String, Int)] = sc.makeRDD(List(("jingjing", 100), ("behui", 79), ("jingjing", 93), ("behui", 65), ("behui", 76)))

    val sortRDD: RDD[(String, Int)] = RDD.sortByKey(false) //默认升序 ，false降序

    val ss: List[(Student, Int)] = List(
      (new Student("jingjing", 18), 1),
      (new Student("laowang", 20), 1),
      (new Student("laozhang", 28), 1),
      (new Student("songdaomao", 30), 1)
    )
    val listRDD: RDD[(Student, Int)] = sc.makeRDD(ss)

    val resRDD: RDD[(Student, Int)] = listRDD.sortByKey()
    //输出
    resRDD.collect().foreach(println)

    //关闭连接
    sc.stop()
  }


}

class Student(var name:String,var age:Int) extends Ordered[Student]  with  Serializable{
  //指定比较规则
  override def compare(that:Student):Int={
    //先按名称升序，再按年龄降序
    var res: Int = this.name.compareTo(that.name)
    if(res == 0){
      res = that.age - this.age
    }
    res
  }

  override def toString = s"Student($name,$age)"
}