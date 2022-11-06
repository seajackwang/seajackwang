package scala_learning.c08_match

/**
 * Author: laowang
 * Date: 20220508
 * Dese: 模式匹配扩展案例
 */
object TestMatch03 {
  def main(args: Array[String]): Unit = {
    val list: List[(String, Int)] = List(("a", 1), ("b", 2), ("c", 3))

//    for (elem <- list) {
//      println(elem._1)
//    }
    //特殊模式匹配01,实现上面输出
//    for ((world,count) <- list) {
//      println(world)
//    }
    //特殊模式匹配02,给元组命名
    val (id,name,age): (Int, String, Int) = (100, "jingjing", 18)
    println(name)

    //list的key不变，value*2
//    val newList: List[(String, Int)] = list.map {
//      t =>{
//        (t._1, t._2 * 2)
//      }
//    }
//    println(newList)

    //特殊模式匹配03
//    val newList: List[(String, Int)] = list.map {
//      t =>{
//        t match {
//          case (work,count) => (work,count*2)
//        }
//      }
//    }
//    println(newList)
    //简化
    val newList: List[(String, Int)] = list.map {
          case (work,count) => (work,count*2)
    }
    println(newList)
    //map匿名函数时，必须使用{}

  }

}
