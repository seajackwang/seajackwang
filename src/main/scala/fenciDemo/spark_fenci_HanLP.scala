//package fenciDemo
//
//import com.hankcs.hanlp.HanLP
//import com.hankcs.hanlp.dictionary.CustomDictionary
//import com.hankcs.hanlp.seg.common.Term
//import com.hankcs.hanlp.tokenizer.StandardTokenizer
//import com.sun.javafx.scene.control.skin.Utils
//import javassist.bytecode.analysis.Util
//import sun.management.counter.Units
//
//
//object spark_fenci_HanLP {
//
//  //自定义词库
//  for(b<-brandDict){
//    CustomDictionary.add(b, "nz 1024 n 1")
//  }
//  for(c<-cateDict){
//    CustomDictionary.add(c, "nz 1024 n 1")
//  }
//
//
//
//  //对词库加锁
//  def addCustomWord(){
//    CustomDictionary.dat.synchronized{
//      for(b<-brandDictBC.value){
//        CustomDictionary.add(b, "nz 1024 n 1")
//      }
//      for(c<-cateDictBC.value){
//        CustomDictionary.add(c, "nz 1024 n 1")
//      }
//    }
//  }
//  //每个分区都要添加词库，并设置强制生效
//  def trialIterator(iter: Iterator[(String,String,String,String,String)]) ={
//
//    addCustomWord
//    StandardTokenizer.SEGMENT.enableCustomDictionaryForcing(true)//强制生效
//    //分词逻辑
//    iter.map{
//
//      case (key_word, user_log_acct, request_tm, pvid, skuid)=>
//        val keywordDealed = Utils.sbc2dbcCase(key_word).toLowerCase()
//        val wordArr = HanLP.segment(keywordDealed).toArray().map{
//          case term:Term =>
//            term.word
//        }
//        (key_word,wordArr, user_log_acct, request_tm, pvid, skuid)
//    }
//  }
//
//
//  //主逻辑，调用上面方法
//  val splitKeyword = showLogTable.as[(String,String,String,String,String)]
//    .mapPartitions(trialIterator)
//    .toDF("key_word","key_word_split","user_log_acct","request_tm","pvid","skuid")
//
//
//}
