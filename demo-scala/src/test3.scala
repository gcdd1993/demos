/**
  * Created by gaochen on 2018/6/12.
  *第五章 数据结构
  */
//数组
object arrTest {
  def main(args: Array[String]): Unit = {
    val intValueArr = new Array[Int](3)  //声明一个长度为3的整型数组，每个数组元素初始化为0
    intValueArr(0) = 12 //给第1个数组元素赋值为12
    intValueArr(1) = 45  //给第2个数组元素赋值为45
    intValueArr(2) = 33 //给第3个数组元素赋值为33

    val myStrArr = new Array[String](3) //声明一个长度为3的字符串数组，每个数组元素初始化为null
    myStrArr(0) = "BigData"
    myStrArr(1) = "Hadoop"
    myStrArr(2) = "Spark"
    for (i <- 0 to 2) println(myStrArr(i))
//    Scala提供了更加简洁的数组声明和初始化方法
//    val intValueArr = Array(12,45,33)
//    val myStrArr = Array("BigData","Hadoop","Spark")
  }
}
//Scala入门:列表(List)
object listTest {
  def main(args: Array[String]): Unit = {
    val intList = List(1,2,3)
    println(intList.head)  //获取头部
    println(intList.tail)  //获取尾部

    val intListOther = 0::intList
    println(intListOther)

    val intList222 = 1::2::3::Nil
    println(intList222)

    //使用:::操作符对不同的列表进行连接得到新的列表
    val intList1 = List(1,2)
    val intList2 = List(3,4)
    val intList3 = intList1:::intList2
    println(intList3)

    println(intList3.sum)
  }
}
//Scala入门:元组(tuple)
object tupleTest {
  def main(args: Array[String]): Unit = {
    val tuple = ("BigData",2015,45.0)
    println(tuple)
    println(tuple._1)
    println(tuple._2)
    println(tuple._3)
    val tuple1 = ("BigData",2015,45.0,13432)
    println(tuple1._1)
    println(tuple1._2)
    println(tuple1._3)
    println(tuple1._4)
  }
}
//Scala入门:集(set)
object setTest {
  def main(args: Array[String]): Unit = {
    //用默认方式创建一个不可变集
    var mySet = Set("Hadoop","Spark")
    mySet += "Scala"
    println(mySet.contains("Scala"))

    import scala.collection.mutable.Set
    //可变集，则需要引入scala.collection.mutable.Set包
    val myMutableSet = Set("Database","BigData")
    myMutableSet += "Cloud Computing"
    println(myMutableSet)

    //注意：虽然可变集和不可变集都有添加或删除元素的操作，但是，二者有很大的区别。
    // 对不可变集进行操作，会产生一个新的集，原来的集并不会发生变化。
    // 而对可变集进行操作，改变的是该集本身
  }
}
//Scala入门：映射(Map)
object mapTest {
  def main(args: Array[String]): Unit = {
    val university = Map("XMU1" -> "Xiamen University", "THU" -> "Tsinghua University","PKU"->"Peking University")
    println(university("XMU1"))

    val xmu = if (university.contains("XMU")) university("XMU") else 0
    println(xmu)

    //可变映射
    import scala.collection.mutable.Map
    val university2 = Map("XMU" -> "Xiamen University", "THU" -> "Tsinghua University","PKU"->"Peking University")
    university2("XMU") = "Ximan University" //更新已有元素的值
    university2("FZU") = "Fuzhou University" //添加新元素
    //也可以使用+=操作来添加新的元素
    university2 += ("TJU"->"Tianjin University") //添加一个新元素
    university2 += ("SDU"->"Shandong University","WHU"->"Wuhan University") //同时添加两个新元素
    //for ((k,v) <- 映射) 语句块
    for ((k,v) <- university) {
      printf("Code is : %s and name is: %s\n",k,v)
    }
    //也可以只遍历映射中的k或者v
    for (k<-university.keys) println(k)
    //把所有值打印出来
    for (v<-university.values) println(v)
  }
}
//Scala入门：迭代器(Iterator)
object iteratorTest {
  def main(args: Array[String]): Unit = {
    //while循环如下：
    val iter = Iterator("Hadoop","Spark","Scala")
    while (iter.hasNext) {
      println(iter.next())
    }
    val iter1 = Iterator("Hadoop","Spark","Scala")
    //for循环如下：
    for (elem <- iter1) {
      println(elem)
    }
  }
}
//Scala入门:类
object classTest {
  class Counter{
//    private var privateValue = 0  //变成私有字段，并且修改字段名称
//    def value = privateValue //定义一个方法，方法的名称就是原来我们想要的字段的名称
//    def value_=(newValue: Int){
//      if (newValue > 0) privateValue = newValue //只有提供的新值是正数，才允许修改
//    }
//    def increment(step: Int): Unit = { value += step}
//    def current(): Int = {value}
private var value = 0 //value用来存储计数器的起始值
    private var name = "" //表示计数器的名称
    private var mode = 1 //mode用来表示计数器类型（比如，1表示步数计数器，2表示时间计数器）
    def this(name: String){ //第一个辅助构造器
      this() //调用主构造器
      this.name = name
    }
    def this (name: String, mode: Int){ //第二个辅助构造器
      this(name) //调用前一个辅助构造器
      this.mode = mode
    }
    def increment(step: Int): Unit = { value += step}
    def current(): Int = {value}
    def info(): Unit = {printf("Name:%s and mode is %d\n",name,mode)}
  }

