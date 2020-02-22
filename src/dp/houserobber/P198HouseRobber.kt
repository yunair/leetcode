package dp

import kotlin.test.assertEquals

/**
 * 打家劫舍
 */
object P198HouseRobber {
    /**
     * f(k) = 从前 k 个房屋中能抢劫到的最大数额，Ai = 第 i 个房屋的钱数。
     *
     * 首先看 n = 1 的情况，显然 f(1) = A1。
     * 再看 n = 2，f(2) = max(A1, A2)。
     * 对于 n = 3，有两个选项:
     *  抢第三个房子，将数额与第一个房子相加。
     *  不抢第三个房子，保持现有最大数额。
     *
     * 显然，你想选择数额更大的选项。于是，可以总结出公式：
     *
     * f(k) = max(f(k – 2) + Ak, f(k – 1))
     *
     * f(0) = 0 f(-1) = 0
     * 可以极大的简化代码
     *
     */
    fun rob(cost: IntArray): Int {
        var prev = 0
        var current = 0
        for (i in cost.indices) {
            val next = cost[i] + prev
            prev = current
            current = maxOf(next, current)
        }
        return current
    }

    private var max = 0
    fun robOverTime(cost: IntArray): Int {
        max = 0
        dp(cost, 0, 0)
        return max
    }

    private fun dp(cost: IntArray, sum: Int, index: Int) {
        if (index >= cost.size) {
            return
        }

        for (i in index until cost.size) {
            val curSum = sum + cost[i]
            if (curSum > max) {
                max = curSum
            }
            if (i + 2 < cost.size) {
                dp(cost, curSum, i + 2)
            }
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(5, rob(intArrayOf(1, 4, 3, 1)))
        assertEquals(12, rob(intArrayOf(2, 7, 9, 3, 1)))
    }
}