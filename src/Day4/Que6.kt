package Day4

fun main() {
    val Prices = listOf(199.0, 290.5, 285.75, 299.0)
    val maxPrice = CoffeePrice(Prices)

    if (maxPrice != null) {
        println("The highest coffee price is $maxPrice")
    } else {
        println("Price is unavailable.")
    }
}
fun CoffeePrice(prices: List<Double>): Double? {
    return prices.maxOrNull()
}
