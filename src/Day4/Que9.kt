package Day4

fun main() {
    val coffees = listOf("Espresso","Cappuccino","Latte", "Cortado", "Mocha","Cold Brew","Americano")
    val Coffee = CoffeeStartingWithC(coffees)
    println("Coffees starting with C are : $Coffee")
}
fun CoffeeStartingWithC(coffeeList: List<String>): List<String> {
    return coffeeList.filter { coffee -> coffee.startsWith("C", ignoreCase = true)
    }
}
