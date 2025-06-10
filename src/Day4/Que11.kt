package Day4

fun main() {
    val coffeeSize: String? = null
    val price = CoffeePrice(coffeeSize)
    println("The price of a ${coffeeSize ?: "default"} size coffee is $price")
}

fun CoffeePrice(coffeeSize: String?): Double {
    return when (coffeeSize?.lowercase()) {
        "small" -> 50.0
        "medium" -> 150.0
        "large" -> 300.0
        else -> 0.0
    }
}
