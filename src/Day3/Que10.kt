package Day3

fun main(){
    val caffeineLevel=50
    val coffeeStrength=when (caffeineLevel){
     in 0..30->"Mild"
        in 30..60->"Medium"
        in 60..100->"Sttrong"
        else->"Caffeine level is not in between 0 to 100"
    }
    println("At caffeine level $caffeineLevel coffee strength is $coffeeStrength")
}