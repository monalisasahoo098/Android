package Day5

fun main(){
    val num=listOf(1,2,3,4,5,6,7,8,9,10)
    val evenNum=num.filter{it%2==0}
    println("even numbers are")
    println(evenNum)
}