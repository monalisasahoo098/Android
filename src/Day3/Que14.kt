package Day3

fun main(){
    val temp=60
    var msg=when(temp){
       in Int.MIN_VALUE until 50->"Too Cold"
        in 50..70->"Perfect"
        in 70..Int.MAX_VALUE->"Too Hot"
        else->"Enter a valid temperature"
    }
    println("Temp is $temp,$msg")
}