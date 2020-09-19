package com.hcy.kotlindiceroller.generics

import com.hcy.kotlindiceroller.Aquarium


/**
 * 描述：泛型学习类
 * https://codelabs.developers.google.com/codelabs/kotlin-bootcamp-generics/#5
 * @author 侯程月
 * @date 2020/9/18
 */


/**
 * 供水
 */
open class WaterSupply(var needsProcessing: Boolean) {
    fun addChemicalCleaners() {
        println("添加净水剂！")
    }
}

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


//class Aquarium<T : WaterSupply>(val waterSupply: T) {
//    fun addWater() {
//        check(!waterSupply.needsProcessing) { "water supply needs processing first" }
//        println("adding water from $waterSupply")
//    }
//}
//果删除out关键字，编译器将在调用时给出错误addItemTo()，因为Kotlin不能确保您不会对该类型执行任何不安全的操作。
class Aquariumg<out T : WaterSupply>(val waterSupply: T) {
    fun addWater() {
        check(!waterSupply.needsProcessing) { "water supply needs processing first" }
        println("adding water from $waterSupply")
    }

    fun addWater(cleaner: Cleaner<T>) {
        if (waterSupply.needsProcessing) {
            cleaner.clean(waterSupply)
        }
        println("已经清理！")
    }

    /**
     * 您也可以对方法使用通用函数，即使在具有自己通用类型的类中也是如此。
     * 在此步骤中，您将向其添加通用方法，以Aquarium检查其类型是否为WaterSupply。
    在Aquarium类中，声明一个方法，hasWaterSupplyOfType()该方法采用约束为的通用参数R
    （T已使用）WaterSupply，并返回trueif waterSupply类型为R。
    就像您之前声明的函数一样，但是在Aquarium类内部。


    要进行is检查，您需要告诉Kotlin类型是reified或real，并且可以在函数中使用。
    为此，请inline在fun关键字reified前面和泛型类型前面R。

    注意：一般类型通常仅在编译时可用，并被实际类型替换。要在运行时间之前保持通用类型可用，
    请声明该函数inline并将其设为type reified。
     */

    inline fun <reified R : WaterSupply> hasWaterSupplyofType() = waterSupply is R

}

/**
 * 建立扩充功能
 * 您也可以对常规函数和扩展函数使用修饰类型
 */
inline fun <reified T : WaterSupply> WaterSupply.isofType() = this is T

inline fun <reified R:WaterSupply> Aquariumg<*>.hasWaterSupplyofType()=waterSupply is R


fun additemTo(aquariumg: Aquariumg<WaterSupply>) = println("item add")

//输入 输出 一种in类型是，只能传递到类的类型，不予退换。一种out类型是，只能从一个类返回一个类型。
/**
 * 注意：

val和var关于变量的值。val保护变量值不被更改。

in和out有关变量的类型。in并out确保在使用泛型类型时，只有安全类型可以传入和传出函数
 */


/**
 *该in类型类似于该out类型，但是对于仅传递给函数而不返回的泛型类型。
 * 如果尝试返回in类型，则会出现编译器错误。
 * 在此示例中，您将定义in类型作为接口的一部分。
 */
interface Cleaner<in T : WaterSupply> {
    fun clean(waterSupply: T)
}

class TapWaterCleaner : Cleaner<TapWater> {
    override fun clean(waterSupply: TapWater) = waterSupply.addChemicalCleaners()
}

/**
 * Kotlin将使用the in和outtype信息来确保您的代码安全地使用泛型。
 * Out而且in很容易记住：out类型可以作为返回值向外传递，in类型可以作为参数向内传递。
 */


/**
 * 要使该函数具有通用性，请将尖括号放在fun具有通用类型T和任何约束的关键字之后，在这种情况下为WaterSupply。
 * 更改Aquariumg为受T而不是受约束WaterSupply。
 */
fun <T : WaterSupply> isWaterClearn(aquariumg: Aquariumg<WaterSupply>) {
    println("aquarum water is clean: ${!aquariumg.waterSupply.needsProcessing} ")
}


fun main() {
    genericsExample()
}

fun genericsExample() {
//    val aquarium = Aquarium<TapWater>(TapWater())
//    val aquarium1=Aquarium(TapWater())
//    aquarium1.waterSupply.print()
//    val aquarium2 = Aquariumg(LakeWater())
//    aquarium2.waterSupply.filter()
//    aquarium2.addWater()


//    val tapWaterCleaner = TapWaterCleaner()
    val aquariumg = Aquariumg(TapWater())
////    additemTo(aquariumg)
//    aquariumg.addWater(tapWaterCleaner)

//    isWaterClearn<TapWater>(aquariumg)

//    println(aquariumg.hasWaterSupplyofType<TapWater>())

//    println(aquariumg.waterSupply.isofType<TapWater>())

//    println(aquariumg.hasWaterSupplyofType<LakeWater>())
}

