package Day4

fun main() {
    val name1 = Barista("Mona", "Americano")
    val name2 = Barista("Sona", null)

    FavoriteCoffee(name1)
   FavoriteCoffee(name2)
}
data class Barista(val name: String, val favoriteCoffee: String?)

fun FavoriteCoffee(barista: Barista) {
    val coffee = barista.favoriteCoffee ?: "Don't have any favorite coffee "
    println("${barista.name} loves to have: $coffee")
}


