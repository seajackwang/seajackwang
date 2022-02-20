package scala_learning

/**
 * Author: laowang
 * Date: 20220220
 * Dese:高阶函数之函数作为返回值返回
 */
object scala_fun_06 {
  def main(args: Array[String]): Unit = {
    def f1():(Int)=>Int={
      val a =  10

      def f2(b:Int):Int={
        a +  b
      }
      f2 _
    }
    //调用方法1：直接调用
//    println(f1()(20))

    //调用方法2：定义ff=f2函数
    val ff:Int=>Int=f1()
//    println(ff(20))

    //闭包 f1函数调用执行，进栈执行后，f1函数释放内存，其局部变量生命周期会延长，与内部函数f2形成的对象叫闭包
    //闭包 = 变量 + 内部函数
    //f2和f1不是包含关系，f1执行只是声明了函数f2，只有调用函数才会进栈，分配栈帧。

    def f3():(Int)=>Int={
      val a =  10
      (b:Int)=> a + b
    }

//    println(f3()(20))

    //柯里化:执行是转换成f3结构执行
    def f4()(b:Int):Int={
      val a =  10
      a + b
    }

    println(f4()(20))
  }

}
