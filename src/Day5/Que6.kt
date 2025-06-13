package Day5

fun main(){
    val num="abc"
    val number= try{
        num.toInt()
    }catch (e: NumberFormatException){
        println("Invalid number")
    }
}