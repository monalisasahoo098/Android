package Day3

fun main() {
    for (orderNumber in 1..10) {
        if (orderNumber % 2 == 0) {
            continue
        }
        println("Serving order $orderNumber (Regular)")
    }
}
