package fenciDemo
import org.ansj.domain.{Result, Term}
import org.ansj.recognition.impl.StopRecognition
import org.ansj.splitWord.analysis.{BaseAnalysis, IndexAnalysis, NlpAnalysis, ToAnalysis}
import org.ansj.library._

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Ansj_take {

  //自定义分词方法
  def getWords(text: String, filter: StopRecognition): ArrayBuffer[String] = {
    val words = new mutable.ArrayBuffer[String]()
    val terms: java.util.List[Term] =  ToAnalysis.parse(text).recognition(filter).getTerms
    for (i <- 0 until terms.size()) {
      val word = terms.get(i).getName
      if (word.length >= 2) {
        words += word
      }
    }
    words
  }
  //自定义停用词，默认加新增x
  def filter(stopWords: Array[String]): StopRecognition = {
    // add stop words 增加停用词，分词过滤它
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

  //自定义字典
  // 增加新词,中间按照'\t'隔开
  //  UserDefineLibrary.insertWord("ansj中文分词", "userDefine", 1000)
  //  List<Term> terms = ToAnalysis.parse("我觉得Ansj中文分词是一个不错的系统!我是王婆!")
  //  System.out.println("增加新词例子:" + terms)
  // 删除词语,只能删除.用户自定义的词典
  //  UserDefineLibrary.removeWord("ansj中文分词")
  //  terms = ToAnalysis.parse("我觉得ansj中文分词是一个不错的系统!我是王婆!")

  //  用户自定义词典
  //  Ansj目前支持以下的公户自定义词典的操作方式.
  //    从文件中加载词典
  //  配置文件
  //  编码路径
  //  从内存操作词典
  //  增加
  //  删除
  //  修改
  //  设置辞典路径
  //  第一种.正规方式:创建library.properties 中增加
  //  #path of userLibrary
  //  userLibrary=library/userLibrary/userLibrary.dic
  //  ambiguityLibrary=/library/ambiguity.dic
  //  第二种 在用词典未加载前可以通过,代码方式方式来加载
  //  MyStaticValue.userLibrary=[你的路径]
  //  第三种,调用api加载.在程序运行的任何时间都可以.动态价值
  //  loadLibrary.loadLibrary(String path)方式加载


  //主函数，调用分词方法进行分词
  def main(args: Array[String]): Unit = {
    //1、使用自定义方法
    val rec: StopRecognition = filter(Array(",", "天气"))
    val text = "今天天气真好,天气aa情况"
    println(getWords(text, rec).mkString("==="))
    //2、使用IndexAnalysis 索引分词
    val text2 = "上海虹桥机场南路"
    val result: Result = IndexAnalysis.parse(text2)
    //    val result1: Result = IndexAnalysis.parse(text)
    println(result)
    //3、BaseAnalysis --基本分词
    println(BaseAnalysis.parse(text))
    //4、ToAnalysis 精准分词
    val result2: Result = ToAnalysis.parse("让战士们过一个欢乐祥和的新春佳节。")
    println(result2)
    //4、NlpAnalysis 分词适合：语法实体名抽取.未登录词整理
    val result3: Result = NlpAnalysis.parse("洁面仪配合洁面深层清洁毛孔 清洁鼻孔面膜碎觉使劲挤才能出一点点皱纹 脸颊毛孔修复的看不见啦 草莓鼻历史遗留问题没辙 脸和脖子差不多颜色的皮肤才是健康的 长期使用安全健康的比同龄人显小五到十岁 28岁的妹子看看你们的鱼尾纹")
    println(result3)

  }
}
