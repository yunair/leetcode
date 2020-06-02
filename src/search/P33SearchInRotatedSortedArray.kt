package search

import kotlin.test.assertEquals

/**
 * 搜索旋转排序数组
 */
object P33SearchInRotatedSortedArray {
    fun search(nums: IntArray, target: Int): Int {
        return search(nums, target, 0, nums.size - 1)
    }

    private fun search(nums: IntArray, target: Int, low: Int, high: Int): Int {
        if (low > high) {
            return -1
        }
        val mid = low + (high - low) / 2
        if (nums[low] == target) {
            return low
        }
        if (nums[high] == target) {
            return high
        }
        if (nums[mid] == target) {
            return mid
        }

        return if (nums[low] < nums[mid]) {
            // 左半边有序
            if (nums[low] < target && nums[mid] > target) {
                search(nums, target, low + 1, mid - 1)
            } else {
                search(nums, target, mid + 1, high - 1)
            }
        } else {
            // 右半边有序
            if (nums[mid] < target && nums[high] > target) {
                search(nums, target, mid + 1, high - 1)
            } else {
                search(nums, target, low + 1, mid - 1)
            }
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(4, search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0))
        assertEquals(-1, search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 3))
        assertEquals(3, search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 7))
        assertEquals(1, search(intArrayOf(5, 1, 2, 3, 4), 1))
    }
}