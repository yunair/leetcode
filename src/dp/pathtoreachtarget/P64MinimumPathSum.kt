package dp

import kotlin.test.assertEquals

/**
 *
 */
object P64MinimumPathSum {
    fun minPathSum(grid: Array<IntArray>): Int {
        if (grid.isEmpty()) {
            return 0
        }

        val m = grid.size
        val n = grid[0].size
        for (i in 1 until m) {
            grid[i][0] += grid[i - 1][0]
        }

        for (i in 1 until n) {
            grid[0][i] += grid[0][i - 1]
        }

        for (i in 1 until m) {
            for (j in 1 until n) {
                grid[i][j] += minOf(grid[i - 1][j], grid[i][j - 1])
            }
        }

        return grid[m - 1][n - 1]
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val arr1 = Array(3) {
            IntArray(3)
        }.apply {
            this[0] = intArrayOf(1, 3, 1)
            this[1] = intArrayOf(1, 5, 1)
            this[2] = intArrayOf(4, 2, 1)
        }
        assertEquals(7, minPathSum(arr1))

        val arr2 = Array(2) {
            IntArray(3)
        }.apply {
            this[0] = intArrayOf(1, 2, 5)
            this[1] = intArrayOf(3, 2, 1)
        }
        assertEquals(6, minPathSum(arr2))
    }
}