package twopoint

import kotlin.test.assertEquals

/**
 * 接雨水
 */
object P42TrappingRainWater {
    /**
     * i位置能接的雨水数量:
     * minOf(maxOf(height[0]..height[i-1]), maxOf(height[i+1]..height[n])) - height[i]
     */
    fun trap(heights: IntArray): Int {
        var sum = 0
        /*从i到height.size最大值*/
        val memo = mutableMapOf<Int, Int>()
        var leftMax = 0
        val size = heights.size
        var rightMax = 0
        for (i in size - 1 downTo 1) {
            rightMax = maxOf(rightMax, heights[i])
            memo[i] = rightMax
        }
        for (i in 1 until (size - 1)) {
            val cur = heights[i]
            leftMax = maxOf(leftMax, heights[i - 1])
            sum += maxOf(0, minOf(leftMax, memo[i + 1]!!) - cur)
        }
        return sum
    }

    fun trapDoublePoint(heights: IntArray): Int {
        var sum = 0
        var left = 0
        var right = heights.size - 1
        var leftMax = 0
        var rightMax = 0
        while (left < right) {
            if (heights[left] < heights[right]) {
                leftMax = maxOf(leftMax, heights[left])
                sum += leftMax - heights[left]
                left++
            } else {
                rightMax = maxOf(rightMax, heights[right])
                sum += rightMax - heights[right]
                right--
            }
        }

        return sum
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(6, trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
    }
}