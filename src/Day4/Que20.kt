package Day4

fun main() {
    val coffees = listOf("Latte", "Espresso", "Cappuccino", "Mocha", "Americano")
    firstCoffee(coffees)
}
fun firstCoffee(coffees: List<String>) {
    val first = coffees.sorted().firstOrNull()
    println(
        if (first != null)
            "First one is $first"
        else
            "No coffees available."
    )
}




