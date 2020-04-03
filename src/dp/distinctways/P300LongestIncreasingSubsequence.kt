package dp

import kotlin.test.assertEquals

/**
 * 最长上升子序列
 */
object P300LongestIncreasingSubsequence {
    /**
     * dp[i] 以nums[i]结尾的LIS的长度
     *
     */
    fun lengthOfLIS(nums: IntArray): Int {
        var count = 0
        val dp = IntArray(nums.size + 1) {
            1
        }
        for (i in nums.indices) {
            for (j in 0..i) {
                dp[i] = if (nums[i] > nums[j]) {
                    maxOf(dp[i], dp[j] + 1)
                } else {
                    dp[i]
                }
            }
            count = maxOf(dp[i], count)
        }
        return count
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(4, lengthOfLIS(intArrayOf(10, 9, 2, 5, 3, 7, 101, 18)))
    }
}