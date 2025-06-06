package Day3

fun main(){
    val coffeeNumber=16
    if(coffeeNumber%2==0){
        println(" order number $coffeeNumber is even ")
        println("Even-numbered orders get an extra sprinkle of espresso magic")
    }else{
        println("order number $coffeeNumber is odd")
        println("You got an odd number,that means your coffee comes with a mystery!")
    }
}