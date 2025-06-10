package Day4

fun main() {
    val menu = CoffeeMenu(listOf("Espresso", "Latte", "Cappuccino", "Mocha","Americano"))
    menu.printItems()
}
data class CoffeeMenu(val items: List<String>) {
    fun printItems() {
        println("All items are")
        println(items)
    }
}