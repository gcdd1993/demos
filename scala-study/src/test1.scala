import java.io.PrintWriter

import scala.io.Source

/**
  * Created by gaochen on 2018/6/12.
  */
object printTest {
  def main(args: Array[String]): Unit = {
    print("My name is:")
    print("Ziyu")

    println("My name is:")
    println("Ziyu")

//    val i = 7
//    println(i)

    val i = 5
    val j = 8
    printf("My name is %s. I hava %d apples and %d eggs.\n", "Ziyu", i, j)
  }
}
//scala 读写文件
object writerTest {
  def main(args: Array[String]): Unit = {
    val out = new PrintWriter("output.txt")
    for (i <- 1 to 5) {
      out.println(i)
    }
    out.close()
  }
}
object readerTest {
  def main(args: Array[String]): Unit = {
    val inputFile = Source.fromFile("output.txt")
    val lines = inputFile.getLines
    for(line <- lines) {
      println(line)
    }
  }
}