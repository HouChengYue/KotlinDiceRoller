package com.hcy.kotlindiceroller.decor

import com.hcy.kotlindiceroller.annotation.testAnnotations

/**
 * 数据类相关
 * @ https://codelabs.developers.google.com/codelabs/kotlin-bootcamp-classes/#8
 * @author 侯程月
 * @date 2020/9/18
 * *Decoration 装修 rocks 石材
 */
data class Decoration(
    val rocks: String="",
    val rock: String="",
    val wood: String="",
    val diver: String=""
) {}

/**
 * 动作 装修
 */
fun makeDecorations() {
//    val decoration = Decoration("花岗岩")
//    println(decoration)
//    val decoration1 = Decoration("石板")
//    println(decoration1)
//    val decoration2 = Decoration("石板")
//    println(decoration2)
//    println(decoration == decoration1)
//    println(decoration1 == decoration2)
    /**
     * 在Kotlin中，==对数据类对象的使用与equals()（结构相等）的使用相同。如果需要检查两个变量是否引用同一对象（引用相等），请使用===运算符。
     * 尽管它们在某些语言中类似于结构，但请记住，数据类对象是对象。将数据类对象分配给另一个变量将复制对该对象的引用，而不是内容。要将内容复制到新对象，请使用copy()方法。
     */
//    println(decoration1===decoration2)
//
//    val d3=decoration
//    val d4=decoration.copy()
//    println("d3==decoration${d3==decoration}")
//    println("d3===decoration${d3===decoration}")
//    println("d4==decoration${d4==decoration}")
//    println("d4===decoration${d4===decoration}")
    val d5 = Decoration("crystal", "wood", "diver")
    println(d5)

// Assign all properties to variables.
    val (rock, wood, diver) = d5
    println(rock)
    println(wood)
    println(diver)
//  如果不需要一个或多个属性，可以使用_而不是变量名来跳过它们，如下面的代码所示。
    val (a,_,c)=d5
    val (d,e)=d5
    println(a)
    println(c)
    println(d)
    println(e)

}

fun main() {
    makeDecorations()
}