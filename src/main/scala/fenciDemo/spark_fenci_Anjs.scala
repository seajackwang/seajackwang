package fenciDemo

import org.ansj.domain.Term
import org.ansj.library.DicLibrary
import org.ansj.recognition.impl.StopRecognition
import org.ansj.splitWord.analysis.{DicAnalysis, ToAnalysis}
import org.apache.spark.sql.SparkSession
import org.nlpcn.commons.lang.tire.domain.Forest

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object spark_fenci_Anjs {
  //  DicAnalysis, ToAnalysis等类没有序列化
  //  需要继承序列化接口
  case class myAnalysis() extends DicAnalysis with Serializable

  private val ms: myAnalysis = new myAnalysis()
//  //自定义词库
//  val forest = DicLibrary.get()
//  if(forest == null){
//    DicLibrary.put(DicLibrary.DEFAULT, DicLibrary.DEFAULT, new Forest())
//  }
//  for(b<-brandDict){
//    DicLibrary.insert(DicLibrary.DEFAULT, b, "n", 1)
//  }
//  for(c<-cateDict){
//    DicLibrary.insert(DicLibrary.DEFAULT, c, "n", 1)
//  }
//
//  // 自定义词库和停用词等，需要通过广播将词表发送给各节点
//  private val spark: SparkSession = SparkSession.builder().getOrCreate()
//  val stopBC = spark.sparkContext.broadcast(stopBC)
//  val dicBC = spark.sparkContext.broadcast(DicLibrary.get(DicLibrary.DEFAULT))
//  val parse = DicAnalysis.parse(keywordDealed, dicBC.value).recognition(stopBC.value)
//  // 抽取分词结果，不附带词性
//  val words = for(i<-Range(0,parse.size())) yield parse.get(i).getName
//  val filterWords: Seq[String] = words.map(_.trim).filter(x => x.length > 1)


  //2停用词过滤
  def filter(stopWords: Array[String]): StopRecognition = {
    // add stop words
    val filter = new StopRecognition
    filter.insertStopNatures("w") // filter punctuation
    filter.insertStopNatures("m") // filter m pattern
    filter.insertStopNatures("null") // filter null
    filter.insertStopNatures("<br />") // filter <br />
    filter.insertStopRegexes("^[a-zA-Z]{1,}") //filter English alphabet
    filter.insertStopRegexes("^[0-9]+") //filter number
    filter.insertStopRegexes("[^a-zA-Z0-9\\u4e00-\\u9fa5]+")
    filter.insertStopRegexes("\t")
    for (x <- stopWords) {
      filter.insertStopWords(x)
    }
    filter
  }


  //3分词
  def getWords(text: String, filter: StopRecognition): ArrayBuffer[String] = {
    val words = new mutable.ArrayBuffer[String]()
    val terms: java.util.List[Term] = ToAnalysis.parse(text).recognition(filter).getTerms
    for (i <- 0 until terms.size()) {
      val word = terms.get(i).getName
      if (word.length >= 2) {
        words += word
      }
    }
    words
  }


  def main(args: Array[String]): Unit = {
    val text = "你是老王 , 哈哈，小子不粗 good boy sos勒! null有你 w 28岁了 m \t"
    val filter_a = filter(Array("o", "s"))
    println(getWords(text, filter_a).mkString("--"))
  }

}
