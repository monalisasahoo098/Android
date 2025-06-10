package Day4


fun main() {
    val coffeeOrders = setOf("Latte", "Espresso", "Cappuccino", "Latte", "Mocha","Americano","Mocha","Espresso")
   Orders(coffeeOrders)
}
fun Orders(orders: Set<String>) {
    val Count = orders.size
    println("Number of unique coffee orders: $Count")
}