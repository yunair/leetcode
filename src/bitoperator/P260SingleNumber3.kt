package bitoperator

import kotlin.test.assertEquals

/**
 * 只出现一次的数字
 */
object P136SingleNumber {
    /**
     * 解决方案：
     * 异或 空间复杂度，O(1)
     *
     * a^a^b = b
     */
    fun singleNumber(nums: IntArray): Int {
        val set = mutableSetOf<Int>()
        var ans = 0
        for (num in nums) {
            if (set.contains(num)) {
                ans -= num
            } else {
                set.add(num)
                ans += num
            }
        }
        return ans
    }

    fun singleNumberSpaceO1(nums: IntArray): Int {
        var ans = 1
        for (num in nums) {
            ans = ans xor num
        }
        return ans
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(1, singleNumber(intArrayOf(2, 2, 1)))
        assertEquals(4, singleNumber(intArrayOf(4, 1, 2, 2, 1)))
    }
}