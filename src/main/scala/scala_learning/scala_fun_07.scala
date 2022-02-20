package scala_learning

/**
 * Author: laowang
 * Date: 20220220
 * Dese:通过递归求一个整数阶乘
 */
object scala_fun_07 {
  def main(args: Array[String]): Unit = {
    println(jc(5))
  }
  def jc(n:Int):Int={
    if (n==1){
      return 1
    }
    n * jc(n-1)
  }
  //这里两个return，只能省略后面那个.if返回1代码未结束，最后一段代码默认是返回值

}
