package com.example.btvn

fun main() {
    println("Hello World")

    println("Đây là dòng chữ để hiện ra")

    //Đây là một dòng bình luận

    //Biến một lần, không thể thay đổi
    val age = 5
    val name = "Rover"
    println("You are already ${age}!")
    println("You are already ${age} days old, ${name}!")

    //Biến và có thể thay đổi khi cần
    var roll = 6
    var rolledValue : Int = 4

    //Gọi hàm
    printHello()
    printBorder(name, age)
    println(roll())
    roll1()
    printBorder()
    printCakeBottom(age, roll)

    //Câu lệnh có điều kiện với if/else
    val num = roll()
    if (num > 4) {
        println("The variable is greater than 4")
    } else if (num == 4) {
        println("The variable is equal to 4")
    } else {
        println("The variable is less than 4")
    }

    //Câu lệnh có điều kiện với when
    val rollResult: Any = if ((1..7).random() == 7) {
        "luckynumber"
    } else {
        (1..6).random()
    }
    when (rollResult) {
        "luckyNumber" -> println("You won!")
        1 -> println("So sorry! You rolled a 1. Try again!")
        2 -> println("Sadly, you rolled a 2. Try again!")
        3 -> println("Unfortunately, you rolled a 3. Try again!")
        4 -> println("No luck! you rolled a 4. Try again!")
        5 -> println("Don't cry! You rolled a 5. Try again!")
        6 -> println("Apologies! you rolled a 6. Try again!")
    }

    //Tạo thực thể
    val myFirstDice = Dice(6)
    println(myFirstDice.roll())
}

//Định nghĩa một hàm
fun printHello () {
    println ("Hello Kotlin")
}

//Hàm có đối số
fun printBorder(border: String, timesToRepeat: Int) {
    repeat(timesToRepeat) {
        print(border)
    }
    println()
}

//Hàm trả về một giá trị
fun roll(): Int {
    val randomNumber = (1..6).random()
    return randomNumber
}

//Tạo số ngẫu nhiên
val diceRange = (1..6)
val randomNumber = diceRange.random()

fun roll1() {
    val anotherRandomNumber = (1..6).random()
    println(randomNumber)
}

//Lặp lại một thao tác bằng repeat()
fun printBorder() {
    repeat(23) {
        print("=")
    }
    println()
}

//Lồng ghép vòng lặp repeat()
fun printCakeBottom(age: Int, layers: Int) {
    repeat(layers) {
        repeat(age + 2) {
            print("@")
        }
        println()
    }
}

//Lớp có thông số
class Dice (val numSides: Int) {
    fun roll(): Int {
        val randomNumber = (1..numSides).random()
        return randomNumber
    }
}