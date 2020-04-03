package other.array

import kotlin.test.assertEquals

/**
 * 多数元素
 */
object P169MajorityElement {
    fun majorityElement(nums: IntArray): Int {
        val map = mutableMapOf<Int, Int>()
        for (num in nums) {
            map[num] = map.getOrDefault(num, 0) + 1
            if (map[num]!! > nums.size / 2) {
                return num
            }
        }
        return 0
    }

    /**
     * 投票算法
     * 把众数记为 +1+1，把其他数记为 -1−1，将它们全部加起来，显然和大于 0。
     * 候选人(cand_num)初始化为nums[0]，票数count初始化为1。
     * 当遇到与cand_num相同的数，则票数count = count + 1，否则票数count = count - 1。
     * 当票数count为0时，更换候选人，并将票数count重置为1。
     * 遍历完数组后，cand_num即为最终答案。
     */
    fun majorityElementBoyerMoore(nums: IntArray): Int {
        var candidate = nums[0]
        var count = -1
        for (num in nums) {
            if (num == candidate) {
                count++
            } else {
                count--
            }
            if (count == 0) {
                candidate = num
            }
        }
        return candidate
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(3, majorityElementBoyerMoore(intArrayOf(3, 2, 3)))
        assertEquals(2, majorityElementBoyerMoore(intArrayOf(2, 2, 1, 1, 1, 2, 2)))
    }
}