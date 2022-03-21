package scala_learning

object scalaTest06_Privilege {
  def main(args: Array[String]): Unit = {
    val p0: Person06 = new Person06
    println(p0.age)
    println(p0.sex)
    p0.m1()
  }

}

class Person06{
  private var idCard = "10000"  //私有的
  protected var name = "laowang"   //受保护的
  private[scala_learning] var age:Int = 28  //私有的，加上在指定包下可访问
  var sex = "男"   //默认是public

  def m1(): Unit ={
    println(idCard)
    println(name)
    println(age)
    println(sex)
  }
}
