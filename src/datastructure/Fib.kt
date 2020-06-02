package other

object Fib {
    fun fib(N: Int): Int {
        var current = 0
        var prev = 0
        var next = 1
        for (i in 2..N) {
            current = prev + next
            prev = next
            next = current
        }
        return current
    }
}