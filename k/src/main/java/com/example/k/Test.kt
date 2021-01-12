package com.example.k


//class Person constructor(firstName:String){
//
//}
//
//class Person1(firstName:String){
//
//}
class InitOrderDemo(name:String){
    val first="First"
    init {
        println(first)
    }
    val second="second"
    init {
        print(second)
    }
}

class Person(val first:String)

//初始化块中的代码实际上是主构造函数的一部分
// init
class Constructors{
    init {
        print("Init block")
    }

    constructor(i:Int){
        print("Constructor")
    }
}

fun main(){
//    InitOrderDemo("测试")
//    Constructors(1)
//
//    println("Constructors Derived (\" hello\",\"world\")")
    Derived("hello","world")
}

//创建类的实例类似调用函数  没有new

//继承  Any hashCode equals toString
// open 关键字 可继承
//

open class Base(val name:String){
    init{
        println("initializing BAse " +name)
    }
    open val size:Int=name.length.also{println("initializing size inBase :$it")}
}

class Derived(name:String,val lastName:String):Base(name.capitalize().also { println("argument for base $it") }){
    init {
        println("init Derived")
    }

    override val size: Int=(super.size+lastName.length).also {
        println("init size in derived $it")
    }

}




