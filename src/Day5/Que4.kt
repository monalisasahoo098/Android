package Day5

// map function
fun main(){
    val num=listOf(1,5,6,8)
    val square=num.map{it*2}
    println(num)



// forEach function
val name=listOf("hina","rina","mina")
val names=name.forEach { println(it.capitalize()) }

}