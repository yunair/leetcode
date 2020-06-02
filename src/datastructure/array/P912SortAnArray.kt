package datastructure.array

/**
 * 排序数组
 */
object P912SortAnArray {
    fun sortArray(nums: IntArray): IntArray {
        sort(nums, 0, nums.size - 1)
        return nums
    }

    private fun sort(nums: IntArray, start: Int, end: Int) {
        if (start >= end) {
            return
        }
        val j = partation(nums, start, end)
        sort(nums, start, j - 1)
        sort(nums, j + 1, end)
    }

    private fun partation(nums: IntArray, start: Int, end: Int): Int {
        val base = nums[start]
        var i = start
        var j = end+1
        while (true) {
            while (j > i && nums[--j] > base);
            while (i < j && nums[++i] < base);
            if (i >= j) {
                break
            }
            exch(nums, i, j)
        }
        exch(nums, start, j)
        return j
    }

    private fun exch(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(sortArray(intArrayOf(5, 2, 3, 1)).contentToString())
        println(sortArray(intArrayOf(5, 1, 1, 2, 0, 0)).contentToString())
    }
}