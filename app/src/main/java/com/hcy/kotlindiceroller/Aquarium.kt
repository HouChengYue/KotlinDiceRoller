package com.hcy.kotlindiceroller

import java.lang.Math.PI


/**
 * @description：水族馆
 * @author 侯程月
 * @date 2020/9/17
 */
open class Aquarium(length: Int = 100, width: Int = 20, height: Int = 40) {
//    init {
//        println("aquarium initializing")
//    }
//
//    init {
//        // 1 liter = 1000 cm^3
//        println("Volume: ${width * length * height / 1000} l")
//    }

    constructor(numberOfFish: Int) : this() {
        val tank = numberOfFish * 2000 * 1.1
        // calculate the height needed
        height = (tank / (length * width)).toInt()
    }

    /**
     * 容积
     */
    open var volume: Int
        get() = width * height * length / 1000  // 1000 cm^3 = 1 l
        set(value) {
            height = (value * 1000) / (width * length)
        }

    /**
     * 形状
     */
    open val shape="rectangle"

    /**
     * 存水量
     */
    open var water: Double = 0.0
        get() = volume * 0.9

    var width: Int = width
    open var height: Int = height
    var length: Int = length

    /**
     * 打印size
     */
    fun printSize() {
        println(shape)
        println("Width: $width cm " +
                "Length: $length cm " +
                "Height: $height cm ")
        // 1 l = 1000 cm^3
        println("Volume: $volume l Water: $water l (${water/volume*100.0}% full)")
    }
}

/**
 * 创建水族馆
 */
fun buildAquarium() {
//    val aquarium1 = Aquarium()
//    aquarium1.printSize()
//    // default height and length
//    val aquarium2 = Aquarium(width = 25)
//    aquarium2.printSize()
//    // default width
//    val aquarium3 = Aquarium(height = 35, length = 110)
//    aquarium3.printSize()
//    // everything custom
//    val aquarium4 = Aquarium(width = 25, height = 35, length = 110)
//    aquarium4.printSize()
//
//    val aquarium6 = Aquarium(numberOfFish = 29)
//    aquarium6.printSize()
//    println("Volume: ${aquarium6.width * aquarium6.length * aquarium6.height / 1000} l")
//    Aquarium(width = 20,length = 100,height = 31).printSize()

//    val aquarium6 = Aquarium(numberOfFish = 29)
//    aquarium6.printSize()
//    aquarium6.volume = 70
//    aquarium6.printSize()

    val myAquarium = Aquarium(width = 25, length = 25, height = 40)
    myAquarium.printSize()
    val myTower = TowerTank(diameter = 25, height = 40)
    myTower.printSize()
}

/**
 * 水罐
 */
class TowerTank (override var height: Int, var diameter: Int): Aquarium(height = height, width = diameter, length = diameter) {
    override var volume: Int
        // ellipse area = π * r1 * r2
        get() = (width/2 * length/2 * height / 1000 * PI).toInt()
        set(value) {
            height = ((value * 1000 / PI) / (width/2 * length/2)).toInt()
        }

    override var water = volume * 0.8

    override val shape = "cylinder"
}


fun main() {
    buildAquarium()
}