package math

import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * 矩形重叠
 */
object P863RectangleOverlap {
    /**
     * 找两个矩形不重叠的情况，取反
     */
    fun isRectangleOverlap(rec1: IntArray, rec2: IntArray): Boolean {
        // rec2在rec1左边不重叠
        val left = rec2[2] <= rec1[0]
        // rec2在rec1右边不重叠
        val right = rec2[0] >= rec1[2]
        // rec2在rec1上边不重叠
        val top = rec2[1] >= rec1[3]
        // rec2在rec1下边不重叠
        val bottom = rec2[3] <= rec1[1]
        if (left || right || top || bottom) {
            return false
        }
        return true
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertTrue(isRectangleOverlap(intArrayOf(0,0,2,2), intArrayOf(1,1,3,3)))
        assertFalse(isRectangleOverlap(intArrayOf(0,0,1, 1), intArrayOf(1,0,2,1)))
    }
}