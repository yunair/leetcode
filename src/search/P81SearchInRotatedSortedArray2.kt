package search

import kotlin.test.assertEquals

/**
 * 搜索旋转排序数组II
 */
object P81SearchInRotatedSortedArray2 {
    fun search(nums: IntArray, target: Int): Boolean {
        return nums.contains(target)
    }
    @JvmStatic
    fun main(args: Array<String>) {
//        assertEquals(true, search(intArrayOf(2, 5, 6, 0, 0, 1, 2), 0))
//        assertEquals(false, search(intArrayOf(2, 5, 6, 0, 0, 1, 2), 3))
//        assertEquals(true, search(intArrayOf(1, 3, 1, 1, 1), 3))
        assertEquals(true, search(intArrayOf(1, 1, 3, 1), 3))
    }
}