package com.hcy.kotlindiceroller.generics

import com.hcy.kotlindiceroller.Aquarium
import com.hcy.kotlindiceroller.expand.print

/**
 * 描述：泛型学习类
 * @author 侯程月
 * @date 2020/9/18
 */


/**
 * 供水
 */
open class WaterSupply(var needsProcessing: Boolean)

/**
 * 水塔供水
 */
class TapWater : WaterSupply(true)

/**
 *鱼储存水
 */
class FishStoreWater : WaterSupply(false)

/**
 * 湖泊存水
 */
class LakeWater : WaterSupply(true) {
    fun filter() {
        needsProcessing = false
    }
}


fun genericsExample() {
//    val aquarium = Aquarium<TapWater>(TapWater())
//    val aquarium1=Aquarium(TapWater())
//    aquarium1.waterSupply.print()
    val aquarium2 = Aquarium(LakeWater())
    aquarium2.waterSupply.filter()
    aquarium2.addWater()

}

//class Aquarium<T : WaterSupply>(val waterSupply: T) {
//    fun addWater() {
//        check(!waterSupply.needsProcessing) { "water supply needs processing first" }
//        println("adding water from $waterSupply")
//    }
//}

class Aquarium<out T : WaterSupply>(val waterSupply: T) {
    fun addWater() {
        check(!waterSupply.needsProcessing) { "water supply needs processing first" }
        println("adding water from $waterSupply")
    }
}

fun addItemTo(aquarium: Aquarium<WaterSupply>) = print("item added")

//输入 输出 一种in类型是，只能传递到类的类型，不予退换。一种out类型是，只能从一个类返回一个类型。
/**
 * 注意：

val和var关于变量的值。val保护变量值不被更改。

in和out有关变量的类型。in并out确保在使用泛型类型时，只有安全类型可以传入和传出函数
 */


fun main() {
    genericsExample()
}