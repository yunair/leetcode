package search

import kotlin.test.assertEquals

/**
 * 搜索插入位置
 */
object P35SearchInsertPosition {
    /**
     * 自己实现二分
     */
    fun searchInsert(nums: IntArray, target: Int): Int {
        return biSearch(nums, 0, nums.size - 1, target)
    }

    private fun biSearch(nums: IntArray, low: Int, high: Int, target: Int): Int {
        val mid = (high - low) / 2 + low
        if (low > high) {
            return low
        }
        return when {
            nums[mid] > target -> {
                biSearch(nums, low, mid - 1, target)
            }
            nums[mid] < target -> {
                biSearch(nums, mid + 1, high, target)
            }
            else -> {
                mid
            }
        }
    }

    private fun biSearchIter(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val mid = left + (right - left) shr 1
            when {
                nums[mid] == target -> {
                    return mid
                }
                nums[mid] > target -> {
                    left = mid + 1
                }
                else -> {
                    right = mid - 1
                }
            }
        }
        return 0
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(1, searchInsert(intArrayOf(1, 3, 5, 6), 2))
        assertEquals(4, searchInsert(intArrayOf(1, 3, 5, 6), 7))
        assertEquals(0, searchInsert(intArrayOf(1, 3, 5, 6), 0))
    }
}