package Day5

fun main() {
    try {
        checkNumber(20)
        checkNumber(-20)
    } catch (e: NegativeNumber) {
        println("Error: ${e.message}")
    }
}
class NegativeNumber(message: String) : Exception(message)
fun checkNumber(number: Int) {
    if (number < 0) {
        throw NegativeNumber("$number is a negative number")
    }
    println("$number is a valid number")
}

