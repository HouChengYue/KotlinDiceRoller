package com.hcy.kotlindiceroller.expand

import android.os.Build
import com.hcy.kotlindiceroller.singleton.Color
import com.hcy.kotlindiceroller.singleton.GoldColor
import com.hcy.kotlindiceroller.singleton.eColor

/**
 * 描述：双联 三联等
 * @author 侯程月
 * @date 2020/9/18
 */
fun main() {
////一个双联
//    val double="第一部分" to "第二部分"
//    println("${double.first}到${double.second}")
////一个三联
//    val num=Triple(1,2,3)
//    println(num.toString())
//    println(num.toList())
//
//    val equipment2 = ("fish net" to "catching fish") to "equipment"
//    println("${equipment2.first} is ${equipment2.second}\n")
//    println("${equipment2.first.second}")
//
//    val numbers = Triple(6, 9, 42)
//    val (n1, n2, n3) = numbers
//    println("$n1 $n2 $n3")

//
////    集合部分
//    val list = listOf(1, 2, 3, 4)
//    返回反序的副本
//    var reversed = list.reversed()
//    val list1 = listOf("1", "12", "123", "1234", "1")
//    println(list.sum())
//    println(list1.sumBy { it.length })
//
////    listIterator()从列表中选择，然后使用for语句遍历该列表并打印所有用空格分隔的元素。
//    val list2 = listOf("a", "bbb", "cc")
//    for (s in list2.listIterator()) {
//        println("$s ")
//    }
//    val map = hashMapOf<String, expand>()
//    map["1"] = expand(1)
//    map["2"] = expand(2)
//    val cures = hashMapOf(
//        "white spots" to "Ich", "red sores" to "hole disease",
//        Pair("12", expand(1))
//    )
//    val one = hashMapOf("1" to expand(1), "2" to expand(2))
//    println(one.get("2")!!.num)
////    android n 以上
////    println(map.getOrDefault("1231231", expand(1223)).num)
//    println(map.size)
//    println(map.getOrElse("123456") { "没有值！！" })
//    val orPut = map.getOrPut("123456", { expand(123) })
//    println(orPut.num)
//    println(map.size)
//    println(PI)
//    getnewPi()


//    拓展部分

//    println("Does it have spaces?".hasSpaces())

//    PI.print()

//    var one = One()
//    val two = Two()
//    fun One.print() = println("One print")
//    fun Two.print() = println("Two print")
//    two.print()
//    打印出Two print
//    println(GoldColor.Green)
//        eColor.BLUE.WRITE

    var one: One? = null
    one.getOne()

}

//您扩展的类称为Receiver，
// 可以使该类为空。如果这样做，this则主体中使用的变量可以是null，
// 因此请确保对此进行测试。如果您希望调用者希望对可为空的变量调用扩展方法，
// 或者希望在将函数应用于时提供默认行为，则希望使用可为空的接收器null。
fun One?.getOne() {
    this?.apply {
        println("getOne${this}")
    }
    this.run {
        println("getOne 没有值！")
    }
}


val Color.Green: String
    get() = "green"

val eColor.WRITE: Int
    get() = 0XFFFFFF

fun Any.print() {
    println(this.toString())
}

fun getnewPi(): Any {
    return 3.1415926
}

const val PI = 3.1413926

//fun String.hasSpaces():Boolean{
//    val found = this.find { it==' ' }
//    return found!=null
//}
//fun String.hasSpaces() = find { it == ' ' } != null
//
//第2步：了解扩展程序的局限性
//扩展功能只能访问它们正在扩展的类的公共API。private无法访问的变量。
//
//尝试将扩展功能添加到标记为的属性中private。
//class AquariumPlant(val color: String, private val size: Int)
//
//fun AquariumPlant.isRed() = color == "red"    // OK
//fun AquariumPlant.isBig() = size > 50         // gives error


class expand(val num: Int) {
    /**
     * 伴随对象
     * 伴随对象是从包含类的静态构造函数初始化的，也就是说，它们是在创建对象时创建的。
     *常规对象在第一次访问该对象时会被延迟初始化。也就是说，当它们第一次使用时。
     *
     */
    companion object {

        const val CONSTANT3 = "constant in companion"
    }
}

open class One {}

class Two : One() {}
