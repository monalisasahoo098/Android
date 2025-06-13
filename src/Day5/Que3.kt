package Day5

fun main() {
    val result = applyTwice(50) { it *2 }
    println(result)
}
fun applyTwice(x: Int, op: (Int) -> Int): Int {
    val once = op(x)
    return op(once)
}

