package math

import kotlin.test.assertEquals

/**
 * 三维形体的表面积
 */
object P892SurfaceAreaOf3D {
    fun surfaceArea(grid: Array<IntArray>): Int {
        val dirs = arrayOf(Pair(1, 0), Pair(0, 1), Pair(-1, 0), Pair(0, -1))
        var area = 0
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                val cur = grid[i][j]

                if (cur == 0) {
                    continue
                }
                // 顶部和底部面积
                area += 2
                // 四周表面积
                for (dir in dirs) {
                    val newRow = i + dir.first
                    val newCol = j + dir.second
                    if (newRow < 0 || newRow > grid.size - 1
                        || newCol < 0 || newCol > grid[0].size - 1
                    ) {
                        area += cur
                        continue
                    }
                    val v = grid[newRow][newCol]
                    if (v < cur) {
                        area += cur - v
                    }
                }
            }
        }

        return area
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val grid1 = Array(1) {
            intArrayOf(2)
        }
        assertEquals(10, surfaceArea(grid1))

        val grid2 = Array(2) {
            IntArray(2)
        }.apply {
            this[0] = intArrayOf(1, 2)
            this[1] = intArrayOf(3, 4)
        }
        assertEquals(34, surfaceArea(grid2))

        val grid3 = Array(2) {
            IntArray(2)
        }.apply {
            this[0] = intArrayOf(1, 0)
            this[1] = intArrayOf(0, 2)
        }
        assertEquals(16, surfaceArea(grid3))

        val grid4 = Array(3) {
            IntArray(3)
        }.apply {
            this[0] = intArrayOf(1,1,1)
            this[1] = intArrayOf(1,0,1)
            this[2] = intArrayOf(1,1,1)
        }
        assertEquals(32, surfaceArea(grid4))

        val grid5 = Array(3) {
            IntArray(3)
        }.apply {
            this[0] = intArrayOf(2,2,2)
            this[1] = intArrayOf(2,1,2)
            this[2] = intArrayOf(2,2,2)
        }
        assertEquals(46, surfaceArea(grid5))
    }
}