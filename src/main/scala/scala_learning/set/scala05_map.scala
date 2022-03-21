package scala_learning.set


/**
 * Author: laowang
 * Date: 20220319
 * Dese: map集合
 *      --(key -> value)
 */
object scala05_map {
  def main(args: Array[String]): Unit = {
    //不可变map创建，底层是HashMap
    val map: Map[String, Int] = Map(("a" -> 1), ("b" -> 3))
    val map2 = Map(("ab", 11), ("bc", 23),("dd",None))

    //遍历map
//    map.foreach((kv:(String,Int))=>{println(kv)})
//    map2.foreach(println)

    //key获取map中所有keys
    for (key<-map.keys){
      println(key + "====>" + map.get(key).get) //get(key)对应value有值是some(值),无值时None（避免空指针异常）

    }

    //get(key)对应value有值是some(值),无值时None（避免空指针异常）
    //还可提供默认值
    println(map.get("a").getOrElse(0))
    println(map.get("dd").getOrElse(0))
  }
}
