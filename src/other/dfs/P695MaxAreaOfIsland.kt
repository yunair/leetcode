package backtrack

import kotlin.math.max
import kotlin.test.assertEquals

/**
 * 岛屿的最大面积
 */
object P695MaxAreaOfIsland {
    private val dirs = Array(4) {
        IntArray(2)
    }.apply {
        this[0] = intArrayOf(1, 0)
        this[1] = intArrayOf(-1, 0)
        this[2] = intArrayOf(0, 1)
        this[3] = intArrayOf(0, -1)
    }

    private var count = 0

    /**
     * 访问过的置0，可以简化代码
     */
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        if (grid.isEmpty()) {
            return 0
        }
        count = 0
        val visited = Array(grid.size) {
            BooleanArray(grid[0].size)
        }
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == 0) {
                    continue
                }
                visited[i][j] = true
                val list = arrayListOf(1)
                dfs(grid, i, j, visited, list)
                visited[i][j] = false
            }
        }
        return count
    }

    private fun dfs(grid: Array<IntArray>, row: Int, col: Int, visited: Array<BooleanArray>, cur: ArrayList<Int>) {
        if (grid[row][col] == 0) {
            return
        }

        for (dir in dirs) {
            val aimRow = row + dir[0]
            val aimCol = col + dir[1]
            if (aimRow < 0 || aimRow >= grid.size || aimCol < 0 || aimCol >= grid[0].size) {
                continue
            }
            if (!visited[aimRow][aimCol] && grid[aimRow][aimCol] == 1) {
                visited[aimRow][aimCol] = true
                cur.add(1)
                dfs(grid, aimRow, aimCol, visited, cur)
            }
        }
        count = maxOf(cur.size, count)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val arr1 = Array(1) {
            IntArray(8)
        }.apply {
            this[0] = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0)
        }

        assertEquals(0, maxAreaOfIsland(arr1))

        val arr2 = Array(8) {
            IntArray(13)
        }.apply {
            this[0] = intArrayOf(0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0)
            this[1] = intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0)
            this[2] = intArrayOf(0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0)
            this[3] = intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0)
            this[4] = intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0)
            this[5] = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0)
            this[6] = intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0)
            this[7] = intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0)
        }
        assertEquals(6, maxAreaOfIsland(arr2))

        val arr3 = Array(4) {
            IntArray(5)
        }.apply {
            this[0] = intArrayOf(1, 1, 0, 0, 0)
            this[1] = intArrayOf(1, 1, 0, 0, 0)
            this[2] = intArrayOf(0, 0, 0, 1, 1)
            this[3] = intArrayOf(0, 0, 0, 1, 1)
        }

        assertEquals(4, maxAreaOfIsland(arr3))
    }
}