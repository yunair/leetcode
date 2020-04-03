package twopoint

import kotlin.test.assertEquals

/**
 * 盛最多水的容器
 */
object P11ContainerWithMostWater {
    fun maxArea(heights: IntArray): Int {
        var left = 0
        var right = heights.size - 1
        var max = 0
        while (left < right) {
            val origin = minOf(heights[left], heights[right]) * (right - left)
            max = maxOf(max, origin)
            if (heights[left] < heights[right]) {
                left++
            } else {
                right--
            }
        }
        return max
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(49, maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
        assertEquals(4, maxArea(intArrayOf(1, 2, 4, 3)))
        assertEquals(17, maxArea(intArrayOf(2, 3, 4, 5, 18, 17, 6)))
        assertEquals(24, maxArea(intArrayOf(1, 3, 2, 5, 25, 24, 5)))
    }
}