package dp

import kotlin.test.assertEquals

/**
 * 不同路径
 */
object P63UniquePaths3 {
    /**
     * 考虑网格中有障碍物
     * f[i,j] = f[i-1,j] + f[i, j-1]
     *
     * 先把第一行和第一列填好，然后可以按没障碍物的方式计算
     */
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        if (obstacleGrid.isEmpty()) {
            return 0
        }
        if (obstacleGrid[0][0] == 1) {
            return 0
        }

        for (grid in obstacleGrid) {
            for (i in grid.indices) {
                if (grid[i] == 1) {
                    grid[i] = -1
                }
            }
        }

        obstacleGrid[0][0] = 1

        for (i in obstacleGrid.indices) {
            for (j in obstacleGrid[0].indices) {
                // [0][0]处理过了， 这里不能处理
                if (i == 0 && j == 0) {
                    continue
                }
                if (obstacleGrid[i][j] == -1) {
                    continue
                }
                val top = if (i - 1 < 0) {
                    0
                } else {
                    // 也可能为-1，这个时候认为是0
                    maxOf(obstacleGrid[i - 1][j], 0)
                }

                val left = if (j - 1 < 0) {
                    0
                } else {
                    // 也可能为-1，这个时候认为是0
                    maxOf(obstacleGrid[i][j - 1], 0)
                }
                obstacleGrid[i][j] = top + left
            }
        }
        // 终点有障碍物
        return maxOf(obstacleGrid[obstacleGrid.size - 1][obstacleGrid[0].size - 1], 0)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val arr1 = Array(3) {
            IntArray(3)
        }.apply {
            this[0] = intArrayOf(0, 0, 0)
            this[1] = intArrayOf(0, 1, 0)
            this[2] = intArrayOf(0, 0, 0)
        }
        assertEquals(2, uniquePathsWithObstacles(arr1))
        val arr2 = Array(1) {
            IntArray(2)
        }.apply {
            this[0] = intArrayOf(1, 0)
        }
        assertEquals(0, uniquePathsWithObstacles(arr2))

        val arr3 = Array(3) {
            IntArray(2)
        }.apply {
            this[0] = intArrayOf(0, 0)
            this[1] = intArrayOf(1, 1)
            this[2] = intArrayOf(0, 0)
        }
        assertEquals(0, uniquePathsWithObstacles(arr3))
    }
}