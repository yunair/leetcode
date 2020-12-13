package interview

import kotlin.math.abs

/**
 * 数组中重复的数字
 */
object FindDuplicate {
    fun findRepeatNumber(nums: IntArray): Int {
        val arr = IntArray(nums.size)
        for (num in nums) {
            arr[num] += 1
            if (arr[num] == 2) {
                return arr[num]
            }
        }
        return 0
    }
}