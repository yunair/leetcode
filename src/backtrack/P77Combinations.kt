package backtrack

/**
 * 组合
 */
object P77Combinations {
    val ans = mutableListOf<List<Int>>()
    fun combine(n: Int, k: Int): List<List<Int>> {
        backtrack(n, k, 0, mutableListOf())
        return ans
    }

    private fun backtrack(n: Int, k: Int, start: Int, tracker: MutableList<Int>) {
        if (tracker.size == k) {
            ans.add(ArrayList(tracker))
            return
        }

        for (i in 1..n) {
            if (tracker.contains(i)) {
                continue
            }
            if (i <= start) {
                continue
            }

            tracker.add(i)

            backtrack(n, k, i, tracker)

            tracker.remove(i)
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(combine(4, 2))
    }
}