package com.example.btvn
import kotlin.math.PI

//Lớp trừu tượng có một thuộc tính và một phương thức trừu tượng
abstract class Dwelling(protected var residents: Int) {
    abstract val buildingMaterial: String
    abstract val capacity: Int
    abstract fun floorArea(): Double

    fun hasRoom(): Boolean {
        return residents < capacity
    }
}

//Đánh dấu một lớp là open để lớp đó có thể phân lớp con
open class RoundHut(residents: Int, protected val radius: Double) : Dwelling(residents) {

    override val buildingMaterial: String = "Straw"
    override val capacity: Int = 4

    override fun floorArea(): Double {
        return PI * radius * radius
    }
}

//Tạo lớp con bằng cách mở rộng lớp mẹ
class SquareCabin(residents: Int, radius: Double, private val floors: Int) : RoundHut(residents, radius) {
    override val buildingMaterial: String = "Wood"
    override val capacity: Int = 6

    //Ghi đè một hàm từ lớp cao cấp
    override fun floorArea(): Double {
        return super.floorArea() * floors
    }
}

//Số lượng đối số hàm có thể thay đổi
fun addTopping(vararg toppings: String) {
    for (topping in toppings) {
        println("Topping: $topping")
    }
}

fun main() {
    //Xác định một danh sách chỉ có thể đọc
    val numbers = listOf(1, 2, 3, 4, 5, 6)

    //Lấy kích thước của danh sách
    val size = numbers.size
    println("Size: $size")

    //Lấy mục đầu tin trong danh sách
    val first = numbers[0]
    println("First: $first")

    //Lấy bản sao của danh sách theo thứ tự đảo ngược
    val colors = listOf("red", "blue", "green").reversed()
    println(colors)

    //Xác định một danh sách các chuỗi có thể thay đổi
    val entrees = mutableListOf<String>()

    //Thêm một mục vào danh sách có thể thay đổi
    entrees.add("spaghetti")

    //Sửa đổi một mục trong danh sách có thể thay đổi
    entrees[0] = "lasagna"

    //Xóa một mục khỏi danh sách có thể thay đổi
    entrees.remove("lasagna")

    //Sử dụng vòng lặp for để lặp lại các mục trong một danh sách
    for (element in numbers) {
        //Perform an operation with each item
        println(element)
    }

    //Sử dụng vòng lặp while để lặp lại các mục trong một danh sách
    var index = 0
    while (index < numbers.size) {
        println(numbers[index])
        index++
    }

    //Số ký tự trong một Chuỗi
    val name = "Android"
    println(name.length)

    //Sử dụng một biến trong mẫu Chuỗi
    val number = 10
    println("$number people")

    //Sử dụng một biểu thức trong mẫu Chuỗi
    val groups = 5
    println("${number * groups} people")

    val squareCabin = SquareCabin(
        residents = 3,
        radius = 5.0,
        floors = 2
    )

    //Sử dụng with để đơn giản hóa việc truy cập vào một đối tượng
    with(squareCabin) {
        println("Capacity: ${capacity}")
        println("Material: ${buildingMaterial}")
        println("Has room? ${hasRoom()}")
    }

    //Sử dụng tên đủ điều kiện cho một hằng số trong thư viện toán học Kotlin
    val area = kotlin.math.PI * 3 * 3
    println(area)

    //Vararg
    addTopping("Cheese", "Onion", "Olives")
}