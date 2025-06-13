package Day5

fun main() {
    val list = listOf(1, 2, 3, 4, 5, 6)
    println(getElement(list, 3))
    println(getElement(list, 8))
}
fun getElement(list: List<Int>, index: Int): Int? {
    return try {
        list[index]
    } catch (e: IndexOutOfBoundsException) {
        println("The element at index $index is not in the list ")
        null
    }
}
