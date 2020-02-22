package other

import kotlin.test.assertEquals

/**
 * 只出现一次的数字II
 */
object P137SingleNumber2 {
    /**
     * 解决方案：
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

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(1, singleNumber(intArrayOf(2, 2, 1)))
        assertEquals(4, singleNumber(intArrayOf(4, 1, 2, 2, 1)))
    }
}