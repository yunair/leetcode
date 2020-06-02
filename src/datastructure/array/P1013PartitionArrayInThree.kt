package other.array

import kotlin.test.assertEquals

/**
 * 将数组分成和相等的三个部分
 */
object P1013PartitionArrayInThree {
    fun canThreePartsEqualSum(arr: IntArray): Boolean {
        val sum = arr.sum()
        if (sum % 3 != 0) {
            return false
        }

        val subSum = sum / 3
        var count = 0
        var equalSumCount = 0
        for ((index, num) in arr.withIndex()) {
            count += num
            if (count == subSum) {
                equalSumCount++
                count = 0
            }
            if (equalSumCount == 2 && index < arr.size - 1) {
                return true
            }
        }
        return false
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(true, canThreePartsEqualSum(intArrayOf(0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1)))
        assertEquals(false, canThreePartsEqualSum(intArrayOf(0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1)))
        assertEquals(false, canThreePartsEqualSum(intArrayOf(-1, 1, 1, -1)))
        assertEquals(true, canThreePartsEqualSum(intArrayOf(3, 3, 6, 5, -2, 2, 5, 1, -9, 4)))
        assertEquals(true, canThreePartsEqualSum(intArrayOf(-10, 10, 10, -10, -10, 10, 10, -10)))
    }
}