package com.hcy.kotlindiceroller.annotation

/**
 * 描述：注解的学习
 * @author 侯程月
 * @date 2020/9/19
 */
class test {

}

fun labels() {
    outLoop@ for (i in 1..100) {
        println("${i}")

        for (j in 1..100) {
            if (i > 10) break@outLoop
//            breaks to outer loop
        }
    }
}

/**
 * 创建带有参数的lambda，该参数dirty: Int进行计算并除以dirty2。
 * 将lambda分配给变量waterFilter。
 */
val waterFiter = { dirty: Int ->
    dirty / 2

}

/**
 * 筛选器lamabda
 */
private fun fiterLambda() {
    val myFish = listOf(
        Fish("Flipper"),
        Fish("Moby Dick"),
        Fish("Dory")
    )
    val filter = myFish.filter {
        it.name.contains("i")
    }.joinToString (" & "){ it.name }
//    该joinToString()函数通过加入过滤后的名称（由指定的字符串分隔）来创建字符串。
//    它是Kotlin标准库中内置的许多有用功能之一
    println(filter)
}


fun main() {
//    testAnnotations()
//    labels()
//    val waterFiter1 = waterFiter(30)
//    println(waterFiter1)

    fiterLambda()

}


