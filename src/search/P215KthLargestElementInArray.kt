package search

import kotlin.test.assertEquals

/**
 * 数组中的第K个最大元素
 */
object P215KthLargestElementInArray {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        quickSelect(nums, 0, nums.size - 1, k-1)
        return nums[k - 1]
    }

    private fun quickSelect(nums: IntArray, start: Int, end: Int, k: Int) {
        if (start >= end) {
            return
        }
        val j = partition(nums, start, end)
        if (k < j) {
            quickSelect(nums, start, j - 1, k)
        }
        if (k > j) {
            quickSelect(nums, j + 1, end, k)
        }
    }

    private fun partition(nums: IntArray, low: Int, high: Int): Int {
        val base = nums[low]
        var i = low
        var j = high + 1
        while (true) {
            while (++i < high && nums[i] > base);
            while (--j > low && nums[j] < base);
            if (i >= j) {
                break
            }
            exch(nums, i, j)
        }
        exch(nums, low, j)
        return j
    }

    private fun exch(nums: IntArray, left: Int, right: Int) {
        val temp = nums[left]
        nums[left] = nums[right]
        nums[right] = temp
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(5, findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2))
        assertEquals(4, findKthLargest(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4))
        assertEquals(1, findKthLargest(intArrayOf(2, 1), 2))
    }
}