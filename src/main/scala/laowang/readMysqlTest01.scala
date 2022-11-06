package laowang

import org.apache.spark.sql.SparkSession

object readMysqlTest01 {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder().master("local[*]").appName("ts0601").getOrCreate()
    val df = MysqlUtil.readTable(spark,"test","student2","select name,subject,score from student2 where id is  not null")
    df.show(20)

    MysqlUtil.saveToTable(df,"test","student_score","delete from student_score where name = '大花' and subject = '英语'")
  }

}
