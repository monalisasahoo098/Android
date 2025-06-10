package Day4

fun main() {
    val machine = CoffeeMachine("On")
    machine.status = "On"
    machine.brewCoffee()
}
class CoffeeMachine(var status: String) {
    fun brewCoffee() {
        println(if (status == "On") "Brewing coffee" else "Can't brew: machine is $status")
    }

}


