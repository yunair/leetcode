package twopoint

/**
 * 寻找重复数
 *
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 */
object P287FindDuplicate {
    /**
     * 更好的做法：
     * 题目中说明：给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
     * 所以如果把它当成链表，一定有环，这就可以把value当索引
     */
    fun findDuplicate(nums: IntArray): Int {
        val end = nums.size - 1
        for (i in 0 until end) {
            for (j in i + 1..end) {
                if (nums[i] == nums[j]) {
                    return nums[i]
                }
            }
        }
        return 0
    }
}