/**
  * Created by gaochen on 2018/6/12.
  *  针对集合的操作
  */
//列表的遍历
object t1 {
  def main(args: Array[String]): Unit = {
    //可以使用for循环进行遍历：
    val list = List(1, 2, 3, 4, 5)
    for (elem <- list) println(elem)
    //也可以使用foreach进行遍历：
    list foreach println //本行语句甚至可以简写为list.foreach(println)，或者写成：list foreach println
  }
}
//映射的遍历
object t2 {
  def main(args: Array[String]): Unit = {
    val university = Map("XMU" -> "Xiamen University", "THU" -> "Tsinghua University","PKU"->"Peking University")
    for ((k,v) <- university) printf("Code is : %s and name is: %s\n",k,v)
  }
}