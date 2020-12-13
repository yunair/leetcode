package greedy

import kotlin.test.assertEquals

/**
 * 加油站
 */
object P134GasStation {
    fun canCompleteCircuit(gas: IntArray, costs: IntArray): Int {
        val size = gas.size
        var startIndex = 0
        for (i in 0 until size) {
            val oil = gas[i]
            val cost = costs[i]
            if (cost - oil > 0) {
                continue
            }
            startIndex = i
            break
        }

        val initialStart = startIndex
        while (true) {

            var success = true
            var oil = 0
            for (i in 0 until size) {
                val index = (startIndex + i) % size
                if (oil + gas[index] - costs[index] < 0) {
                    success = false
                    startIndex = (startIndex + 1) % size
                    break
                }
                oil += gas[index] - costs[index]
            }
            if (success) {
                return startIndex
            }
            if (startIndex == initialStart) {
                return -1
            }
        }
    }

    /**
     * totalTank = sum(gas) - sum(cost) ，如果 totalTank < 0 则返回 -1 。
     *
     *
     * 我们引入变量 curTank ，记录当前油箱里剩余的总油量。如果在某一个加油站 curTank 0 小，意味着我们无法到达这个加油站。
     * 下一步我们把这个加油站当做新的起点，并将 curTank 重置为 0 ，因为重新出发，油箱中的油为 0 。
     * （从上一次重置的加油站到当前加油站的任意一个加油站出发，到达当前加油站之前， curTank 也一定会比 0 小）
     */
    fun canCompleteCircuitBetter(gas: IntArray, costs: IntArray): Int {
        val size = gas.size

        var totalTank = 0
        var curTank = 0
        var startIndex = 0
        for (i in 0 until size) {
            totalTank += gas[i] - costs[i]
            curTank += gas[i] - costs[i]
            // 不能抵达
            if (curTank < 0) {
                // 选择下一个站为起始
                startIndex = i + 1
                curTank = 0
            }
        }

        return if (totalTank >= 0) {
            startIndex
        } else {
            -1
        }

    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(3, canCompleteCircuit(intArrayOf(1, 2, 3, 4, 5), intArrayOf(3, 4, 5, 1, 2)))
        assertEquals(-1, canCompleteCircuit(intArrayOf(2, 3, 4), intArrayOf(3, 4, 3)))
        assertEquals(2, canCompleteCircuit(intArrayOf(2, 3, 4, 5, 6), intArrayOf(1, 5, 2, 2, 2)))
    }
}