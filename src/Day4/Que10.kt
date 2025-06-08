package Day4

fun main() {
    val cup1 = CoffeeCup(40)
    val cup2 = CoffeeCup(80)

    cup1.isTooHot()
    cup2.isTooHot()
}
class CoffeeCup(var temperature: Int) {

    fun isTooHot(){
        if (temperature > 70){
            println("Coffee having temperature $temperature is too hot ")
        }else{
            println("Coffee having temperature $temperature is not so hot ")
        }
    }
}

