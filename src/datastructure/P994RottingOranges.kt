package datastructure

import java.util.*
import kotlin.test.assertEquals

/**
 *  腐烂的橘子
 */
object P994RottingOranges {
    fun orangesRotting(grid: Array<IntArray>): Int {
        val visited = Array(grid.size) {
            BooleanArray(grid[0].size)
        }
        val queue = ArrayDeque<Pair<Int, Int>>()

        var fresh = 0

        for (row in grid.indices) {
            for (column in grid[0].indices) {
                when {
                    grid[row][column] == 0 -> {
                        visited[row][column] = true
                    }
                    grid[row][column] == 2 -> {
                        visited[row][column] = true
                        queue.push(Pair(row, column))
                    }
                    else -> {
                        fresh++
                    }
                }
            }
        }


        var count = 0
        while (queue.isNotEmpty()) {
            val size = queue.size
            var needNext = false
            for (i in 0 until size) {
                val loc = queue.pop()
                needNext = needNext or rotRound(grid, loc.first, loc.second, visited, queue)
            }
            if (needNext) {
                count++
            }
        }

        // 判断fresh > 0即为-1
        for (row in grid.indices) {
            for (column in grid[0].indices) {
                if (!visited[row][column]) {
                    return -1
                }
            }
        }

        return count
    }

    private fun rotRound(
        grid: Array<IntArray>,
        row: Int,
        column: Int,
        visited: Array<BooleanArray>,
        queue: Deque<Pair<Int, Int>>
    ): Boolean {
        var ans = false
        if (row + 1 < grid.size && !visited[row + 1][column]) {
            queue.add(Pair(row + 1, column))
            visited[row + 1][column] = true
            ans = true
        }

        if (row - 1 >= 0 && !visited[row - 1][column]) {
            queue.add(Pair(row - 1, column))
            visited[row - 1][column] = true
            ans = true
        }

        if (column + 1 < grid[0].size && !visited[row][column + 1]) {
            queue.add(Pair(row, column + 1))
            visited[row][column + 1] = true

            ans = true
        }

        if (column - 1 >= 0 && !visited[row][column - 1]) {
            queue.add(Pair(row, column - 1))
            visited[row][column - 1] = true

            ans = true
        }
        return ans
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val arr1 = Array(3) {
            IntArray(3)
        }.apply {
            this[0] = intArrayOf(2, 1, 1)
            this[1] = intArrayOf(1, 1, 0)
            this[2] = intArrayOf(0, 1, 1)
        }

        assertEquals(4, orangesRotting(arr1))

        val arr2 = Array(3) {
            IntArray(3)
        }.apply {
            this[0] = intArrayOf(2, 1, 1)
            this[1] = intArrayOf(0, 1, 1)
            this[2] = intArrayOf(1, 0, 1)
        }

        assertEquals(-1, orangesRotting(arr2))

        val arr3 = Array(1) {
            IntArray(2)
        }.apply {
            this[0] = intArrayOf(0, 2)
        }

        assertEquals(0, orangesRotting(arr3))

        val arr4 = Array(1) {
            IntArray(3)
        }.apply {
            this[0] = intArrayOf(0, 2, 2)
        }

        assertEquals(0, orangesRotting(arr4))

        val arr5 = Array(1) {
            IntArray(1)
        }.apply {
            this[0] = intArrayOf(0)
        }

        assertEquals(0, orangesRotting(arr5))

        val arr7 = Array(1) {
            IntArray(1)
        }.apply {
            this[0] = intArrayOf(1)
        }

        assertEquals(-1, orangesRotting(arr7))

        val arr6 = Array(1) {
            IntArray(2)
        }.apply {
            this[0] = intArrayOf(0, 1)
        }

        assertEquals(-1, orangesRotting(arr6))

        val arr8 = Array(4) {
            IntArray(2)
        }.apply {
            this[0] = intArrayOf(2, 2)
            this[1] = intArrayOf(1, 1)
            this[2] = intArrayOf(0, 0)
            this[3] = intArrayOf(2, 0)
        }

        assertEquals(1, orangesRotting(arr8))
    }
}