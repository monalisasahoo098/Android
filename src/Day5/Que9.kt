package Day5

fun main(){
  val divide1=exception(100,5)
    println("result=$divide1")
    val divide2=exception(100,0)
    println("result=$divide2")
}
fun exception(num:Int,dnum:Int):Int?{
return  try{
        num/dnum
    }catch (e: ArithmeticException){
        println("$num can't be divided by 0")
   null
    }
    finally {
        println("Execution Done")
    }
}