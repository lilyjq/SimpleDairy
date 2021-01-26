package com.mercury.test

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.net.toUri
import androidx.databinding.DataBindingUtil
import com.google.gson.Gson
import com.mercury.diary.R
import com.mercury.diary.databinding.ActivityTestBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class TextActivity : Activity() {

    lateinit var mBinding: ActivityTestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_motion)
        mBinding = ActivityTestBinding.inflate(layoutInflater)


        var a:String = max("sss","qqq")
        var b = max<String>("sss","qqq")
        var n :Int

    }

    //在 Java 中 == 比较的是引用而不是内容，equals() 才是比较内容的。但是在 Kotlin 中 == 比较的是内容，=== 比较的是引用。
    // java          int[]        Integer[]        char[]         character[]    String[]
    // kotlin        IntArray     Array<Int>       CharArray      Array<Char>     Array<String>
    // int 等数据类型在前 原生数据类型在Array<T>中
    var c0 = intArrayOf(1,2,3,4)

    //打印可以用contentToString 方法
    fun getFun(){
        println(c0.contentToString()+c0.size+c0[0])
        c0.forEach {  }//遍历
        if(5 in c0){}//判断是否存在

        var f1 = "2222"
        var f2 = "3333"
        if(f1 == f2){

        }
    }
    var intRangeExclusion = 1 until 10//[1,10)
    var charR = 'a' until 'c'

    var  intRangeReverse = 10 downTo 1 //[10,1]


    val step = 1..10 step 2
    fun test0(){
        step.forEach {  }
        step.map {  }

        val intArray = IntArray(5){ it + 1 }

        intArray.forEach(::println)
    }


    // List
    val intList: List<Int> = listOf(1, 2, 3, 4)
    val intList2: MutableList<Int> = mutableListOf(1, 2, 3, 4)

    // Map
    val map: Map<String, Any> = mapOf("name" to "zs", "age" to 20)
    val map2: Map<String, Any> = mutableMapOf("name" to "ls", "age" to 20)



    fun test1() {
        val stringList = ArrayList<String>()
// add
        for (i in 0..10) {
            // stringList += "num: $i" 运算符重载
            stringList.add("num: $i")
        }
// remove
        for (i in 0..10) {
            // stringList -= "num: $i" 运算符重载
            stringList.remove("num: $i")
        }
// set
        stringList[5] = "HelloWorld"
        // get
        val valueAt5 = stringList[5]


        val hashMap = HashMap<String, Int>()
        hashMap["Hello"] = 10
        println(hashMap["Hello"])

        val pair1 = "Hello" to "Kotlin"
        val pair2 = Pair("Hello", "Kotlin")
        val first = pair1.first
        val second = pair2.second
        val (x, y) = pair1

        val triple = Triple("x", 2, 3.0)
        val first1 = triple.first
        val second1 = triple.second
        val third = triple.third
//        val (x, y, z) = triple


    }

    //引用 class::method
    //变长参数 vararg
    // 可以接受多个 Int
    fun multiParameters(vararg ints: Int) {
        println(ints.contentToString())
    }

    // 调用上述接收变长参数的方法
    fun main() {
        multiParameters(1, 2, 3, 4)
        // 伪多返回值
        val (a, b, c) = multiReturnValues()


// 函数调用  形参 y 来显示接收参数
        defaultParameter(y = "Hello")
    }


//    高阶函数就是参数类型包含函数类型或者返回值类型是函数类型的函数，简单的说，高阶函数就是函数里面套函数

    // 参数类型是函数类型
    fun needsFunction(block: () -> Unit) {
        block()
    }

    // 返回值是函数类型
    fun returnsFunction(): () -> Long {
        return {System.currentTimeMillis()}
    }


    //被 inline 标记的函数就是内联函数，其原理就是：在编译时期，把调用这个函数的地方用这个函数的方法体进行替换。
    //虽然说内联函数可以减少函数的调用来优化性能，但是并不是每个函数前加一个 inline 就可以优化性能，其实我们一般会把高阶函数定义为内联函数。
    //3.4、内联函数的限制
    //public/protected 的内联方法只能访问对应类的 public 成员；
    //内联函数里面的参数不能被存储（赋值给一个变量）；
    //内联函数的参数只能传递给其他内联函数。

    fun multiReturnValues(): Triple<Int, Long, Double> {
        return Triple(1, 3L, 4.0)
    }

    // 函数定义 声明 x 的默认值是 5， z 的默认值是 0L
    fun defaultParameter(x: Int = 5, y: String, z: Long = 0L) {
        TODO()
    }

    // Kotin 自带的 map 函数
