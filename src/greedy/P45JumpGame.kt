package greedy

import kotlin.test.assertEquals

/**
 * 跳跃游戏 II
 */
object P45JumpGame {
    fun jump(nums: IntArray): Int {
        var ans = 0
        var i = 0
        while (i < nums.size) {
            if (i == nums.size - 1) {
                return ans
            }
            val jump = nums[i]
            if (i + jump >= nums.size - 1) {
                return ans + 1
            }
            ans++

            var max = 0
            var nextJump = 0
            for (j in (i + 1)..(i + jump)) {
                if (nums[j] + j > max) {
                    max = nums[j] + j
                    nextJump = j
                }
            }
            i = nextJump
        }
        return ans
    }

    fun jump2(nums: IntArray): Int{
        // 用 end 表示当前能跳的边界
        var end = 0
        var steps = 0
        var maxPosition = 0
        for (i in 0 until nums.size - 1) {
            maxPosition = maxOf(nums[i] + i, maxPosition)
            if (i == end) {
                //遇到边界，就更新边界，并且步数加一
                end = maxPosition
                steps++
            }
        }
        return steps
    }
    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(2, jump(intArrayOf(2, 3, 1, 1, 4)))
    }
}