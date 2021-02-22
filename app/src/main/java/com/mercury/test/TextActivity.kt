
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
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.suspendCoroutine

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
    // int,char 数据类型在前  Integer character String在Array<T>中
    var c0 = intArrayOf(1,2,3,4)
    var c1 = charArrayOf()
    var c3 = arrayOf("s","s")
    var aa = ArrayList<String>()


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
    var intList3 : MutableList<Int> = mutableListOf()

    // Map
    val map: Map<String, Any> = mapOf("name" to "zs", "age" to 20)
    val map2: Map<String, Any> = mutableMapOf("name" to "ls", "age" to 20)



    fun test1() {
        var stringList = ArrayList<String>()
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
//
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


//  小结下，Java 的泛型本身是不支持协变和逆变的：
//
//    可以使用泛型通配符 ? extends 来使泛型支持协变，但是「只能读取不能修改」，这里的修改仅指对泛型集合添加元素，如果是 remove(int index) 以及 clear 当然是可以的。
//    可以使用泛型通配符 ? super 来使泛型支持逆变，但是「只能修改不能读取」，这里说的不能读取是指不能按照泛型类型读取，你如果按照 Object 读出来再强转当然也是可以的。
//
//    val appleShop: Shop<out Fruit>
//    val fruitShop: Shop<in Apple>
//    它们完全等价于：
//    Shop<? extends Fruit> appleShop;
//    Shop<? super Apple> fruitShop;
//
//    open class Animal
//    class PetShop<T>(val t: T) where  T : Animal?, T : Serializable
//
//     其实通配符 * 不过是一种语法糖，背后也是用协变来实现的。所以：MutableList<*> 等价于 MutableList<out Any?>，使用通配符与协变有着一样的特性。



inline fun <reified T> printIfTypeMatch(item: Any) {
    if (item is T) { // 这里就不会在提示错误了

    }
}
//     reified 具体化的
//     inline fun <reified T> String?.toObject(type: Type? = null): T? {
//    return if (type != null) {
//        GsonFactory.GSON.fromJson(this, type)
//    } else {
//        GsonFactory.GSON.fromJson(this, T::class.java)
//    }
//}
//
//  also  apply 返回自身
//  let with 返回返回值
//
//
//

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

        //这种协程当应用程序运行结束时也会跟着一起结束
      GlobalScope.launch {  }
        GlobalScope.async {  }


    }


