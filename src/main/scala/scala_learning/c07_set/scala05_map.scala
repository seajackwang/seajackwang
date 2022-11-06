package scala_learning.c07_set

import scala.collection.mutable


/**
 * Author: laowang
 * Date: 20220319
 * Dese: map集合
 *      --(key -> value)
 */
object scala05_map {
  def main(args: Array[String]): Unit = {
    //1、不可变map创建，底层是HashMap
    val map: Map[String, Int] = Map(("a" -> 1), ("b" -> 3))
    val mapp = Map(("ab", 11), ("bc", 23),("dd",None))

    //遍历map
//    map.foreach((kv:(String,Int))=>{println(kv)})
//    map2.foreach(println)

    //key获取map中所有keys
    for (key<-map.keys){
      println(key + "====>" + map.get(key).get) //get(key)对应value有值是some(值),无值时None（避免空指针异常）

    }

    //get(key)对应value有值是some(值),无值时None（避免空指针异常）
    //还可提供默认值
//    println(map.get("a").getOrElse(0))
//    println(map.get("dd").getOrElse(0))

    //2可变map集合
    val map1: mutable.Map[String, Int] = mutable.Map("a" -> 1, "b" -> 2, "c" -> 3)
    val map2: mutable.Map[String, Int] = mutable.Map("a" -> 4, "b" -> 5, "d" -> 6)
    //两个map集合聚合，使用折叠：foldLeft函数
    //非集合内部聚合，故选择折叠foldLeft函数更合适
    //最终效果 Map("a" -> 5, "b" -> 7, "c" -> 3,"d" -> 6)
    val mm: mutable.Map[String, Int] = map1.foldLeft(map2) {
          //mm参数是值map2,kv是mp1中的kv键值对
      (mm, kv) => {
        val k = kv._1
        val v = kv._2
        //根据mp1的key,到map2获取值，再相加value
        mm(k) = mm.getOrElse(k, 0) + v
      }
        mm
    }
    println(mm)

  }
}
