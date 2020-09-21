package com.mercury.test

class Test {


    //let,run,also,apply,with
    //.let
    val mutableList= mutableListOf(1,3,4,null,8,9,10)
    var people: People? = null
    var util:TUtil?= null




    fun printNotNullList(){
        people?.let {// ?.let 不为空则执行{} 且可以用it代替people对象
            println(it.age)
        }
        var mVar = util?.let {
            it.todo1()
            it.todo2()
            it.todo3()
            999 //返回最后一行或return
        }



        //also

        people?.also { //?. 不为空则执行 ，it 代替people
            println(it.age)
        }

        var mVars = util?.also {
            it.todo1()
            it.todo2()
            it.todo3()
            //返回it
        }



        //with

        with(people){
            println(this?.name)//with() 可以直接调用其公共方法或属性
        }


        //run let+with
        people?.run {
            println(age)//直接使用其属性
        }//返回最后一行

        var mav =util?.run {
            todo1()
            todo2()
            todo3()
            999
        }///返回最后一行


       //apply
        people?.apply {
            println(age)//直接使用其属性
        }

        var mav1 =util?.apply {
            todo1()
            todo2()
            todo3()
            //返回it
        }

    }



    fun rangeTest(i:Int){
        //in [1,9] todo
        if(i in 1..9){

        }
        //不在1-9区间内
        if(i !in 1..9){

        }
        //until [1,8)
        for(o in 1 until 8){

        }

        //downTo倒叙判断

        for(o in 9 downTo 1){

        }

        //step

        for(o in 1..22 step 2){

        }

    }

    var str1:String = "wwww"
    var str2:String = "aaaa"
    fun other(){
        var a = """
           |str1
           |str2
            """.trimIndent()


    }

///
// 或返回Unit（类似Java的void，无意义）


}