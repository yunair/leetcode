package search

import kotlin.test.assertEquals

/**
 * 搜索旋转排序数组
 */
object P153FindMinInRotatedSortedArray {
    fun findMin(nums: IntArray): Int {
        // 找到变化点，即为最小值
        if (nums.size == 1) {
            return nums[0]
        }
        var left = 0
        var right = nums.size - 1
        if (nums[right] > nums[0]) {
            // 未变动的已排序数组
            return nums[0]
        }
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1]
            }
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid]
            }
            // 非单调递增，一定是先增后从0开始增
            if (nums[mid] > nums[0]) {
                // 变化点在右侧
                left = mid + 1
            } else {
                right = mid
            }
        }
        return -1

    }


    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(1, findMin(intArrayOf(3, 4, 5, 1, 2)))
        assertEquals(1, findMin(intArrayOf(2, 1)))
        assertEquals(0, findMin(intArrayOf(4, 5, 6, 7, 0, 1, 2)))
        assertEquals(1, findMin(intArrayOf(3, 1, 2)))
        assertEquals(1, findMin(intArrayOf(2, 3, 4, 5, 1)))

    }
}