package scala_learning.c07_set

/**
 * Author: laowang
 * Date: 20220319
 * Dese: 衍生集合
 */
object scala08_fun {
  def main(args: Array[String]): Unit = {
    val list: List[Int] = List(1, 2, 3, 4, 5, 6)
    //1 获取集合 头
    println(list.head)
    //2 尾:除头以外
    println(list.tail)
    //3 最后一个
    println(list.last)
    //4 初始数据，不包含最后一个
    println(list.init)
    //5 反转
    println(list.reverse)
    //6 取前几元素
    println(list.take(2))//默认从左边开始取
    println(list.takeRight(2))
    //7 去掉前几元素
    println(list.drop(2))
    println(list.dropRight(2))
    //List2
    val list2: List[Int] = List(4, 5, 6, 7, 8, 9)
    //8 并集
//    val newlist: List[Int] = list.union(list2)
//    println(newlist)
    //9 交集
//    val newList: List[Int] = list.intersect(list2)
//    println(newList)
    //10 差集
    println(list.diff(list2))
    //11 拉链
    println(list.zip((list2)))
    //12 滑窗
    for (elem<- list.sliding(2)){
      println(elem)
    }

  }

}
