package backtrack

import java.util.*
import kotlin.collections.ArrayList

/**
 * 组合总和
 */
object P39CombinationSum {
    val ans = mutableListOf<List<Int>>()
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        // 排序的原因是在回溯的时候比较容易剪枝
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, mutableListOf())
        return ans
    }

    /**
     * 剪枝策略: “更深层的边上的数值不能比它上层的边上的数值小”
     */
    private fun backtrack(candidates: IntArray, startIndex: Int, target: Int, tracker: MutableList<Int>) {
        if (target == 0) {
            ans.add(ArrayList(tracker))
            return
        }

        for (i in startIndex until candidates.size) {
            val value = candidates[i]
            if (target < value) break

            tracker.add(value)

            backtrack(candidates, i, target - value, tracker)

            tracker.remove(value)
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(combinationSum(intArrayOf(2, 3, 5), 8))
        println(combinationSum(intArrayOf(2, 3, 6, 7), 7))

        println(combinationSum(intArrayOf(3, 5, 7), 10))
    }
}