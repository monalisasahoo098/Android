package Day4

fun main(){
val ord1=CoffeeOrder(type="Espresso",size="Large")
    var ord2=CoffeeOrder(type="Latte",size="Small")
  Summary(ord1)
    Summary(ord2)
}
data class CoffeeOrder(
    val type: String,
    val size: String
)
fun Summary(order:CoffeeOrder){
    println("your order:${order.type} -> ${order.size}")
}