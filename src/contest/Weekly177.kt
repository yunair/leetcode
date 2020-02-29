package contest

import java.util.*
import kotlin.test.assertEquals

object Weekly176 {
    /**
     * Title: 统计有序矩阵中的负数
     *
     * desc: 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。
     * 请你统计并返回 grid 中 负数 的数目
     */
    fun countNegatives(grid: Array<IntArray>): Int {
        var count = 0
        val m = grid.size
        for (i in 0 until m) {
            val n = grid[i].size
            for (j in 0 until n) {
                if (grid[i][j] < 0) {
                    count += n - j
                    break
                }
            }
        }
        return count
    }

    /**
     * Title: 最多可以参加的会议数目
     *
     * Desc: 给你一个数组 events，其中 events[i] = [startDay[i], endDay[i]] ，表示会议 i 开始于 startDay[i] ，结束于 endDay[i] 。
     * 你可以在满足 startDay[i] <= d <= endDay[i] 中的任意一天 d 参加会议 i 。注意，一天只能参加一个会议。
     * 请你返回你可以参加的 最大 会议数目。
     */
    fun maxEvents(events: Array<IntArray>): Int {
        if (events.size == 1) {
            return 1
        }
        Arrays.sort(events) { o1, o2 ->
            if (o1[1] == o2[1]) {
                o1[0].compareTo(o2[0])
            } else {
                o1[1].compareTo(o2[1])
            }
        }

        TODO("没做出来")
    }

    @JvmStatic
    fun main(args: Array<String>) {
        /*val arr1 = Array(2) {
            IntArray(2)
        }.apply {
            this[0] = intArrayOf(3, 2)
            this[1] = intArrayOf(1, 0)
        }
        assertEquals(0, countNegatives(arr1))

        val arr2 = Array(1) {
            IntArray(1)
        }.apply {
            this[0] = intArrayOf(-1)
        }
        assertEquals(1, countNegatives(arr2))*/

        /* val productOfNumbers = ProductOfNumbers()
         productOfNumbers.add(3);        // [3]
         productOfNumbers.add(0);        // [3,0]
         productOfNumbers.add(2);        // [3,0,2]
         productOfNumbers.add(5);        // [3,0,2,5]
         productOfNumbers.add(4);        // [3,0,2,5,4]
         assertEquals(20, productOfNumbers.getProduct(2)); // 返回 20 。最后 2 个数字的乘积是 5 * 4 = 20
         assertEquals(40, productOfNumbers.getProduct(3)); // 返回 40 。最后 3 个数字的乘积是 2 * 5 * 4 = 40
         assertEquals(0, productOfNumbers.getProduct(4)); // 返回  0 。最后 4 个数字的乘积是 0 * 2 * 5 * 4 = 0
         productOfNumbers.add(8);        // [3,0,2,5,4,8]
         assertEquals(32, productOfNumbers.getProduct(2)); // 返回 32 。最后 2 个数字的乘积是 4 * 8 = 32*/

        val arr1 = Array(3) {
            IntArray(2)
        }.apply {
            this[0] = intArrayOf(1, 2)
            this[1] = intArrayOf(2, 3)
            this[2] = intArrayOf(3, 4)
        }
        assertEquals(3, maxEvents(arr1))

        val arr2 = Array(1) {
            IntArray(2)
        }.apply {
            this[0] = intArrayOf(1, 100000)
        }
        assertEquals(1, maxEvents(arr2))

        val arr3 = Array(5) {
            IntArray(2)
        }.apply {
            this[0] = intArrayOf(1, 4)
            this[1] = intArrayOf(4, 4)
            this[2] = intArrayOf(2, 2)
            this[3] = intArrayOf(3, 4)
            this[4] = intArrayOf(1, 1)
        }
        assertEquals(4, maxEvents(arr3))

        val arr4 = Array(5) {
            IntArray(2)
        }.apply {
            this[0] = intArrayOf(1, 2)
            this[1] = intArrayOf(1, 2)
            this[2] = intArrayOf(3, 3)
            this[3] = intArrayOf(1, 5)
            this[4] = intArrayOf(1, 5)
        }
        assertEquals(5, maxEvents(arr4))
    }
}

class ProductOfNumbers() {
    private val list = arrayListOf<Int>()
    fun add(num: Int) {
        list.add(num)
    }

    fun getProduct(k: Int): Int {
        var ans = 1
        for (i in 1..k) {
            ans *= list[list.size - i]
        }
        return ans
    }

}