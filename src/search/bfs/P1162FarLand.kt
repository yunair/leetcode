package datastructure.bfs

import java.util.*
import kotlin.math.abs

/**
 * 地图分析
 */
object P1162FarLand {
    fun maxDistance(grid: Array<IntArray>): Int {
        val xDirs = intArrayOf(-1, 1, 0, 0)
        val yDirs = intArrayOf(0, 0, 1, -1)
        val visited = mutableSetOf<Pair<Int, Int>>()
        var max = -1
        val queue = LinkedList<Pair<Int, Int>>()
        for (row in grid.indices) {
            for (column in grid[0].indices) {
                if (grid[row][column] == 0) {
                    queue.clear()
                    visited.clear()
                    visited.add(Pair(row, column))
                    queue.addLast(Pair(row, column))
                    var findLand = false
                    while (!findLand && queue.isNotEmpty()) {
                        val size = queue.size
                        for (i in 1..size) {
                            val pos = queue.pollFirst()
                            for (index in 0..3) {
                                val x = pos.first + xDirs[index]
                                val y = pos.second + yDirs[index]
                                if (x < 0 || x >= grid.size || y < 0 || y >= grid[0].size) {
                                    continue
                                }
                                if (visited.contains(Pair(x, y))) {
                                    continue
                                }
                                if (grid[x][y] == 1) {
                                    // 计算当前长度，不继续了
                                    max = maxOf(abs(x - row) + abs(y - column), max)
                                    findLand = true
                                    break
                                } else {
                                    queue.addLast(Pair(x, y))
                                }
                                visited.add(Pair(x, y))
                            }
                        }
                    }

                }
            }
        }
        return max
    }
}