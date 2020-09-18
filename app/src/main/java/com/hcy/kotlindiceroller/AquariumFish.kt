package com.hcy.kotlindiceroller

/**
 * 将为AquariumFish所有鱼共有的属性创建一个抽象类。
 * @author 侯程月
 * @date 2020/9/17
 */
abstract class AquariumFish : FishAction {
    /**
     * 颜色
     */
    abstract val color: String
    override fun eat() {
        println("yum")
    }
}

interface FishAction {
    fun eat()
}

interface AquariumAction {
    /**
     * 吃
     */
    fun eat()

    /**
     * 跳
     */
    fun jump()

    fun clean()
    fun catchFish()
    fun swim() {
        println("swim")
    }
}

/**
 * 鲨鱼
 */
class Shark : AquariumFish(), FishAction {
    override val color: String = "gray"
    override fun eat() {
        println("捕杀并吃鱼")
    }
}

/**
 * FishColor by Goldcolor 接口委托
 *
 * 金鱼
 */
//class Plecostomus : FishColor by Goldcolor,FishAction {
//    override fun eat() {
//        println("吃藻类")
//    }
//}

//class Plecostomus(fishColor: FishColor = Goldcolor) : FishAction, FishColor by fishColor {
//    override fun eat() {
//        println("eat algae")
//    }
//
//}
class Plecostomus(fishColor: FishColor = Goldcolor) :
    FishAction by PrintingFishAction("吃水藻"),
    FishColor by fishColor {}

fun makeFish() {
    val shark = Shark()
    shark.eat()
    val pleco = Plecostomus()
    pleco.eat()
    println("Shark: ${shark.color}")
    println("Plecostomus: ${pleco.color}")
}

/**
 * 鱼的颜色
 */
interface FishColor {
    /**
     * 颜色
     */
    val color: String
}

/**
 * 金色
 */
object Goldcolor : FishColor {
    override val color = "金色"
}

/**
 * 灰色
 */
object Graycolor : FishColor {
    override val color = "灰色"
}

class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}


fun main() {
    makeFish()
}