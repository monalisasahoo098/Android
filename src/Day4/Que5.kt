package Day4

fun main(){
val shop=Shop("Amsterdam")
    openingHour(shop)
}
class Shop(val name:String)
fun openingHour(shop:Shop){
    val open="9 Am"
    val close="9 Pm"
    println("${shop.name} is open from $open to $close")
}