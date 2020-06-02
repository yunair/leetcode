package twopoint

/**
 * 移动零
 */
object P283MoveZeros {
    fun moveZeroes(nums: IntArray) {
        var notZero = 0
        for (i in nums.indices) {
            if (nums[i] != 0) {
                swap(nums, i, notZero)
                notZero++
            }
        }
    }

    private fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val arr = intArrayOf(0, 1, 0, 3, 12)
        moveZeroes(arr)
        println(arr.contentToString())
    }
}