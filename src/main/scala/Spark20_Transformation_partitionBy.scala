import org.apache.spark.rdd.RDD
import org.apache.spark.{Partitioner, SparkConf, SparkContext}

/**
 * Author:sww
 * date:2021/10/6
 * desc: partitionBy算子
 */
object Spark20_Transformation_partitionBy {
  def main(args:Array[String]): Unit={
    //创建程序入口对象SparkContext,设置配置信息SparkConf
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("partitionBy")

    val sc: SparkContext = new SparkContext(conf)

    //读取外部文件
    val RDD: RDD[(Int, String)] = sc.makeRDD(List((1, "aaa"), (2, "bbb"), (3, "ccc")), 3)

    RDD.mapPartitionsWithIndex{
      (index,datas)=>{
        println(index+ "---"+ datas.mkString(","))
        datas
      }
    }.collect()

    println("--------->>>>>>>------")
    val newRDD = RDD.partitionBy(new MyPartitioner(2))

    newRDD.mapPartitionsWithIndex{
      (index,datas)=>{
        println(index+ "---"+ datas.mkString(","))
        datas
      }
    }.collect()
    Thread.sleep(10000)
    //关闭连接
    sc.stop()
  }


}
//自定义分区 器
class  MyPartitioner(partitions:Int)extends Partitioner{
  override def numPartitions: Int = partitions

  override def getPartition(key: Any): Int = {
//    val key: String = key.asInstanceOf[]
//
//    if(key.startsWith("1")) {
//      0
//    } else {
//      1
//    }
    1
  }

}