//     * infix 把。。。植入
//    infix 函数实际上是把编程语言函数调用的语法规则调整了一下，比如 A to B 这样的写法，实际上等价于 A.to(B) 的写法。



    fun test122(){
        if("rrr".startsWith("eee")){

        }

        if("rrr" beginWith "eee"){

        }

        startActivity<LifeActivity>(this)
        startAty<LifeActivity>(this,{putExtra("aaa","ee")})
        startAty<LifeActivity>(this) {putExtra("aaa","ee")}

        startActivitys<LifeActivity>(this) {}



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

    inline fun <reified  T> startActivitys(context: Context,block: Intent.() -> Unit){
        var intent= Intent(context,T::class.java)
        intent.block()
        context.startActivity(intent)

    }




    suspend fun a(){
        startAtys(this,{},{})
        startAtyss({},{})

    }



   suspend fun startAtys(context: Context,block:Intent.() -> Unit,error:()->Unit){

    }

    suspend fun startAtyss(block:Intent.() -> Unit,error:()->Unit){

    }




    //泛型协变的定义：假如定义了一个 MyClass<T>的泛型类，其中 A 是 B 的子类型，
    // 同时MyClass<A>又是MyClass<B>的子类型，那么我们就可以称 MyClass 在 T 这个泛型上是协定的。
   // 如何才能让MyClass<A>成为MyClass<B>的子类型：如果一个泛型类在其泛型类型的数据上是只读的，
    // 那么它是没有类型转换安全隐患的。而要实现这一点，则需要让MyClass<T>类中的所有方法都不能接收 T 类型的参数。
    // 换句话说，T 只能出现在 out 位置上，而不能出现在 in 位置上。

    //有时我们需要访问作为参数传递给我们的类型：reified

    inline fun<reified T> Gson.fromJson(json:String) = fromJson(json,T::class.java)
    var str = "dddd"
    var person:Person = Gson().fromJson(str)
    //SAM转换 single abstract method conversions 对于只有单个非默认抽象方法接口的转换对于符合这个条件的接口称之为sam type



//    CoroutineContext，协程上下文，是一些元素的集合，主要包括 Job 和 CoroutineDispatcher 元素，可以代表一个协程的场景。
    //

    fun corioutinse(){
//        GlobalScope.launch()  这种协程当应用程序运行结束时也会跟着一起结束//不会阻断主线程
        //runBlocking   借助 runBlocking 函数可以让应用程序在协程中所有代码都运行完了之后再结束。
        //注意：此函数通常只应该在测试环境下使用，在正式环境中使用容易产生一些性能上的问题。
//        使用 launch 函数可以创建多个协程，它必须在协程的作用域中才能调用，其次，它会在当前协程的作用域下创建子协程。子协程的特点是如果外层作用域的协程结束了，该作用域下的所有子协程也会一同结束
        //coroutineScope 函数
        //但 suspend 关键字无法提供协程作用域，也就无法调用像 launch 函数。这时可使用 coroutineScope 函数，它也是一个挂起函数，
        // 因此可以在任何其他挂起函数中调用。它的特点是会继承外部的协程作用域并创建一个子作用域。
        //coroutineScope 函数和 runBlocking 函数还有点类似，它可以保证其作用域内的所有代码和子协程在全部执行完之前，会一直阻塞当前协程。
        //但是，coroutineScope 函数只会阻塞当前协程，既不影响其它协程，也不影响任何线程，因此是不会造成任何性能上的问题的
        // 而  runBlocking 函数由于会阻塞当前线程，而我们又恰好在主线程中调用它的话，那么就有可能会导致界面卡死的情况，所以不太推荐在实际项目中使用
        //

        CoroutineScope(Dispatchers.Main).launch {  }

        //Job当 Activity 关闭时，需要逐个调用所有已创建协程的 cancel() 方法。
        var job1 = GlobalScope.launch {  }
        job1.cancel()
        var job = Job()
        var scope = CoroutineScope(job)
        scope.launch {  }
        job.cancel()

        //async 函数
        //当调用 launch 函数时可以创建一个新的协程，但 launch 函数只能用于执行一段逻辑，却不能获取执行的结果，因为它的返回值永远是一个 Job 对象。这时，可使用 async 函数实现。
        //async 函数必须在协程作用域当中调用，它会创建一个新的子协程并返回一个 Deferred 对象，并通过此对象的 await() 即可。


        GlobalScope.launch {
            var result1 = async {  }
            var result2 = async {  }
//            var resutlt = result1.await()+result2.await() 支持并发


        }

        runBlocking {
            val start = System.currentTimeMillis()
            val result = async {
                delay(1000)
                5 + 5
            }.await()
            val result2 = async {
                delay(1000)
                4 + 6
            }.await()
            println("result id ${result + result2}.")
            val end = System.currentTimeMillis()
            println("cost ${end - start} ms.")

            // 运行结果：
            // result id 20.
            // cost 2021 ms.  // 耗时 2 秒，说明确实是串行。
        }


        runBlocking {
            val start = System.currentTimeMillis()
            val result = async {
                delay(1000)
                5 + 5
            }
            val result2 = async {
                delay(1000)
                4 + 6
            }
            // 仅在需要用到 async 函数的执行结果时才调用 await() 获取。
            println("result id ${result.await() + result2.await()}.")
            val end = System.currentTimeMillis()
            println("cost ${end - start} ms.")

            // 运行结果：
            // result id 20.
            // cost 1021 ms.  // 耗时 1 秒，说明确实是并行。
        }

        //一个比较特殊的作用域构造器，它是一个挂起函数，大体可将它理解成 async 函数的一种简化版写法。
//        withContext(Dispatchers.Main){
//
//        }


        //* suspendCoroutine 函数必须在协程作用域或挂起函数中才能调用，它接收一个 Lambda 表达式参数，主要作用是将当* 前协程立即挂起，
        // 然后在一个普通的线程中执行 Lambda 表达式中的代码，Lambda 表达式的参数列表上会传入一个
        //* Continuation 参数，调用它的 resume() 或 resumeWithException() 可以让协程恢复执行，
        //

//


    }


    suspend fun request(address:String):String{
        return  suspendCoroutine { continuation ->

        }
    }






    fun launchUI(block:suspend CoroutineScope.() ->Unit){
        //这种协程当应用程序运行结束时也会跟着一起结束
        GlobalScope.launch { block() }
    }

    fun launcher(block:suspend CoroutineScope.()->Unit,
    error:suspend CoroutineScope.(Throwable) ->Unit = {},
    complete:suspend CoroutineScope.() -> Unit={}){
        launchUI { try {
            block()
        }catch (e:Throwable){
            error(e)
        }finally {
            complete()
        } }
    }

    fun la(block: () -> Unit){

    }
    fun lad(block: Intent.() -> Unit){

    }

    fun ab (){
        launchUI {  }
        launcher({},{},{})
        launcher({})
        startAtys({})
        startAtys()
    }


    fun startAtys( block:suspend Intent.() -> Unit={},error:suspend (Throwable) -> Unit={},result:suspend() -> Unit={}){

    }

    fun b(){





        la { var i = 3
        i = i++
        print(i)}


        lad {var i = 3
            i = i++
            print(i)
        }

        TODO("测试todo函数，是否显示抛出错误" )
    }


    fun <T, R> Collection<T>.fold(
        initial: R,
        combine: (acc: R, nextElement: T) -> R
    ): R {
        var accumulator: R = initial
        for (element: T in this) {
            accumulator = combine(accumulator, element)
        }
        return accumulator
    }

    fun aaa(){
        var items = listOf(1,2,3,4,5)
        items.fold(0,{
            aac:Int,i:Int->
            print("aac = $aac,i = $i")
            val result = aac+1
            print("result = $result")
            result
        })

        var str = listOf("d","d","s","s")
        str.fold(1,{acc:Int,next:String ->
            acc+1
        })


        items.fold("elments",{acc,i -> acc+"   "+i})

        items.fold(1,Int::times)

        //如果函数的最后一个参数是函数，则可以将作为相应参数传递的lambda表达式放在括号之外
        items.fold("elments"){acc,i -> acc+"   "+i}

        fun(s: String): Int { return s.toIntOrNull() ?: 0 }

        kotlin.run { println("...") }


        // 具有和不具有接收器的功能类型的非文字值可以互换，因此接收器可以代表第一个参数，反之亦然。
        // 例如，(A, B) -> C可以在A.(B) -> C期望a处传递或分配type值，反之亦然：

        val repeatFun: String.(Int) -> String = { times -> this.repeat(times) }
        val twoParameters: (String, Int) -> String = repeatFun // OK

        fun runTransformation(f: (String, Int) -> String): String {
            return f("hello", 3)
        }
        val result = runTransformation(repeatFun) // OK

//        函数类型的值可以通过使用其invoke(...)运算符：f.invoke(x)或f(x)。
//        如果该值具有接收器类型，则应将接收器对象作为第一个参数传递。调用与接收器的功能类型的值的另一种方法是
//        与接收器对象预先考虑它，因为如果该值分别为一个扩展函数：1.foo(2)
        val stringPlus: (String, String) -> String = String::plus
        val intPlus: Int.(Int) -> Int = Int::plus

        println(stringPlus.invoke("<-", "->"))
        println(stringPlus("Hello, ", "world!"))

        println(intPlus.invoke(1, 1))
        println(intPlus(1, 2))
        println(2.intPlus(3)) // extension-like call

        var strPlus:(String,String)->String = String::plus
        strPlus.invoke("a","b")
        strPlus("q","a")

        //it：单个参数的隐式名称
        //Lambda表达式只有一个参数是很常见的。
        //如果编译器可以自己找出签名，则可以不声明唯一的参数，而忽略->。该参数将在名称下隐式声明it：
        items.filter { it%2 == 0 }

        //可以使用限定的返回语法从lambda显式返回一个值。否则，隐式返回最后一个表达式的值。
        items.filter {
            val shouldFilter = it > 0
            return@filter shouldFilter
        }

        //如果未使用lambda参数，则可以使用下划线代替其名称：
       //匿名函数看起来非常类似于常规函数声明，只是省略了其名称。它的主体可以是一个表达式（如上所示）或一个块

       //run 函数
        //用法1执行一个代码块的时候 ，改代码块代码是独立的 不影响项目
        //用法2 因为run 当一个业务逻辑执行同一段代码而根据不同条件去判断得到不同结果的时候可以用run 函数
    }

    private fun testRun1() {
        val str = "kotlin"

        run{
            val str = "java"   // 和上面的变量不会冲突
            println("str = $str")
        }

        println("str = $str")
    }


    fun run2(){
        val index = 3
        val num = run {
            when(index){
                0 -> "kotlin"
                1 -> "java"
                2 -> "php"
                3 -> "javaScript"
                else -> "none"
            }
        }.length
        println("num = $num")
    }

//    T.run
    val strs= "kotlin"

    fun testTRun(){//可以用this关键字返回最后一行返回值
      var a =  strs.run{
        this.plus("ddddd")

       }

        //with  返回最后一行返回值

      var s =   with(str){
            this.plus("sss")
            23
        }
        //apply 返回自身 是执行block后返回自身 无变化

        str.apply {

        }
        //also it  返回自身 执行block（this）后返回自身  自身变化
        strs.also {

        }
        //let  空安全 返回自身
        strs.let {

        }


       var ss =  strs.takeIf {
           it.startsWith("s") //如果为s开头就返回自身 如果不是 null
       }

        strs.takeUnless {
            it.startsWith("s")
        }

        repeat(4){

        }





    }

    suspend fun f(){
        suspendCoroutine<String> {continuation -> {}   }
    }







}

