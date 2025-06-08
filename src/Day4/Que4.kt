package Day4

fun main(){
    println(Customer("Monalisa"))
    println(Customer(null))
}
fun Customer(name:String?):String{
    val guestName=name?:"Guest"
    return "Good Morning dear $guestName"
}