//    inline fun <R> IntArray.map(transform: (Int) -> R): List<R> {
//        return mapTo(ArrayList<R>(size), transform)
//    }

    // Kotin 自带的 forEach 函数
//    inline fun IntArray.forEach(action: (Int) -> Unit): Unit {
//        for (element in this) action(element)
//    }


//二、集合变换与聚合https://juejin.cn/post/6917984676229414919
    fun change(){
    intList.forEach {  }//遍历
    for(index in intList.indices){
        println("item at $index is ${intList[index]}")
    }

    for(item in intList){
        println("item at is  $item")
    }
    var index1 = 0
    while(index1 <intList.size){
        println("item at $index1 is ${intList[index1]}")
        index1++
    }

    //filter 过滤  map 映射到其他元素构成新集合 flatmap映射到新集合并合并这些集合得到新集合
    intList.filter { it%2 == 0 }
    //元素乘以2变成一个新集合
    var changeList = intList.map { it*2 }
    intList.asSequence().map { it*2 }

    intList2.filter { it%2 ==0  }
        .sortedBy { it }
        .map {  }
        .forEach { println(it) }





    //sum 所有元素求和
    // reduce 将元素一次按规则聚合，结果与元素类型一致
    // fold 给定初始化值，将元素按规则聚合，结果与初始化类型一致
    var sum = intList.sum()
//    TODO
//    intList.reduce({a,b ->a+b})

//    计算过程为10+1+2+3
    val foldresult = arrayOf(1,2,3).fold(10,{a,b ->a+b})
    println(foldresult)

//    fold 函数的操作如下：
//
//    第一次执行时,由初始值 10 作为参数 a，由集合中第 0 个元素作为参数 b；
//    第二次执行时,第一次执行的返回值作为参数 a，由集合中第 1 个元素作为参数 b；
//    依次类推...;
//    最终将结果返回。

}




    //泛型 方法泛型
    fun <T> max(a: T, b: T): T {
        return a
    }

    fun<T :Comparable<T>> maxOf(a:T,b:T):T{
        return if(a>b) a else b
    }

    //加一个 Comparable 约束，就可以实现 a > b，这时候 T 需要实现 Comparable 接

    fun <T> callMax(a:T,b:T) where T:Comparable<T>,T:() ->Unit{
        if (a>b) a else b
    }


    fun <T, R> callMax(a: T, b: T): R
            where T : Comparable<T>, T : () -> R, R : Number {
        return if (a > b) a() else b()
    }

    //


    //类泛型
    class  Test<T>(t:T){

    }



    //使用条件表达式 :Int? 肯呢个出现空值
    fun maxOf(a:Int,b:Int):Int{
        if(a>b){
            return  a
        }else{
            return b
        }
    }

    fun getMaxPrint(){
      println("max of 0 and 42 is ${maxOf(0,42)}")
    }


    fun describe(obj:Any):String =
        when (obj){
            1->"One"
            "Hello"->"beat"
            is Long ->"Long"
            !is String ->"Not a String"
            else -> "UnKnow"
    }


    val map1 = mapOf("a" to 1 , "b" to 2,"c" to 3)



    //扩展函数
    fun String.sssssTo(){}
    fun test11(){
        "aaaaa".sssssTo()
    }

   //创建单例模式
    object Resource{
       val name = "Name"
   }

    val text = """ 
|Tell me and I forget. 
|Teach me and I remember. 
|Involve me and I learn. 
|(Benjamin Franklin) 
""".trimMargin()

    //跳转表达式 return  break continue

    fun jump(){
        loop@ for(i in 1..200 step 2){
            if (i == 5){
                break@loop
            }
        }

        intList.forEach intLi@{
            if(it == 3) return@intLi
            println(it)
        }

    }

    class Person(age: Int, name: String) {
        var age: Int = age //property
            get() {
                return field
            }
            set(value) {
                println("setAge: $value")
                field = value
            }
    }


  /*  小结下，Java 的泛型本身是不支持协变和逆变的：

    可以使用泛型通配符 ? extends 来使泛型支持协变，但是「只能读取不能修改」，这里的修改仅指对泛型集合添加元素，如果是 remove(int index) 以及 clear 当然是可以的。
    可以使用泛型通配符 ? super 来使泛型支持逆变，但是「只能修改不能读取」，这里说的不能读取是指不能按照泛型类型读取，你如果按照 Object 读出来再强转当然也是可以的。

    val appleShop: Shop<out Fruit>
    val fruitShop: Shop<in Apple>
    它们完全等价于：
    Shop<? extends Fruit> appleShop;
    Shop<? super Apple> fruitShop;

    open class Animal
    class PetShop<T>(val t: T) where  T : Animal?, T : Serializable

     其实通配符 * 不过是一种语法糖，背后也是用协变来实现的。所以：MutableList<*> 等价于 MutableList<out Any?>，使用通配符与协变有着一样的特性。



inline fun <reified T> printIfTypeMatch(item: Any) {
    if (item is T) { // 这里就不会在提示错误了

    }
}
     reified 具体化的
     inline fun <reified T> String?.toObject(type: Type? = null): T? {
    return if (type != null) {
        GsonFactory.GSON.fromJson(this, type)
    } else {
        GsonFactory.GSON.fromJson(this, T::class.java)
    }
}

  also  apply 返回自身
  let with 返回返回值
*/


    fun shared(){
//        var s = "https://google.com".toUri()

        var sharedPreferences:SharedPreferences = getSharedPreferences("333", Context.MODE_PRIVATE)
         sharedPreferences.edit()
            .putBoolean("key",true)
            .apply()



    }