  def main(args: Array[String]): Unit = {
//    val myCounter = new Counter
//    println(myCounter.value)  //打印value的初始值
//    myCounter.value = 3 //为value设置新的值
//    println(myCounter.value)  //打印value的新值
//    myCounter.increment(1) //这里设置步长为1，每次增加1
//    println(myCounter.current)
val myCounter1 = new Counter  //主构造器
    val myCounter2 = new Counter("Runner") //第一个辅助构造器，计数器的名称设置为Runner，用来计算跑步步数
    val myCounter3 = new Counter("Timer",2) //第二个辅助构造器，计数器的名称设置为Timer，用来计算秒数
    myCounter1.info  //显示计数器信息
    myCounter1.increment(1)     //设置步长
    printf("Current Value is: %d\n",myCounter1.current) //显示计数器当前值
    myCounter2.info  //显示计数器信息
    myCounter2.increment(2)     //设置步长
    printf("Current Value is: %d\n",myCounter2.current) //显示计数器当前值
    myCounter3.info  //显示计数器信息
    myCounter3.increment(3)     //设置步长
    printf("Current Value is: %d\n",myCounter3.current) //显示计数器当前值
  }
}
//Scala入门：对象
//object Person {
//  private var lastId = 0  //一个人的身份编号
//  def newPersonId() = {
//    lastId +=1
//    lastId
//  }
//
//  def main(args: Array[String]): Unit = {
//    printf("The first person id is %d.\n",Person.newPersonId())
//    printf("The second person id is %d.\n",Person.newPersonId())
//    printf("The third person id is %d.\n",Person.newPersonId())
//  }
//}
class Person {
  private val id = Person.newPersonId() //调用了伴生对象中的方法
  private var name = ""
  def this(name: String) {
    this()
    this.name = name
  }
  def info() { printf("The id of %s is %d.\n",name,id)}
}
object Person {
  private var lastId = 0  //一个人的身份编号
  private def newPersonId() = {
    lastId +=1
    lastId
  }
  def main(args: Array[String]){
    val person1 = new Person("Ziyu")
    val person2 = new Person("Minxing")
    person1.info()
    person2.info()
  }
}
class TestApplyClassAndObject {
}
class ApplyTest{
  def apply() = println("apply method in class is called!")
  def greetingOfClass: Unit ={
    println("Greeting method in class is called.")
  }
}
object ApplyTest{
  def apply() = {
    println("apply method in object is called")
    new ApplyTest()
  }
}
object  TestApplyClassAndObject{
  def main (args: Array[String]) {
    val a = ApplyTest() //这里会调用伴生对象中的apply方法
    a.greetingOfClass
    a() // 这里会调用伴生类中的apply方法
  }
}
class Car(name: String){
  def info() {println("Car name is "+ name)}
}
object Car {
  def apply(name: String) = new Car(name) //apply方法会调用伴生类Car的构造方法创建一个Car类的实例化对象
}
object MyTest{
  def main (args: Array[String]) {
    val mycar = Car("BMW") //这里会调用伴生对象中的apply方法，apply方法会创建一个Car类的实例化对象
    mycar.info()
  }
}
//抽象类
//关于上面的定义，说明几点：
//（1）定义一个抽象类，需要使用关键字abstract。
//（2）定义一个抽象类的抽象方法，也不需要关键字abstract，只要把方法体空着，不写方法体就可以。
//（3）抽象类中定义的字段，只要没有给出初始化值，就表示是一个抽象字段，但是，抽象字段必须要声明类型，比如：
abstract class Car1{   //是抽象类，不能直接被实例化
  val carBrand: String //字段没有初始化值，就是一个抽象字段
  def info() //抽象方法，不需要使用abstract关键字
  def greeting() {println("Welcome to my car!")}
}
//扩展类
class BMWCar extends Car1 {
  override val carBrand = "BMW"  //重写超类字段，需要使用override关键字，否则编译会报错
  def info() {printf("This is a %s car. It is on sale", carBrand)} //重写超类的抽象方法时，不需要使用override关键字，不过，如果加上override编译也不错报错
  override def greeting() {println("Welcome to my BMW car!")} //重写超类的非抽象方法，必须使用override关键字
}

