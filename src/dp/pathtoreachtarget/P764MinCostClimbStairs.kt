package dp.climbstairs

import kotlin.test.assertEquals

/**
 *  使用最小花费爬楼梯
 */
object P764MinCostClimbStairs {
    /**
     * f[i] = cost[i] + min(f[i+1], f[i+2])
     */
    fun minCostClimbingStairs(cost: IntArray): Int {
        var f1 = 0
        var f2 = 0
        for (i in (cost.size - 1) downTo 0) {
            val next = cost[i] + minOf(f1, f2)
            f2 = f1
            f1 = next
        }
        return minOf(f1, f2)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(15,
            minCostClimbingStairs(intArrayOf(10, 15, 20))
        )
        assertEquals(6,
            minCostClimbingStairs(
                intArrayOf(
                    1,
                    100,
                    1,
                    1,
                    1,
                    100,
                    1,
                    1,
                    100,
                    1
                )
            )
        )
    }
}