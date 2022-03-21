package laowang

object DateUtil {
  def main(args: Array[String]): Unit = {
    //传入参数测试结果
    val ds = "201910"
    println(getLastYearMonth(ds))
    println(getLastMonth(ds))

  }
  /**
   * 获取同比上月
   *
   * @param dataTime
   * @return
   */
  def getLastYearMonth(dataTime:String):String={
    val year= dataTime.substring(0,4)
    val month=dataTime.substring(4,6)
    println(s"year: $year")
    println(s"month: $month")

    val year_last=(Integer.parseInt(year)-1).toString
    val result = year_last+month
    //      String result=year+month
    println(s"===>获取到同比上月:${result}")
    result
  }

  //获取上月时间
  def getLastMonth(dataTime:String): String = {
    var year= dataTime.substring(0,4)
    var month=dataTime.substring(4,6)
    println(s"year: $year")
    println(s"month: $month")

    if(month.startsWith("0")||month.equals("10")){
      if(month.equals("01")){
        month ="12"
        year=(Integer.parseInt(year)-1).toString
      }else{
        month = "0"+(Integer.parseInt(month)-1)
      }
    }else{
      month=(Integer.parseInt(month)-1).toString
    }
    val  result= year+month
    println(s"===>获取到环比上月:${result}")
    result
  }

}
