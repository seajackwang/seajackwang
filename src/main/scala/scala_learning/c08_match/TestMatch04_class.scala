package scala_learning.c08_match

/**
 * Author: laowang
 * Date: 20220508
 * Dese: 匹配对象
 */
//对象
class User(var name:String,var age:Int){}
//伴生对象
object User{
  //根据属性创建对象
  def apply(name:String,age:Int):User = new User(name,age)
  //根据对象返回其属性
  def unapply(user:User) = {
    if(user == null){
      None
    } else {
      Some(user.name,user.age)
    }
  }
}
object TestMatch04_class {
  def main(args: Array[String]): Unit = {
    val jj: User = User("jingjing", 18)

    val res: String = jj match {
      case User("bangzhang", 28) => "gg"
      case User("jingjing", 28) => "Yes"
      case _ => "no"
    }
    println(res)
  }

}
