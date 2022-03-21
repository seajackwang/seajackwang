package scala_learning


/**
 * Author: laowang
 * Date: 20220226
 * Dese: 万物皆对象
 * 对大量对象共性做个抽象叫抽象类
 * 类和对象：
 *  --有什么：属性
 *  --能做社么：方法
 *  -属性和方法定义在类中，但属于每一个对象
 *
 *  在Scala和JAVA语言中，类是创建对象的模板
 *
 *  pakage 包
 *  import --类名 extend 父类 implements 接口
 *  class --定义类
 *      --属性
 *      --方法
 *      --构造方法  --创建对象的构造方法
 */
object scala_test_object {
  def main(args: Array[String]): Unit = {
//    val std = new Student
//    println(std.name)
//    std.study()

    val std2 = new Student()
    std2.name = "laowang"
    std2.study()
  }

  //定义类
  class Student{
    var name = "jingjing"
    def study(): Unit ={
      println(s"${name}正在学习")
    }
  }

}
