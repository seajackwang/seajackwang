package scala_learning.set

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
 * Author: laowang
 * Date: 20220319
 * Dese: 可变数组
 */
object scala02_ArrayBufer {
  def main(args: Array[String]): Unit = {
    //创建可变数组
    //    val arr: ArrayBuffer[Int] = new ArrayBuffer[Int]()
    val arr: ArrayBuffer[Int] = ArrayBuffer(10, 20, 23)
    println(arr(2))

    //访问数组，对数组元素进行修改
//    println(arr(1))
//    arr.update(1,11)
//    println(arr(1))

    //向数组添加元素  建议不可变用符合，可变用方法
//    val newarr: arr.type = arr.+=(20)
//    println(arr.mkString("--"))
//    println(newarr.mkString("--"))
//    arr.append(20)
//    arr.insert(0,19)
//    println(arr.mkString("--"))

    //可变数组创建新对象数组
//    val newArray= arr. +:(20) //不在原数组上修改，创建新数组
//    println(arr.mkString("--"))
//    println(newArray.mkString("--"))


    //可变和不可变数组之间转换
//    val newArr: Array[Int] = arr.toArray
//    val buffer: mutable.Buffer[Int] = newArr.toBuffer
//    println(buffer(1))
//    val ints: List[Int] = List(1, 2, 3)
//    val set1: mutable.Set[Int] = mutable.Set(2, 3, 4, 5)



  }

}
