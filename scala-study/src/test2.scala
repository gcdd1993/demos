/**
  * Created by gaochen on 2018/6/12.
  * 第四章 控制结构
  */
//Scala:if条件表达式
object ifTest {
  def main(args: Array[String]): Unit = {
    var x = 6
    if (x > 0) {
      println("This is a positive number")
    }else {
      println("This is not a positive number")
    }
    x = 0
    if (x > 0) {
      println("This is a positive number")
    } else if (x==0) {
      println("This is a zero")
    } else {
      println("This is a negative number")
    }
    val a = if (x > 0) 1 else -1
    print("a : " + a)
  }
}
//Scala:while循环
object whileTest {
  def main(args: Array[String]): Unit = {
    //while
    var i = 9
    while (i > 0) {
      i -= 1
      printf("i is %d\n",i)
    }
    //do while
    var j = 0
    do {
      j += 1
      println(j)
    }while (j<5)
  }
}
//for循环 for (变量<-表达式) 语句块
object forTest {
  def main(args: Array[String]): Unit = {
    for (i <- 1 to 5) {
      println(i)
    }
    for (i <- 1 to 5 by 2) {
      println(i)
    }
    for (i <- 1 to 5 if i%2==0) {
      println(i)
    }
    for (i <- 1 to 5; j <- 1 to 3) {
      println(i*j)
    }
    for (i <- 1 to 5 if i%2==0; j <- 1 to 3 if j!=i) {
      println(i*j)
    }
    //for推导式
    val intArr = for (i <- 1 to 5 if i%2==0) yield i
    print(intArr)
  }
}
