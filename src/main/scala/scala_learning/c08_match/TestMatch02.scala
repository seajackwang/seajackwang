package scala_learning.c08_match

/**
 * Author: laowang
 * Date: 20220508
 * Dese: 模式匹配
 */
object TestMatch02 {
  def main(args: Array[String]): Unit = {
    //01匹配常量
    def describess(x:Any)= x match {
      case 5 => "Int 5"
      case "hello" => "String hello"
      case true => "Boolean true"
      case '+' => "char +"
    }

    //02匹配类型
    def describess2(x:Any)= x match {
      case i:Int => "Int"
      case s:String => "String"
      case l:List[String] => "list"
      case c:Array[String] => "Array[String]"
      case someThing => "something else" + someThing
    }
//    println(describess(5))
//    println(describess2(List(2,4,5)))
    //List[String] ,传入List(2,4,5))也能匹配上
    //因为list有泛型擦除，而Array它没有
    //03匹配数组
    for (arr <- List(
          Array(0),
          Array(1,0),
          Array(0,1,0),
          Array(1,1),
          Array(0,1,1,0,1),
          Array(1,1,1,1),
          Array("hello",90) //两个元素
    )){
      val result: String = arr match {
        case Array(0) => "0" //匹配Array(0) 这个数组
        case Array(x, y) => x + "," + y //匹配有两个元素的数组并赋值x,y
        case Array(0, _*) => "以零开头的数组"
        case _ => "something else Aarry"
      }
//      println("arr:"+result)
    }

    //04匹配列表 方法1和数组类似
    //    方法2
    val list: List[Int] = List(1, 2, 3, 5, 7, 8)
    list match {
      case first :: second :: rest => println(first + "-" + second +"-"+ rest)
      case _ => println("something else")
    }

    //05匹配元组
    for (tuple <- List(
      (1,0),
      (0,1),
      (1,1),
      (0,1,1,0,1),
      (1,1,1,1),
      ("hello",90) //两个元素
    )){
      val result1: String = tuple match {
        case (0,_) => "0"
        case (y,0) => "0结尾的2个元素元组" + y + "0"
        case (x,y,z) => "3个元素元组"
        case _ => "something else tuple"
      }
      println("tuple:"+result1)
    }

  }

}
