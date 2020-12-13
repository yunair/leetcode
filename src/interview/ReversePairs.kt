package interview

import kotlin.test.assertEquals

/**
 * 数组中的逆序对
 */
object ReversePairs {
    fun reversePairs(nums: IntArray): Int {
        val size = nums.size
        if (size < 2) {
            return 0
        }
        return reversePairs(nums, 0, nums.size - 1, IntArray(nums.size))
    }

    private fun reversePairs(nums: IntArray, start: Int, end: Int, copy: IntArray): Int {
        if (start >= end) {
            return 0
        }
        val mid = start + (end - start) / 2
        val left = reversePairs(nums, start, mid, copy)
        val right = reversePairs(nums, mid + 1, end, copy)
        val count = merge(nums, start, mid, end, copy)
        return left + right + count
    }

    /**
     * nums[left,mid] 有序，nums[mid + 1..right] 有序
     */
    private fun merge(nums: IntArray, start: Int, mid: Int, end: Int, copy: IntArray): Int {
        var i = start
        var j = mid + 1
        for (k in nums.indices) {
            copy[k] = nums[k]
        }

        var count = 0

        for (k in start..end) {
            if (i > mid) {
                nums[k] = copy[j]
                j++
            } else if (j > end) {
                nums[k] = copy[i]
                i++
            } else {
                if (copy[i] <= copy[j]) {
                    nums[k] = copy[i++]
                } else {
                    count += mid - i + 1
                    nums[k] = copy[j++]
                }
            }
        }
        return count
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(5, reversePairs(intArrayOf(7, 5, 6, 4)))
    }
}