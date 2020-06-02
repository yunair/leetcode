package datastructure.array

import kotlin.test.assertEquals

/**
 * 寻找两个有序数组的中位数
 */
object P4MedianOfTwoSortArray {
    /**
     * 奇数个，中位数为中间数
     * 偶数个，中位数为中间两个数的均值
     *
     *
     * 为了简化代码，不分情况讨论，我们使用一个小trick，
     * 我们分别找第 (m+n+1) / 2 个，和 (m+n+2) / 2 个，然后求其平均值即可，这对奇偶数均适用。
     * 加入 m+n 为奇数的话，那么其实 (m+n+1) / 2 和 (m+n+2) / 2 的值相等
     */
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val m = nums1.size
        val n = nums2.size
        val len = m + n
        var n1Index = 0
        var n2Index = 0
        var left = 0
        var right = 0
        while (n1Index + n2Index <= len / 2) {
            // 等于的时候就是中位数
            left = right
            when {
                n1Index == m -> {
                    right = nums2[n2Index]
                    n2Index++
                }
                n2Index == n -> {
                    right = nums1[n1Index]
                    n1Index++
                }
                nums1[n1Index] < nums2[n2Index] -> {
                    right = nums1[n1Index]
                    n1Index++
                }
                else -> {
                    right = nums2[n2Index]
                    n2Index++
                }
            }
        }
        // 偶数，找两个
        if (len and 1 == 0) {
            return (left + right) / 2.0
        }

        return right.toDouble()
    }


    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(2.0, findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2)))
        assertEquals(0.0, findMedianSortedArrays(intArrayOf(0, 0), intArrayOf(0)))
        assertEquals(2.5, findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 4)))
        assertEquals(2.0, findMedianSortedArrays(intArrayOf(2), intArrayOf()))
        assertEquals(-1.0, findMedianSortedArrays(intArrayOf(3), intArrayOf(-2, -1)))
        assertEquals(1.5, findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(-1, 3)))
    }
}