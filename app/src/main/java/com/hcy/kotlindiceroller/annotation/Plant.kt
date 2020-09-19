package com.hcy.kotlindiceroller.annotation

import kotlin.reflect.full.*    // required import

/**
 * 描述：
 * @author 侯程月
 * @date 2020/9/19
 */
@ImAplant class Plant {
    fun trim() {}
    fun fertilize() {}
    @Target(AnnotationTarget.PROPERTY_GETTER)
    annotation class OnGet
    @Target(AnnotationTarget.PROPERTY_SETTER)
    annotation class OnSet
}


//创建一个打印类中所有方法的函数。
// 用于::class在运行时获取有关类的信息。
// 使用declaredMemberFunctions得到的一个类的方法列表。
// （要访问此内容，您需要导入kotlin.reflect.full.*）
fun testAnnotations() {
    val kClass = Plant::class
//    反射 获取方法
//    for (memberFunction in kClass.declaredMemberFunctions) {
//        println(memberFunction.name)
//    }

//    反射获取注解
//    for (a in kClass.annotations) {
//        println(a.annotationClass.simpleName)
//    }
    val findAnnotation = kClass.findAnnotation<ImAplant>()
    println(findAnnotation)

}
//简单注解
annotation class  ImAplant
//建立目标注解
//注释可以针对getter或setter方法。
// 完成后，您可以使用@get:或@set:前缀应用它们。
// 当使用带有注解的框架时，会出现很多问题。
//声明两个注释，OnGet它们只能应用于属性获取器，并且OnSet只能应用于属性设置器。
// 在每个上使用@Target(AnnotationTarget.PROPERTY_GETTER)或PROPERTY_SETTER。
