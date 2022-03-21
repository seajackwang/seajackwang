package scala_learning.set

/**
 * Author: laowang
 * Date: 20220319
 * Dese: scala--不可变数组
 */
object scala01_Array {
  def main(args: Array[String]): Unit = {
    //不可变数组new创建
    val arr: Array[Int] = new Array[Int](5)
    //不可变数组apply方法创建
//    val arr2: Array[Int] = Array(1, 2, 3, 4, 5)

    arr(1) = 90
    arr.update(2,18)
//    println(arr(1))
//    println(arr(2))

    //遍历数组
    //方法1 for循序
//    for(i:Int<- 0 to arr.length -1){
//      println(arr(i))
//    }
//    for(i:Int<- 0 until  arr.length){
//      println(arr(i))
//    }
    //方法2 for循序
//    for (elem<-arr){
//      println(elem)
//    }
    //方法3 迭代器
//    val it: Iterator[Int] = arr.iterator
//    while(it.hasNext){
//      println(it.next())
//    }

//    for (elem:Int<-it){
//      println(elem)
//    }
    //方法4 增强for循环
    //从上到下简化输出
//    arr.foreach((elem:Int)=>{println(elem)})
//    arr.foreach((elem:Int)=>println(elem))
//    arr.foreach((elem)=>println(elem))
//    arr.foreach(println(_))
//    arr.foreach(println)

    //方法5 用指定字符连接
//    println(arr.mkString("--"))
//    println(arr.mkString("\n"))

    //向不可变数组添加元素
    //1都是先创建新的数组对象，然后添加元素
    //scala语法中，如果运算符方法中有冒号，并且冒号在后，运算顺序从右到左
    //方法1 +： 在数组头部加元素
//    val newArray: Array[Int] = arr.+:(30)
//    val newArray: Array[Int] = 30 +: arr
//    println(arr.mkString("--"))
//    println(newArray.mkString("--"))

    //方法2 :+在尾部加元素
//    val newArray: Array[Int] = arr.:+(50)
//    val newArray: Array[Int] = arr :+ 50
//    println(arr.mkString("--"))
//    println(newArray.mkString("--"))

  }

}
