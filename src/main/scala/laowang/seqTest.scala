package laowang

object seqTest {
  def main(args: Array[String]): Unit = {
    val ds = 20220323
//    val seq_d = Seq((ds to ds).toArray.map("p_" + _.toString))
    val seq_d2 = (ds to ds).toArray.map("p_" + _.toString).toSeq

    val stat_seq = (ds + "00").toInt
    val end_seq = (ds + "23").toInt
    val part_seq = (stat_seq to end_seq).toArray.map("p_" + _.toString).toSeq

//    println(seq_d.mkString(";"))
//    println(seq_d2.mkString("=="))
//    println(part_seq)
    part_seq.foreach(println)
  }
}
