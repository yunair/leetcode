package datastructure.dfs

import kotlin.test.assertEquals

/**
 * 岛屿数量
 */
object P200NumbersOfIsland {
    private val dirs = Array(4) {
        IntArray(2)
    }.apply {
        this[0] = intArrayOf(1, 0)
        this[1] = intArrayOf(-1, 0)
        this[2] = intArrayOf(0, 1)
        this[3] = intArrayOf(0, -1)
    }

    /**
     * 访问过的置0，可以简化代码
     */
    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isEmpty()) {
            return 0
        }
        var count = 0
        val visited = Array(grid.size) {
            BooleanArray(grid[0].size)
        }
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == '0' || visited[i][j]) {
                    continue
                }
                visited[i][j] = true
                dfs(grid, i, j, visited)
                count++
            }
        }
        return count
    }

    private fun dfs(grid: Array<CharArray>, row: Int, col: Int, visited: Array<BooleanArray>) {
        if (grid[row][col] == '0') {
            return
        }

        for (dir in dirs) {
            val aimRow = row + dir[0]
            val aimCol = col + dir[1]
            if (aimRow < 0 || aimRow >= grid.size || aimCol < 0 || aimCol >= grid[0].size || visited[aimRow][aimCol]) {
                continue
            }
            if (grid[aimRow][aimCol] == '1') {
                visited[aimRow][aimCol] = true
                dfs(grid, aimRow, aimCol, visited)
            }
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val arr1 = Array(4) {
            CharArray(5)
        }.apply {
            this[0] = "11110".toCharArray()
            this[1] = "11010".toCharArray()
            this[2] = "11000".toCharArray()
            this[3] = "00000".toCharArray()
        }

        assertEquals(1, numIslands(arr1))


        val arr2 = Array(4) {
            CharArray(5)
        }.apply {
            this[0] = "11000".toCharArray()
            this[1] = "11000".toCharArray()
            this[2] = "00100".toCharArray()
            this[3] = "00011".toCharArray()
        }

        assertEquals(3, numIslands(arr2))


    }
}