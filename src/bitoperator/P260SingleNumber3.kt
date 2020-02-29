package bitoperator

/**
 * 只出现一次的数字
 */
object P260SingleNumber3 {
    /**
     * 解决方案：
     * 异或 空间复杂度，O(1)
     *
     * a^a^b = b
     */
    fun singleNumber(nums: IntArray): IntArray {
        val set = mutableSetOf<Int>()
        for (num in nums) {
            if (set.contains(num)) {
                set.remove(num)
            } else {
                set.add(num)
            }
        }
        return set.toIntArray()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(singleNumber(intArrayOf(1, 2, 1, 3, 2, 5)).contentToString())
    }
}