//    协程是我们再安卓上进行异步编程的推荐解决方案
//    轻量：可以在单线程上运行多个协程，因为协程支持挂起，不会使正在运行协程的线程阻塞。挂起比阻塞节省更多内存，且支持多个并行操作
//    内存泄露更少
//    内置取消支持
//    jetpack 集成



    fun test123(people: People){
        val p = People("eee","aa").apply { people }

      GlobalScope.launch {  }
        GlobalScope.async {  }


    }

    /**
     * infix 把。。。植入
    infix 函数实际上是把编程语言函数调用的语法规则调整了一下，比如 A to B 这样的写法，实际上等价于 A.to(B) 的写法。
     */

    fun test122(){
        if("rrr".startsWith("eee")){

        }

        if("rrr" beginWith "eee"){

        }

        startActivity<LifeActivity>(this)
        startAty<LifeActivity>(this,{putExtra("aaa","ee")})
        startAty<LifeActivity>(this) {putExtra("aaa","ee")}

    }

    infix fun String.beginWith(prefix:String) = startsWith(prefix)


    inline fun <reified T> startActivity(context: Context) {
        val intent = Intent(context, T::class.java)
        context.startActivity(intent)
    }

    inline fun<reified  T>startAty(context: Context,block: Intent.() -> Unit){
        val intent = Intent(context,T::class.java)
        intent.block()
        context.startActivity(intent)
    }

    //泛型协变的定义：假如定义了一个 MyClass<T>的泛型类，其中 A 是 B 的子类型，
    // 同时MyClass<A>又是MyClass<B>的子类型，那么我们就可以称 MyClass 在 T 这个泛型上是协定的。
   // 如何才能让MyClass<A>成为MyClass<B>的子类型：如果一个泛型类在其泛型类型的数据上是只读的，
    // 那么它是没有类型转换安全隐患的。而要实现这一点，则需要让MyClass<T>类中的所有方法都不能接收 T 类型的参数。
    // 换句话说，T 只能出现在 out 位置上，而不能出现在 in 位置上。


    inline fun<reified T> Gson.fromJson(json:String) = fromJson(json,T::class.java)
    var str = "dddd"
    var person:Person = Gson().fromJson(str)
    //SAM转换 single abstract method conversions 对于只有单个非默认抽象方法接口的转换对于符合这个条件的接口称之为sam type




}

