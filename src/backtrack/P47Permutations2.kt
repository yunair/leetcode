package backtrack

import java.util.*
import kotlin.collections.ArrayList

/**
 * 全排列  II
 */
object P47Permutations2 {
    val ans = mutableListOf<List<Int>>()
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        ans.clear()
        nums.sort()
        backtrack(nums, ArrayDeque(), BooleanArray(nums.size))
        return ans
    }

    /**
     * 剪枝策略
     *  // 在 used[i - 1] 刚刚被撤销的时候剪枝，说明接下来会被选择，搜索一定会重复，故"剪枝"
     *   if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
     *   continue;
     *   }
     */
    private fun backtrack(nums: IntArray, tracker: ArrayDeque<Int>, visited: BooleanArray) {
        if (tracker.size == nums.size) {
            val list = ArrayList(tracker)
            ans.add(list)
            return
        }
        for (i in nums.indices) {
            if (visited[i]) {
                continue
            }
            // 二段剪枝，之前用过的数字不需要再次使用
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            val num = nums[i]

            visited[i] = true
            tracker.add(num)

            backtrack(nums, tracker, visited)

            visited[i] = false
            // 有重复值，所以不能用ArrayList remove()方法
            tracker.removeLast()
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
//        println(permuteUnique(intArrayOf(1, 1, 2)))
        println(permuteUnique(intArrayOf(2, 2, 1, 1)))
    }
}