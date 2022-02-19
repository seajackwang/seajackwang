package scala_learning

object math {
  def main(args: Array[String]): Unit = {
    //scala 算术运算
    val a1: Int = 10 / 3
    val a2: Double = 10 / 3
    val a3 = 10.0 / 3
    println(a1, a2, a3)

    val a4 = a1 + a2 + a3
    println(a4)
  }
}
