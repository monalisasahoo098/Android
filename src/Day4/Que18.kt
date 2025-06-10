package Day4

fun main() {
    val coffeePrices = mapOf(
        "Espresso" to 50.0,
        "Latte" to 120.0,
        "Cappuccino" to 200.0,
        "Mocha" to 150.0,
        "Americano" to 80.0
    )
    ExpensiveCoffee(coffeePrices)
}
fun ExpensiveCoffee(menu: Map<String, Double>) {
    menu.maxByOrNull(Map.Entry<String, Double>::value)
        ?.let { (name, price) -> println("Most expensive coffee is : $name at $price") }
        ?: println("Menu is empty.")
}


