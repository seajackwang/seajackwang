package laowang

/**
 * Author:lawoang
 * Date:20220323
 * Desc:withColumn方法使用
 * withColumn的第二个参数要传入已有列的Column对象，否则会报错；
 * column的表达式只能引用此数据集提供的属性。 添加引用其他数据集的列是错误的
 * //df.withColumn("sno","22")//报错
 * 第二个参数要传入任意参数值：
 *   * def lit(literal : scala.Any) : org.apache.spark.sql.Column
 *    sql.functions.lit()函数,返回的也是列对象，可以传入任意参数值；
 *    上面函数来辅助使用：
 *      df.withColumn("sno",lit("22"))
 *  列对象：' 、$ 、col 、column
 */
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{col, column, lit, substring, when}
import org.apache.spark.{SparkConf, SparkContext}

object DROP_Withcolumns {
  def main(args: Array[String]): Unit = {
    //注意local[*]这里local里首字母是小写
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("Createdf")

    val sc: SparkContext = new SparkContext(conf)
    val RDD: RDD[String] = sc.textFile("D:\\桌面\\test001.xlsx")

//    println("aaaaa")
    val spark = SparkSession.builder().getOrCreate()
    import spark.implicits._
    val df = RDD.toDF()
    val ds = 20220323
    val tableData= spark.read.option("inferschema", "true")
      .option("header", "true")
      .option("encoding", "gbk")
      .csv("D:\\Temp\\testdata.csv")
      .withColumn("ds",lit(ds))
//      .csv("D:\\data\\csv\\stats_order_has_gone.csv")

    val df_hh = tableData.withColumn("member_id",col("create_time"))
      .drop("create_time")
      .withColumnRenamed("member_id","create_time")
      .withColumn("create_date",substring(col("create_date"),1,10))
    df_hh.show(20)

    val df_t2 = df_hh.withColumn("parent_order_no2",when(col("parent_order_no").contains("5L6659"),lit(0)).otherwise(col("parent_order_no")))
      .withColumn("parent_order_no3",col("parent_order_no").cast("bigint"))

    df_t2.show()
    df_t2.printSchema()
    //列对象：' 、$ 、col 、column
//    tableData.withColumn("member_id",'ds+1).show()
//    tableData.withColumn("member_id",$"ds").show()
//    tableData.withColumn("member_id",col("ds")+2).show()
//    tableData.withColumn("member_id",column("ds")+3).show()






  }
}
