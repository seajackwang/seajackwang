package laowang

/*
desc: spark读写mysql方法
 */
import org.apache.spark.sql.{DataFrame, SaveMode, SparkSession}

import java.sql.DriverManager
import java.util.Properties

object MysqlUtil {
  val spark = SparkSession.builder().master("local[*]").appName("ts0601").getOrCreate()
  def saveToTable(dataFrame: DataFrame,dbName:String,tableName:String,deleteSql:String)={
    val prop = new Properties()
    prop.put("user", "root")
    prop.put("password", "Wsp123pg888")

    val url = s"jdbc:mysql://localhost:3306/${dbName}?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC"
    // create database connection
//    val dbc = s"jdbc:mysql://localhost:3306/${dbName}?useSSL=false?user=root&password=Wsp123pg888&serverTimezone=UTC"
    val user = "root"
    val password = "Wsp123pg888"
    classOf[com.mysql.cj.jdbc.Driver]
//    getConnection(url, username, password)
    val conn = DriverManager.getConnection(url,user,password)
    conn.prepareStatement(deleteSql)

    val df = dataFrame.write.mode(SaveMode.Append).jdbc(url,tableName,prop)
  }

  def readTable(spark:SparkSession,dbName:String,tableName:String,selectSql:String)={
    val df = spark.read
      .format("jdbc")
//      .option("driver", "com.mysql.jdbc.Driver")
      .option("driver", "com.mysql.cj.jdbc.Driver")
      .option("url", s"jdbc:mysql://localhost:3306/${dbName}?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC")
      .option("dbtable", s"${tableName}")
      .option("user", "root")
      .option("password", "Wsp123pg888")
      .load()

    df.createTempView("table_tmp")
    val sql =  selectSql.replace(tableName,"table_tmp")
    val df_result = spark.sql(s"${sql}")
//    val url = s"jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC"

    df_result

  }
}
