package scala_learning

/**
 * Author: laowang
 * Date: 20220311
 * Dese:构造器
 *    *构造方法
 *    --构造对象
 *    --初始化属性
 *    scala构造器：
 *      *主构造方法：
   *      >在申明类的同时，定义了主构造方法
   *      >一个类中，主构造方法只能有一个
 *      *辅助构造方法：
 *        >方法名必须是this
 *        >在辅助构造方法开始必须直接或间接调用主构造方法
 *
 *      JAVA中不同，scala中有主构造方法和辅助构造方法
 *
 */
object scalaTest08_Constructor {
  def main(args: Array[String]): Unit = {
    //        val student0: Student08 = new Student08
    //        println(student0.age)
    //    val jingjing: Student08 = new Student08("jingjing")
    //    println(jingjing.name)
    val ds: Student08 = new Student08("saobao", 28)
    println(s"you are ${ds.name},今年${ds.age}岁")
  }

}

class Student08{
  println("0---Student08主构造方法被调用了")
  var name:String =  _
  var age:Int = _

  def this(name:String){
    //直接调用主构造方法
    this()
    println("1---Student08辅助构造方法被调用了")
    this.name = name
  }

  def this(name:String,age:Int){
    this(name)
    println("2---Student08辅助构造方法被调用了")
    this.name = name
    this.age = age
  }
}