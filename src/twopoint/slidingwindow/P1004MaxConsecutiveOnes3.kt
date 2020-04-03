package twopoint.slidingwindow

import kotlin.test.assertEquals

/**
 * 最大连续1的个数III
 */
object P1004MaxConsecutiveOnes3 {
    fun longestOnes(nums: IntArray, k: Int): Int {
        var left = 0
        var right = 0
        var countZero = 0
        var max = 0
        while (right < nums.size) {
            if (nums[right] == 0) {
                countZero++
            }
            while (countZero > k) {
                // 滑动窗口之外
                if (nums[left] == 0) {
                    countZero--
                }
                left++
            }
            max = maxOf(max, right - left + 1)
            right++
        }
        return max
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(6, longestOnes(intArrayOf(1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0), 2))
        assertEquals(10, longestOnes(intArrayOf(0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1), 3))
        assertEquals(3, longestOnes(intArrayOf(0, 0, 1, 1, 1, 0, 0), 0))
        assertEquals(4, longestOnes(intArrayOf(0, 0, 0, 1), 4))
        assertEquals(4, longestOnes(intArrayOf(1, 1, 1, 0, 0, 0, 1, 1, 1, 1), 0))
    }
}