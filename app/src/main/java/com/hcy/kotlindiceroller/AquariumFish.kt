package com.hcy.kotlindiceroller

/**
 * 将为AquariumFish所有鱼共有的属性创建一个抽象类。
 * @author 侯程月
 * @date 2020/9/17
 */
abstract class AquariumFish {
    /**
     * 颜色
     */
    abstract val color: String
}

interface FishAction{
    fun eat()
}
interface AquariumAction {
    fun eat()
    fun jump()
    fun clean()
    fun catchFish()
    fun swim()  {
        println("swim")
    }
}
/**
 * 鲨鱼
 */
class Shark : AquariumFish(),FishAction {
    override val color: String = "gray"
    override fun eat() {
        println("捕杀并吃鱼")
    }
}

/**
 * 金鱼
 */
class Plecostomus : AquariumFish(),FishAction {
    override val color: String = "gold"
    override fun eat() {
        println("吃藻类")
    }
}
fun makeFish(){
    val shark = Shark()
    shark.eat()
    val pleco = Plecostomus()
    pleco.eat()
    println("Shark: ${shark.color}")
    println("Plecostomus: ${pleco.color}")
}
fun main(){
    makeFish()
}