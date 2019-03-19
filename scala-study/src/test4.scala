/**
  * Created by gaochen on 2018/6/12.
  * 函数式编程
  */
object functionTest {
  def main(args: Array[String]): Unit = {
    def plusStep(step: Int) = (num: Int) => num + step
    //给step赋值
    val myFunc = plusStep(3)
    //调用myFunc函数
    println(myFunc(10))
    val addMore=(x:Int)=>x>0
    //定义了一个新的函数sum，以函数f为参数
    def sum(f: Int => Int, a: Int, b: Int): Int ={
      if(a > b) 0 else f(a) + sum(f, a+1, b)
    }
    //定义了一个新的函数self，该函数的输入是一个整数x，然后直接输出x自身
    def self(x: Int): Int = x
    //重新定义sumInts函数
    def sumInts(a: Int, b: Int): Int = sum(self, a, b)
  }
}
//高阶函数
object multiTest {
  def main(args: Array[String]): Unit = {
    def sum(f: Int => Int, a: Int, b: Int): Int = {
      if(a > b) 0 else f(a) + sum(f, a+1, b)
    }

    def self(x: Int): Int = x
    def square(x: Int): Int = x * x
    def powerOfTwo(x: Int): Int = if(x == 0) 1 else 2 * powerOfTwo(x-1)

    def sumInts(a: Int, b: Int): Int = sum(self, a, b)
    def sumSquared(a: Int, b: Int): Int = sum(square, a, b)
    def sumPowersOfTwo(a: Int, b: Int): Int = sum(powerOfTwo, a, b)
    println(sumInts(1,5))
    println(sumSquared(1,5))
    println(sumPowersOfTwo(1,5))
  }
}
