package Day3

fun main(){
    val day = 5
   val message= when(day){
        1->"Monday,Espresso Time"
        2->"Tuesday,Cappuccino Time"
        3->"Wednesday,Latte Time"
        4->"Thursday,Cold Brew Time"
        5->"Friday,Americano Time"
        6->"Saturday,Mocha Time"
        7->"Sunday,Iced Coffee Time"
        else -> "day number is invalid"
    }
    println(message)
}