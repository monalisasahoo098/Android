package Day4

fun main() {
    val customer = Customer("Mona")
    customer.addPoints(100)
    customer.addPoints(50)
    customer.addPoints(20)
}
class Customer(val name: String) {
    var loyaltyPoints: Int = 0
    fun addPoints(points: Int) {
        if (points > 0) {
            loyaltyPoints += points
            println(" After adding $points points,Total loyalty point of $name is : $loyaltyPoints")
        } else {
            println("Invalid points. Points must be positive.")
        }
    }
}


