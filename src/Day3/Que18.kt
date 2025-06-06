package Day3

    import kotlin.random.Random
    fun main() {
        val tipNumber = Random.nextInt(1, 5)
        val tip = when (tipNumber) {
            1 -> "Tip #1: Sip happens."
            2 -> "Tip #2: Stay grounded "
            3 -> "Tip #3: Brew-tiful day ahead!"
            4 -> "Tip #4: Bean there, done that"
            else -> "More coffee, less talk "
        }

        println("Random Coffee Tip:\n$tip")
    }

