package backtrack

import kotlin.test.assertEquals

/**
 * 优美的排列
 */
object P526BeautifulArrange {
    private var count = 0
    fun countArrangement(N: Int): Int {
        count = 0
        backtrack(N, BooleanArray(N + 1), mutableListOf())
        return count
    }

    private fun backtrack(n: Int, visited: BooleanArray, tracker: MutableList<Int>) {
        if (tracker.size == n) {
            count++
            return
        }
        for (i in 1..n) {
            if (visited[i]) {
                continue
            }
            if (tracker.size > 0 && !checkBeautiful(tracker.size, i)) {
                continue
            }
            visited[i] = true
            tracker.add(i)
            backtrack(n, visited, tracker)
            tracker.remove(i)
            visited[i] = false
        }
    }

    private fun checkBeautiful(index: Int, value: Int): Boolean {
        return value % (index + 1) == 0 || (index + 1) % value == 0
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(2, countArrangement(2))
    }
}