package other.array

import kotlin.test.assertEquals

/**
 * 使数组唯一的最小增量
 */
object P945MinIncrementForUniqueArray {
    fun minIncrementForUnique(arr: IntArray): Int {
        if (arr.size <= 1) {
            return 0
        }

        arr.sort()
        var count = 0
        for (i in 1 until arr.size) {
            if (arr[i] <= arr[i - 1]) {
                val minus = arr[i - 1] - arr[i]
                arr[i] += minus + 1
                count += minus + 1
            }
        }
        return count
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(1, minIncrementForUnique(intArrayOf(1, 2, 2)))
        assertEquals(6, minIncrementForUnique(intArrayOf(3, 2, 1, 2, 1, 7)))
    }
}