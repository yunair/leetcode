package backtrack

import java.util.*
import kotlin.collections.ArrayList

/**
 * 子集2
 */
object P90Subsets2 {
    val ans = mutableListOf<List<Int>>()
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        Arrays.sort(nums)
        backtrack(nums, 0, ArrayDeque(), BooleanArray(nums.size))
        return ans
    }

    private fun backtrack(nums: IntArray, start: Int, tracker: Deque<Int>, visited: BooleanArray) {
        ans.add(ArrayList(tracker))

        for (i in start until nums.size) {
            if (visited[i]) {
                continue
            }

            if (i > start && nums[i] == nums[i - 1]) {
                continue
            }

            visited[i] = true
            tracker.add(nums[i])
            backtrack(nums, i + 1, tracker, visited)
            tracker.removeLast()
            visited[i] = false
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(subsetsWithDup(intArrayOf(1, 2, 2)))
        ans.clear()
        println(subsetsWithDup(intArrayOf(4, 4, 4, 1, 4)))
    }
}