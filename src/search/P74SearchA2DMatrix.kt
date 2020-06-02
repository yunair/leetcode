package search

import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * 搜索二维矩阵
 */
object P74SearchA2DMatrix {
    /**
     * 整体可以拍平为一维数组进行二分查找
     */
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isEmpty() || matrix[0].isEmpty()) {
            return false
        }

        var begin = 0
        val lineSize = matrix.size
        val rowSize = matrix[0].size
        var end = lineSize * rowSize - 1
        while (begin <= end) {
            val mid = (begin + end) / 2
            val value = matrix[mid / rowSize][mid % rowSize]
            when {
                value == target -> {
                    return true
                }
                value < target -> {
                    begin = mid + 1
                }
                else -> {
                    end = mid - 1
                }
            }
        }
        return false
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val matrix = Array(3) {
            IntArray(4)
        }.apply {
            this[0] = intArrayOf(1, 3, 5, 7)
            this[1] = intArrayOf(10, 11, 16, 20)
            this[2] = intArrayOf(23, 30, 34, 50)
        }
        assertTrue(searchMatrix(matrix, 3))

        val matrix1 = Array(3) {
            IntArray(4)
        }.apply {
            this[0] = intArrayOf(1, 3, 5, 7)
            this[1] = intArrayOf(10, 11, 16, 20)
            this[2] = intArrayOf(23, 30, 34, 50)
        }
        assertFalse(searchMatrix(matrix, 13))
    }
}