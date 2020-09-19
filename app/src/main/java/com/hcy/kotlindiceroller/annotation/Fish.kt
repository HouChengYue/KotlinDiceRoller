package com.hcy.kotlindiceroller.annotation

import com.hcy.kotlindiceroller.expand.print

/**
 * 描述：高阶函数
 * @author 侯程月
 * @date 2020/9/19
 */
data class Fish(var name: String)

fun fishExamples() {
    val fish = Fish("splashy")
//    该with()函数使您可以以更紧凑的方式对一个对象或属性进行一个或多个引用
//    。使用this。with()实际上是一个高阶函数，在lamba中，您指定如何处理提供的对象。
//    with(fish.name){
//        this.capitalize().print()
//    }
//    myWith(fish.name){
//        this.capitalize().print()
//    }
    val fish2 = Fish(name = "splashy").apply {
        name = "sharky"
    }
//    fish2.print()
//    println(fish2.let {
//        it.name.capitalize()
//    }.let {
//        println(it)
//        it+"fish"
//    }.let {
//        println(it)
//        it.length
//    }.let {
//        println(it)
//        it + 31
//    }
//    )
    fish.name.capitalize()
}

/**
 * 在中Fish.kt，定义一个带有myWith()两个参数的函数。
 * 参数是要操作的对象，也是定义操作的函数。
 * 该函数的参数名称的约定为block。在这种情况下，该函数将不返回任何内容，该内容由指定Unit。
 */
inline fun myWith(name: String, block: String.() -> Unit) {
    name.block()
}


fun runExample() {
    val runnable = object : Runnable {
        override fun run() {
            println("这是一个Runnable")
        }
    }
    JavaRun.runNow(runnable)

}
fun runExample1(){
    JavaRun.runNow {
        println("这是一条新的Runnable!")
    }
}

fun main() {
//    fishExamples()
//    runExample()
    runExample1()

}