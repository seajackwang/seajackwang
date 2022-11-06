package scala_learning.c07_set

/**
 * Author: laowang
 * Date: 20220319
 * Dese: 集合计算：
 *          --1简化归约: 函数聚合操作
 *            --reduce  底层是调用reduceLeft,函数参数和返回值要一致
 *            --reduceLeft  函数参数和返回值可以不一致
 *            --reduceRight 函数参数和返回值可以不一致
 *          --2折叠
 *
 */
object scala_10_fun_lastke {
  def main(args: Array[String]): Unit = {
    //1、简化归约：集合内部元素聚合；函数有：reduce、reduceLeft 、reduceRight
    val list: List[Int] = List(1, 2, 3, 4)
//    val ab: Int = list.reduce((a: Int, b: Int) => {
//      a + b
//    })
    //加法
    val ab: Int = list.reduce(_ + _)
//    println(ab)

    val aba: Int = list.reduceLeft(_ + _) //从左开始运算
//    println(aba)

    val abb: Int = list.reduceRight(_ + _) // 集合先反转，再从右开始运算
//    println(abb)
//    println(list.sum)
    //减法
    val absub: Int = list.reduceLeft(_ - _)
    println(absub)
    val absub2: Int = list.reduceRight(_ - _)
    //实际执行迭代相减 head\tail：(1 -  (2-(3-4))) //可以理解为反转 4，3，2，1=> (a,b)=>{b- a}
    println(absub2)

    val newList: List[Int] = List(3, 4,5, 8, 10)
    val newSub: Int = newList.reduceLeft(_ - _)
    val newSub2: Int = newList.reduceRight(_ - _)
    println(newSub)
    println(newSub2)

    //2、折叠： 集合外部元素和集合内部元素聚合
    val f1: Int = newList.fold(10)(_ + _)
    println(f1)

    val f2: Int = newList.foldLeft(10)(_ + _)
    val f3: Int = newList.foldRight(10)(_ - _)
      //10 (10,8,5,4,3)
    println(f2 + "&&" + f3)
  }
}
