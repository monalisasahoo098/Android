package Day4

fun main() {
    val coffeeBeans = listOf(
        CoffeeBean("Arabica", "Light"),
        CoffeeBean("Robusta", "Medium"),
        CoffeeBean("Liberica", "Dark"),
        CoffeeBean("Excelsa", "Medium")
    )
     println(coffeeBeans.joinToString(separator = "\n"))
}
data class CoffeeBean(val name: String, val roastLevel: String)
