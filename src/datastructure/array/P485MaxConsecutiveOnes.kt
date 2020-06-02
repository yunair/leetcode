package other.array

import kotlin.test.assertEquals

/**
 * 最大连续1的个数
 */
object P485MaxConsecutiveOnes {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var max = 0
        var cur = 0
        for (num in nums) {
            if (num == 1) {
                cur++
            } else {
                max = maxOf(cur, max)
                cur = 0
            }
        }
        max = maxOf(cur, max)
        return max
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(3, findMaxConsecutiveOnes(intArrayOf(1, 1, 0, 1, 1, 1)))
    }
}