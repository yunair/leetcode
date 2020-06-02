package twopoint

import kotlin.test.assertEquals

/**
 * 统计「优美子数组」
 */
object P1248CountNumberOfNiceSubArrays {
    fun numberOfSubarrays(nums: IntArray, k: Int): Int {
        for (i in nums.indices) {
            nums[i] = if (nums[i] and 1 == 1) {
                1
            } else {
                0
            }
        }
        if (nums.sum() == 0) {
            return 0
        }

        var slow = 0
        var slowStart = 0
        var presum = 0
        var count = 0
        for (num in nums) {
            presum += num

            while (presum == k) {
                presum -= nums[slow]
                slow++
                count++
            }
        }
        return count
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(2, numberOfSubarrays(intArrayOf(1, 1, 2, 1, 1), 3))
        assertEquals(0, numberOfSubarrays(intArrayOf(2, 4, 6), 1))
        assertEquals(16, numberOfSubarrays(intArrayOf(2, 2, 2, 1, 2, 2, 1, 2, 2, 2), 2))
    }
}