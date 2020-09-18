package com.hcy.kotlindiceroller.singleton

import com.hcy.kotlindiceroller.sealed.SeaLion
import com.hcy.kotlindiceroller.sealed.Seal


interface Color {
    val color: String
}

/**
 * 由于的每个实例都GoldColor做相同的事情，因此将其声明为object而不是，
 * class以使其成为单例。只能有一个实例。
 */
object GoldColor : Color {
    override val color = "金色"
    override fun toString(): String {
        return javaClass.simpleName+ color
    }
}
fun setColor(color: Color){
    println(color.color)
}

fun main() {
    println(GoldColor)
    println(eColor.RED)
    println(Direction.EAST.name)
//    ordinal 排序值
    println(Direction.EAST.ordinal)
    println(Direction.EAST.degrees)
    setDirection(Direction.EAST)
    setColor(GoldColor)
}
fun setDirection(direction: Direction){
    println(direction.name)
}

enum class eColor(val rag:Int){
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF);
}
enum class Direction(val degrees: Int,val other:String="") {
     EAST(90),SOUTH(180),  WEST(270),NORTH(0)
}
