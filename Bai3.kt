package com.example.btvn

fun main() {
    //Tạo một nhóm từ danh sách
    val numbers = listOf(0, 3, 8, 4, 0, 5, 5, 8, 9, 2)
    val setOfNumbers = numbers.toSet()
    println(setOfNumbers)

    //Xác định một nhóm
    val set1 = setOf(1,2,3)
    val set2 = mutableSetOf(3, 4, 5)

    //Phép toán trên nhóm
    println(set1.intersect(set2)) //3
    println(set1.union(set2)) // 1, 2, 3, 4, 5

    //Xác định một sơ đồ có thể thay đổi
    val peopleAges = mutableMapOf<String, Int>(
        "Fred" to 30,
        "Ann" to 23
    )

    //Đặt một giá trị trong sơ đồ có thể thay đổi
    peopleAges.put("Barbara", 42)
    peopleAges["Joe"] = 51

    //Lặp lại tập hợp
    peopleAges.forEach { print("${it.key} is ${it.value}, ") }
    println()
    // Fred is 31, Ann is 23, Barbara is 42, Joe is 51,

    //Chuyển đổi từng mục trong một tập hợp
    println(peopleAges.map { "${it.key} is ${it.value}" }.joinToString(", ") )
    // Fred is 31, Ann is 23, Barbara is 42, Joe is 51

    //Lọc các mục trong một tập hợp
    val filteredNames = peopleAges.filter { it.key.length < 4 }
    println(filteredNames)
    // {Ann=23, Joe=51}

    //Các phép toán khác trên tập hợp
    val words = listOf("about", "acute", "balloon", "best", "brief", "class")
    val filteredWords = words.filter { it.startsWith("b", ignoreCase = true) }
        .shuffled() // [brief, balloon, best]
        .take(2) // [brief, balloon]
        .sorted() // [balloon, brief]

    println(filteredWords)

}