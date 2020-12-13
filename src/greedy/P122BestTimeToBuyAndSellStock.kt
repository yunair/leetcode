package greedy

import kotlin.math.max
import kotlin.test.assertEquals

/**
 * 买卖股票的最佳时机 II
 */
object P122BestTimeToBuyAndSellStock {
    /**
     * 遍历整个股票交易日价格列表 price，策略是:
     * 所有上涨交易日都买卖（赚到所有利润），所有下降交易日都不买卖（永不亏钱）。
     */
    fun maxProfit(prices: IntArray): Int {
        var ans = 0
        if (prices.isEmpty()) {
            return 0
        }
        for (i in 1 until prices.size) {
            if (prices[i] > prices[i - 1]) {
                ans += prices[i] - prices[i - 1]
            }
        }
        return ans
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(7, maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
        assertEquals(4, maxProfit(intArrayOf(1, 2, 3, 4, 5)))
        assertEquals(0, maxProfit(intArrayOf(7, 6, 4, 3, 1)))
    }
}