package com.hcy.kotlindiceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView

/**
 * Kotlin 学习项目
 * https://codelabs.developers.google.com/codelabs/basic-android-kotlin-training-conditional-dice-roll-behavior/index.html?index=..%2F..basic-android-kotlin-training#2
 * @author 侯程月
 * @date 2020/09/17
 */
class MainActivity : AppCompatActivity() {
    private lateinit var diceImage: AppCompatImageView
    private lateinit var btnRoll:AppCompatButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImage = findViewById(R.id.diceImage)
        btnRoll=findViewById(R.id.btnRoll)
        btnRoll.setOnClickListener { rollDice() }
    }

    /**
     * 抛骰子
     */
    private fun rollDice() {
        val roll = Dice(6).roll()
        when (roll) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }
    }
}


fun main() {
    val myFirstDice = Dice(32)
    val rollResult = myFirstDice.roll()

    /**
     * 幸运数字
     */
    val luckyNumber = 4
//    打印一句
//    println("你的${myFirstDice.numSides}面骰子，投中点数是${rollResult}")
//    if-else
//    if (rollResult==luckyNumber){
//        println("你赢了！")
//    }else{
//        println("你没有赢，再试一次吧！")
//    }
//    if (rollResult == luckyNumber) {
//        println("You win!")
//    } else if (rollResult == 1) {
//        println("So sorry! You rolled a 1. Try again!")
//    } else if (rollResult == 2) {
//        println("Sadly, you rolled a 2. Try again!")
//    } else if (rollResult == 3) {
//        println("Unfortunately, you rolled a 3. Try again!")
//    } else if (rollResult == 4) {
//        println("No luck! You rolled a 4. Try again!")
//    } else if (rollResult == 5) {
//        println("Don't cry! You rolled a 5. Try again!")
//    } else {
//        println("Apologies! you rolled a 6. Try again!")
//    }
//    wihen 的使用
//    when (rollResult) {
//        luckyNumber -> println("You won!")
//        1 -> println("So sorry! You rolled a 1. Try again!")
//        2 -> println("Sadly, you rolled a 2. Try again!")
//        3 -> println("Unfortunately, you rolled a 3. Try again!")
//        4 -> println("No luck! You rolled a 4. Try again!")
//        5 -> println("Don't cry! You rolled a 5. Try again!")
//        6 -> println("Apologies! you rolled a 6. Try again!")
//        else->{println("Apologies! you rolled a ${rollResult}. Try again!")}
//    }
}

/**
 * 骰子
 * @param numSides 变数
 */
class Dice(val numSides: Int) {
    /**
     * 旋转
     */
    fun roll(): Int {
        return (1..numSides).random()
    }
}

