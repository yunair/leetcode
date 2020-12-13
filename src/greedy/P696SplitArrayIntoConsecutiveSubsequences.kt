package greedy

import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * 分割数组为连续子序列
 */
object P696SplitArrayIntoConsecutiveSubsequences {
    fun isPossible(nums: IntArray): Boolean {
        // 存储元素出现的次数，key 为元素，value 为其出现次数
        val countMap = mutableMapOf<Int, Int>()
        for (num in nums) {
            countMap[num] = countMap.getOrDefault(num, 0) + 1
        }

        // tailMap 存储已有连续子序列的右边界的出现次数
        // key 为右边界，value 为其出现次数
        // 例如有一连续子序列为（1,2,3），则该子序列右边界为 4
        val tailMap = mutableMapOf<Int, Int>()
        for (num in nums) {
            if (countMap[num] == 0) {
                continue
            } else if (tailMap.getOrDefault(num, 0) > 0) {
                // 将 x 添加到已有子序列（右边界为 x）的末尾
                // 添加后右边界为 x 的子序列数减一，右边界为 x+1 的子序列数加一
                countMap[num] = countMap[num]!! - 1
                tailMap[num] = tailMap[num]!! - 1
                tailMap[num + 1] = tailMap.getOrDefault(num + 1, 0) + 1
            } else if (countMap.getOrDefault(num + 1, 0) > 0
                && countMap.getOrDefault(num + 2, 0) > 0
            ) {
                // 以 x 开头，加上 x+1 和 x+2，建立一个新的连续子序列
                countMap[num] = countMap[num]!! - 1
                countMap[num + 1] = countMap[num + 1]!! - 1
                countMap[num + 2] = countMap[num + 2]!! - 1
                tailMap[num + 3] = tailMap.getOrDefault(num + 3, 0) + 1
            } else {
                return false
            }
        }

        return true
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertTrue(isPossible(intArrayOf(1, 2, 3, 3, 4, 5)))
        assertTrue(isPossible(intArrayOf(1, 2, 3, 3, 4, 4, 5, 5)))
        assertFalse(isPossible(intArrayOf(1, 2, 3, 4, 4, 5)))
        assertTrue(isPossible(intArrayOf(1, 2, 3, 4, 6, 7, 8, 9, 10, 11)))
    }
}