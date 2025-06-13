package Day5

fun main(){
    val num = listOf(1, 2, 3, 4, 5)
    val double = operateOnList(num) { it * 2 }
    println("Numbers after the double operation are: $double")
}
fun operateOnList(list: List<Int>, operation: (Int) -> Int): List<Int> {
    val result = mutableListOf<Int>()
    for (item in list) {
        result.add(operation(item))
    }
    return result
}

