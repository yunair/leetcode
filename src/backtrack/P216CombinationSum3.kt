package backtrack

import kotlin.collections.ArrayList

/**
 * 组合总和3
 */
object P216CombinationSum3 {
    val ans = mutableListOf<List<Int>>()
    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        ans.clear()
        backtrack(1, k, n, mutableListOf())
        return ans
    }

    /**
     * 剪枝策略:
     */
    private fun backtrack(
        start: Int,
        maxLength: Int,
        target: Int,
        tracker: MutableList<Int>
    ) {
        if (tracker.size == maxLength) {
            if (target == 0) {
                val list = ArrayList(tracker)
                ans.add(list)
            }
            return
        }

        for (i in start..9) {
            // 大剪枝
            if (target - i < 0) {
                break
            }

            tracker.add(i)
            backtrack(i + 1, maxLength, target - i, tracker)
            tracker.remove(i)
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(combinationSum3(3, 7))
        println(combinationSum3(3, 9))
        println(combinationSum3(3, 2))
        println(combinationSum3(2, 18))
    }
}