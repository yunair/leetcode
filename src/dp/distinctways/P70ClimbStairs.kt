package dp.climbstairs

/**
 * 爬楼梯
 */
object P70ClimbStairs {
    /**
     * 正推
     * 提前算出f(1),f(2)..f(n),需要结果直接拿f(n)即可
     *  1个楼梯，只有一种方法
     *  2个楼梯，有2种方法
     *  3个楼梯，有f(1)+f(2)方法
     *
     * 原理:
     *  第 i 阶可以由以下两种方法得到：
     *      在第 (i-1) 阶后向上爬 1 阶。
     *      在第 (i-2) 阶后向上爬 2 阶。
     */
    fun climbStairs(n: Int): Int {
        val memo = IntArray(n + 1)
        memo[0] = 1
        memo[1] = 2
        for (i in 2 until n) {
            memo[i] = memo[i - 1] + memo[i - 2]
        }
        return memo[n - 1]
    }

    /**
     * 带备忘录的递归实现
     */
    fun climbStairsRecur(n: Int): Int {
        val memo = IntArray(n + 1)
        return dp(n, memo)
    }

    private fun dp(n: Int, memo: IntArray): Int {
        if (n < 0) {
            return 0
        }
        if (0 == n) {
            return 1
        }
        if (memo[n] > 0) {
            return memo[n]
        }
        memo[n] = dp(
            n - 1,
            memo
        ) + dp(n - 2, memo)
        return memo[n]
    }
}

fun main() {
    println(P70ClimbStairs.climbStairs(4))
}