class BYDCar extends Car1 {
  override val carBrand = "BYD" //重写超类字段，需要使用override关键字，否则编译会报错
  def info() {printf("This is a %s car. It is cheap.", carBrand)} //重写超类的抽象方法时，不需要使用override关键字，不过，如果加上override编译也不错报错
  override def greeting() {println("Welcome to my BYD car!")} //重写超类的非抽象方法，必须使用override关键字
}
object MyCar {
  def main(args: Array[String]){
    val myCar1 = new BMWCar()
    val myCar2 = new BYDCar()
    myCar1.greeting()
    myCar1.info()
    myCar2.greeting()
    myCar2.info()
  }
}
//Scala入门：特质(trait)
trait CarId{
  var id: Int
  def currentId(): Int     //定义了一个抽象方法
}
class BYDCarId extends CarId{ //使用extends关键字
  override var id = 10000 //BYD汽车编号从10000开始
  def currentId(): Int = {id += 1; id} //返回汽车编号
}
class BMWCarId extends CarId{ //使用extends关键字
  override var id = 20000 //BMW汽车编号从20000开始
  def currentId(): Int = {id += 1; id} //返回汽车编号
}
object MyCar1 {
  def main(args: Array[String]) {
    val myCarId1 = new BYDCarId()
    val myCarId2 = new BMWCarId()
    printf("My first CarId is %d.\n", myCarId1.currentId)
    printf("My second CarId is %d.\n", myCarId2.currentId)
  }
}
//特质可以包含具体实现
trait CarGreeting{
  def greeting(msg: String) {println(msg)}
}
//把多个特质混入类中
class BYDCarId1 extends CarId with CarGreeting{ //使用extends关键字混入第1个特质，后面可以反复使用with关键字混入更多特质
  override var id = 10000 //BYD汽车编号从10000开始
def currentId(): Int = {id += 1; id} //返回汽车编号
}
class BMWCarId1 extends CarId with CarGreeting{ //使用extends关键字混入第1个特质，后面可以反复使用with关键字混入更多特质
  override var id = 20000 //BMW汽车编号从10000开始
def currentId(): Int = {id += 1; id} //返回汽车编号
}
object MyCar2 {
  def main(args: Array[String]){
    val myCarId1 = new BYDCarId1()
    val myCarId2 = new BMWCarId1()
    myCarId1.greeting("Welcome my first car.")
    printf("My first CarId is %d.\n",myCarId1.currentId)
    myCarId2.greeting("Welcome my second car.")
    printf("My second CarId is %d.\n",myCarId2.currentId)
  }
}
//Scala入门：模式匹配
object matchTest {
  def main(args: Array[String]): Unit = {
    //简单匹配
    val colorNum = 1
    val colorStr = colorNum match {
      case 1 => "red"
      case 2 => "green"
      case 3 => "yellow"
      case _ => "Not Allowed"
    }
    println(colorStr)
    //类型模式
    for (elem <- List(9,12.3,"Spark","Hadoop",'Hello)){
      val str  = elem match{
        case i: Int => i + " is an int value."
        case d: Double => d + " is a double value."
        case "Spark"=> "Spark is found."
        case s: String => s + " is a string value."
        case _ => "This is an unexpected value."
      }
      println(str)
    }
    //“守卫(guard)”语句
    for (elem <- List(1,2,3,4)){
      elem match {
        case _ if elem %2 == 0 => println(elem + " is even.")
        case _ => println(elem + " is odd.")
      }
    }
    //for表达式中的模式
    val university = Map("XMU" -> "Xiamen University", "THU" -> "Tsinghua University","PKU"->"Peking University")
    for ((k,v) <- university) printf("Code is : %s and name is: %s\n",k,v)
    //case类的匹配
    case class Car(brand: String, price: Int)
    val myBYDCar = new Car("BYD", 89000)
    val myBMWCar = new Car("BMW", 1200000)
    val myBenzCar = new Car("Benz", 1500000)
    for (car <- List(myBYDCar, myBMWCar, myBenzCar)) {
      car match{
        case Car("BYD", 89000) => println("Hello, BYD!")
        case Car("BMW", 1200000) => println("Hello, BMW!")
        case Car(brand, price) => println("Brand:"+ brand +", Price:"+price+", do you want it?")
      }
    }
  }
  //Option类型 ==> 对标java optional
  val books=Map("hadoop"->5,"spark"->10,"hbase"->7)
  println(books.get("hadoop"))
  println(books.get("hive"))
}