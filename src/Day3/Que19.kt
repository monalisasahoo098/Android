package Day3

fun main() {
    var orderCount = 1
    while (true) {
        println("Processing order #$orderCount ")
        if (orderCount == 5) {
            println("Rush hour!")
            break
        }
        orderCount++
    }
}
