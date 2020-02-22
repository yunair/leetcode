package dp

import kotlin.test.assertEquals

/**
 * 打家劫舍II
 */
object P213HouseRobber2 {
    /**
     * 因为房子是一个环
     * 所以有三种情况：
     * 1。 第一家和最后一家都不偷
     * 2。 偷第一家不偷最后一家
     * 3。 偷最后一家不偷第一家
     *
     * 因为偷一定比不偷最终结果大，所以第一种情况不用考虑，只要考虑下面两种情况即可
     *
     */
    fun rob(cost: IntArray): Int {
        if (cost.isEmpty()) {
            return 0
        }

        if (cost.size == 1) {
            return cost[0]
        }

        var prev1 = 0
        var current1 = 0
        // 选第一个，不选最后一个
        for (i in 2 until (cost.size - 1)) {
            val next = prev1 + cost[i]
            prev1 = current1
            current1 = maxOf(current1, next)
        }
        current1 += cost[0]

        var prev2 = 0
        var current2 = 0
        // 不选第一个
        for (i in 1 until cost.size) {
            val next = prev2 + cost[i]
            prev2 = current2
            current2 = maxOf(current2, next)
        }

        return maxOf(current1, current2)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(3, rob(intArrayOf(2, 3, 2)))
        assertEquals(4, rob(intArrayOf(1, 2, 3, 1)))
        assertEquals(0, rob(intArrayOf()))
        assertEquals(16, rob(intArrayOf(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)))
    }
}