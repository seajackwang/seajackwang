package scala_learning.c07_set

/**
 * Author: laowang
 * Date: 20220319
 * Dese: 基本属性和常用操作
 */
object scala07_fun {
  def main(args: Array[String]): Unit = {
    val list: List[Int] = List(1, 2, 3, 4)
    //1获取集合长度
    println(list.length)
    //2大小
    println(list.size)
    //3循环遍历
    for (i<- 0 until list.length){
      println(list(i))
    }
    //4迭代器
    val it: Iterator[Int] = list.iterator
    for (elem<- it){
      println(elem)
    }
    //5生成字符串
    println(list.mkString("--"))
    //6是否包含
    println(list.contains(2))

  }

}
