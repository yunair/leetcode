package datastructure

import kotlin.test.assertEquals

/**
 * 和为K的子数组
 */
object P560SubArraySum {
    /**
     * 前right项和减去前left项和等于k，即前left项和等于前right项和减去k。
     * 可以这样做，在扫描数组的同时，假设当前扫到第i位，记录它的前i项和sum，用该和减去k，即sum-k，判断sum-k是否为某个位置的前n项和，
     * 若是，更新统计量。
     */
    fun subarraySum(nums: IntArray, k: Int): Int {
        var count = 0
        var sum = 0
        val map = mutableMapOf<Int/*和*/, Int/*个数*/>()
        // 和为key的个数
        map[0] = 1
        for (i in nums.indices) {
            sum += nums[i]
            if (map.containsKey(sum - k)) {
                count += map[sum - k]!!
            }
            map[sum] = map.getOrDefault(sum, 0) + 1
        }
        return count
    }

    fun subarraySumOn2(nums: IntArray, k: Int): Int {
        var count = 0
        for (i in nums.indices) {
            var target = k
            for (j in i until nums.size) {
                target -= nums[j]
                if (target == 0) {
                    count++
                }
            }
        }
        return count
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(2, subarraySum(intArrayOf(1, 1, 1), 2))
        assertEquals(1, subarraySum(intArrayOf(28, 54, 7, -70, 22, 65, -6), 100))
        assertEquals(55, subarraySum(intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 0))
    }
}