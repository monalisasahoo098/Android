package Day4

fun main() {
    val coffeeType: String? = "Latte"
    validCoffee(coffeeType)
    val invalidCoffee: String? = "Macchiato"
    validCoffee(invalidCoffee)
    val nullCoffeeType: String? = null
    validCoffee(nullCoffeeType)
}
fun validCoffee(coffeeType: String?) {
    val validCoffeeTypes = listOf("Espresso", "Latte", "Cappuccino", "Mocha")
    when {
        coffeeType == null -> println("There is no coffee type")
        coffeeType in validCoffeeTypes -> println("$coffeeType is a valid coffee type.")
        else -> println("$coffeeType is not a valid coffee type.")
    }
}

