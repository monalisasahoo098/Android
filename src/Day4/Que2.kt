package Day4

fun main() {
    println(totalPrice(5, 5.5))
    println(totalPrice(10, null))
}
fun totalPrice(quantity: Int, pricePerCup: Double?):Double {
     return quantity * (pricePerCup ?: 0.0)
}

