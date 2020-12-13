package greedy

/**
 * 跳跃游戏
 */
object P55JumpGame {
    fun canJump(nums: IntArray): Boolean {
        var k = 0
        for (i in nums.indices) {
            if (i > k) {
                return false
            }
            k = maxOf(k, i + nums[i])
        }
        return true
    }
}