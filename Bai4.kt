package com.example.btvn

import kotlinx.coroutines.*
import java.lang.Exception
import kotlin.random.Random

//Khai báo hàm tạm ngưng
suspend fun getValue(): Double {
    delay(500)
    // long running work or calls to other suspend functions
    return Random.nextDouble(0.0, 100.0)
}

//Gọi hàm tạm ngưng từ một hàm tạm ngưng khác
suspend fun processValue() {
    val value = getValue()
    // modify the value
    println("Processed value: ${value * 2}")
}

//Khai báo một đối tượng
object DataProviderManager {
    fun getData(): String {
        return "Data from provider"
    }
}

//Tạo một lớp enum
enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

fun main() {
    //Chạy một hàm tạm ngưng trong GlobalScope
    GlobalScope.launch {
        val output = getValue()
        println("GlobalScope output: $output")
    }

    //Trụy cập vào một Tác vụ coroutine
    val job: Job = GlobalScope.launch {
        val output = getValue()
        println("Job output: $output")
    }

    //Hủy một Tác vụ coroutine
    job.cancel()

    //Chạy một hàm tạm ngưng và chặn luồng hiện tại cho đến khi hàm này hoàn tất
    runBlocking {
        val output = getValue()
        println("runBlocking output: $output")
    }

    //Sử dụng hàm không đồng bộ để cho phép trì hoãn hàm tạm ngưng
    runBlocking {
        val deferred: Deferred<Double> = async {
            getValue()
        }

        println("Async output: ${deferred.await()}")
    }

    runBlocking {
        processValue()
    }

    //In đối tượng
    println(DataProviderManager.getData())

    //Phát hiện một ngoại lệ
    try {
        val result = 10 / 0
        println(result)
    } catch (exception: Exception) {
        println("Caught exception: ${exception.message}")
    }

    //Truy cập vào một giá trị lớp enum
    val direction = Direction.NORTH

    //Kiểm tra các giá trị enum
    when (direction) {
        Direction.NORTH -> println("Going north")
        Direction.SOUTH -> println("Going south")
        Direction.WEST -> println("Going west")
        Direction.EAST -> println("Going east")
    }

    Thread.sleep(1000)
}