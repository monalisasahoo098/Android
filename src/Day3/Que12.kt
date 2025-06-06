package Day3

fun main(){
    var price=200
    var msg=when(price){
        in 0..50->"A solid pick-me-up without hurting your wallet. Good choice!"
        in 50..150->"You’ve got taste — not too fancy, not too plain. Just right!"
        in 150.. Int.MAX_VALUE->"Ooh, going premium today? Someone's treating themselves!"
        else->"Coffee at this  price is not available"
    }
    println("price= $price,$msg")
}