package scala_learning

/**
 * Author: laowang
 * Date: 20220311
 * Dese:存在继承关系，子类对象的创建过程
 *
 */
object scalaTest09_Constructor {
  def main(args: Array[String]): Unit = {
//    val std: Person09 = new Student09() //-->1,3
//  val std1: Person09 = new Student09("laowang",18,"001") //-->1,3,4
val std2: Person09 = new Student09("laowang",18,"001") //子类加上参数继承父类也加上-->1,2,3,4
  }

}

class Person09{
  println("1---父类主构造方法被调用了")
  var name:String = _
  var age:Int = _
  def this(name:String,age:Int){
    this()
    println("2---父类辅助构造方法被调用了")
    this.name = name
    this.age = age
  }
}

class Student09(name:String,age:Int) extends Person09(name, age) {
  println("3---子类主构造方法被调用了")
  var  StdId:String = _

  def this(name:String,age:Int,stdId:String){
    //直接调用主构造方法
    this(name,age)
    println("4---子类辅助构造方法被调用了")
    this.StdId = stdId
  }

//  def this(name:String,age:Int){
//    this(name)
//    println("2---Student08辅助构造方法被调用了")
//    this.name = name
//    this.age = age
//  }
}