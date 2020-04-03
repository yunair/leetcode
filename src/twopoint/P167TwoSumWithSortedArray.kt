package twopoint

/**
 * 两数之和 II - 输入有序数组
 */
object P167TwoSumWithSortedArray {
    /**
     * 有序数组，所以使用双指针实现
     */
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        val ans = IntArray(2)
        var left = 0
        var right = numbers.size - 1
        while (left < right) {
            val sum = numbers[left] + numbers[right]
            when {
                sum > target -> {
                    right--
                }
                sum < target -> {
                    left++
                }
                else -> {
                    ans[0] = left+1
                    ans[1] = right+1
                    return ans
                }
            }
        }
        return ans
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(twoSum(intArrayOf(2, 7, 11, 15), 9).contentToString())
    }
}