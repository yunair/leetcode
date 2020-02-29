package bitoperator

import kotlin.test.assertEquals

/**
 * 只出现一次的数字II
 */
object P137SingleNumber2 {
    /**
     * 解决方案：
     *
     * a^b = a-b
     */
    fun singleNumber(nums: IntArray): Int {
        val map = mutableMapOf<Int, Int>()
        for (num in nums) {
            map[num] = map.getOrDefault(num, 0) + 1
        }

        for (entry in map) {
            if (entry.value == 1) {
                return entry.key
            }
        }

        return 0
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(1, singleNumber(intArrayOf(2, 2, 2, 1)))
        assertEquals(99, singleNumber(intArrayOf(0, 1, 0, 1, 0, 1, 99)))
    }
}