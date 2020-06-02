package backtrack

import java.util.*
import kotlin.collections.ArrayList

/**
 * 组合总和2
 */
object P40CombinationSum2 {
    val ans = mutableListOf<List<Int>>()
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        ans.clear()
        Arrays.sort(candidates)
        backtrack(candidates, 0, target, mutableListOf())
        return ans
    }

    /**
     * 剪枝策略:
     */
    private fun backtrack(
        candidates: IntArray,
        start: Int,
        target: Int,
        tracker: MutableList<Int>
    ) {
        if (target == 0) {
            val list = ArrayList(tracker)

            ans.add(list)

            return
        }


        for (i in start until candidates.size) {
            val value = candidates[i]
            // 大剪枝
            if (target - value < 0) {
                break
            }
            // 小剪枝
            if (i > start && value == candidates[i - 1]) {
                continue;
            }

            tracker.add(value)

            backtrack(candidates, i + 1, target - value, tracker)

            tracker.remove(value)
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(combinationSum2(intArrayOf(10, 1, 2, 7, 6, 1, 5), 8))
        println(combinationSum2(intArrayOf(2, 5, 2, 1, 2), 5))
    }
}