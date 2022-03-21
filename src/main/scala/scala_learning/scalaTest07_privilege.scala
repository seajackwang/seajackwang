package scala_learning

object scalaTest07_privilege {
  def main(args: Array[String]): Unit = {
    val p1: Person06 = new Person06
//    println(p1.age)
//    println(p1.sex)
    val p2: Person07 = new Person07
    println(p2.city)
    p2.mm1()
  }

}

class Person07 extends Person06{
  var city:String =  "深圳"
  def mm1(): Unit ={
    println(name)
    println(age)
    println(sex)
  }
}
