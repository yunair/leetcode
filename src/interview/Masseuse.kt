package interview

import kotlin.test.assertEquals

/**
 * 按摩师
 */
object Masseuse {
    /**
     * dp[i]今天能收到最多的钱
     */
    fun massage(nums: IntArray): Int {
        val dp = IntArray(nums.size + 2)
        for (i in nums.indices) {
            dp[i + 2] = maxOf(dp[i + 1], dp[i] + nums[i])
        }
        return dp[nums.size + 1]
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(4, massage(intArrayOf(1, 2, 3, 1)))
        assertEquals(12, massage(intArrayOf(2, 7, 9, 3, 1)))
        assertEquals(12, massage(intArrayOf(2, 1, 4, 5, 3, 1, 1, 3)))
    }
}