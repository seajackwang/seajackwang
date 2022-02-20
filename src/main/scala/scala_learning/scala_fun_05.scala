package scala_learning
/**
 * Author: laowang
 * Date: 20220219
 * Dese:高阶函数之函数作为参数返回
 */
object scala_fun_05 {
  def main(args: Array[String]): Unit = {
    //需求提供一个函数，对数组中的元素进行处理，返回一个新的数组
    def OperationArray(arr: Array[Int],op:Int=> Int)={
      //遍历数组
      for (elemt <- arr) yield op(elemt)
    }
    def op(elemt:Int):Int={
      elemt + 1
    }
    //
    val arr = Array(1,2,3,4)
    //调用函数：实现+1
    val newarr: Array[Int] = OperationArray(arr, op)

    //匿名函数调用
    val arr2: Array[Int] = OperationArray(arr, _ * 3)

    println(newarr.mkString(","))
  }
}
