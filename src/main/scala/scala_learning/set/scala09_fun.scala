package scala_learning.set

/**
 * Author: laowang
 * Date: 20220319
 * Dese: 集合计算函数
 */
object scala09_fun {
  def main(args: Array[String]): Unit = {
    //初级函数
    val list: List[Int] = List(1, 2, 3, 4)
    //1求和
//    println(list.sum)
    //乘积
//    println(list.product)
    //最大值
//    println(list.max)
    //最小值
//    println(list.min)
    //排序:sorted、sortby、sortwith
    val newList: List[Int] = List(9, 8, 2, 3, 5, 12)
    //默认升序，sorted、sortby需降序加上反转reverse
//    println(newList.sorted)
//    println(newList.sorted.reverse)
    val newList2: List[Int] = newList.sortBy(elem => elem)
//    println(newList2)
//    val newList3: List[Int] = newList.sortWith((a: Int, b: Int) => (a > b))
val newList3: List[Int] = newList.sortWith((_ < _))
//    println(newList3)

    //高级函数
    //过滤filter
    println(newList.filter(_ % 2 == 0))
    //转化映射map
    println(newList.map(_ * 2))
    //扁平化实现 ：：：或者 flat
    val listx: List[List[Int]] = List(List(1, 2, 5, 6), List(7, 8, 2))
    //    val listFlat: List[Int] = listx.flatten
    //    println(listFlat)
        //扁平化+ 映射
    val ls: List[String] = List("hello laowang", "hello jingjing", "hello laozhang", "big laowang")
    val ls2: List[String] = ls.flatMap(_.split(""))
    println(ls2)
    //分组
  }
}
