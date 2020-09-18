package com.hcy.kotlindiceroller.sealed

/**
 *密封类的学习
 * 因为这些类和子类在同一个文件中，所以Kotlin将静态地知道所有子类。
 * 也就是说，在编译时，编译器会看到所有类和子类，并且知道所有这些类和子类，因此编译器可以为您做额外的检查。
 *
 * 个人理解 不能在其他文件继承改文件下的类和子类
 *
 */
fun main() {
    val matchSeal = matchSeal(SeaLion())
    println(matchSeal)
}

/**
 * 密封
 */
sealed class Seal

/**
 * 海狮
 */
class SeaLion : Seal()

/**
 * 海象
 */
class Walrus : Seal()

fun matchSeal(seal: Seal): String {
    return when (seal) {
        is Walrus -> "walrus"
        is SeaLion -> "sea lion"
    }
}