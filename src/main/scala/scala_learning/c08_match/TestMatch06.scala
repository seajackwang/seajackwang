package scala_learning.c08_match

/**
 * Author: laowang
 * Date: 20220508
 * Dese: 偏函数使用
 */
object TestMatch06 {
  def main(args: Array[String]): Unit = {
    //需求：将集合中Int类型元素+1，字符串类型元素去掉
    val list: List[Any] = List(1, 2, 3, 4, "test", 5, 6)

    //过滤掉字符串
    val newList: List[Any] = list.filter(_.isInstanceOf[Int])
    val res: List[Int] = newList.map {
//      elem => {
//        elem.asInstanceOf[Int] + 1
//        elem.toString.toInt + 1

//      }
      case a:Int => a + 1
    }
//    println(res)

    //偏函数 pf
    list.collect{case elem:Int => elem + 1}.foreach(println)
    val listpf: List[Int] = list.collect { case elem: Int => elem + 1 }
    println(listpf)
  }

}
