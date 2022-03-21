package scala_learning.set

/**
 * Author: laowang
 * Date: 20220319
 * Dese: 元组
 *      --()
 */
object scala06_tuple {
  def main(args: Array[String]): Unit = {
    //创建元组
    //数据类型 ：Int/String/函数：(参数类型):=>{返回值类型}/代码块：=>{返回值类型}/元组：(类型...)
    val tt: (String, String, Int) = ("100", "jingjing", 18)
    //访问元组元素
//    println(tt._1)
//    println(tt._2)
//    println(tt._3)

    //通过索引访问
//    println(tt.productElement(2))
    //迭代器
    for (elem<- tt.productIterator){
      println(elem)

    }
    //map是键值对其实是特殊的元组，个数是2的元组，称为对偶
  }
}
