package Day4

fun main() {
    val coffeePrices = listOf(250.0, 300.0, 350.0, 400.0)
    val discount = 10.0

    val discountedPrices = Prices(coffeePrices, discount)

    println("Original prices: $coffeePrices")
    println("prices after $discount % discount are: $discountedPrices")
}
fun Prices(prices: List<Double>, Percentage: Double): List<Double> {
    return prices.map { price -> price * (1 -Percentage / 100)
    }
}