package search

import java.util.*

/**
 * 01 矩阵
 */
object P54201Matrix {
    private val dirsX = intArrayOf(1, -1, 0, 0)
    private val dirsY = intArrayOf(0, 0, 1, -1)

    /**
     * 可以外部添加一个0节点，然后把所有数组中的0节点都加入，然后再用BFS搜索
     */
    fun updateMatrix(matrix: Array<IntArray>): Array<IntArray> {
        if (matrix.isEmpty() || matrix[0].isEmpty()) {
            return emptyArray()
        }
        val size = matrix.size
        val ans = Array(size) { IntArray(matrix[0].size) }
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                if (matrix[i][j] == 0) {
                    ans[i][j] = 0
                } else {
                    // bfs找到最近的0
                    ans[i][j] = bfs(matrix, i, j)
                }
            }
        }
        return ans
    }

    private fun bfsExtraZero(
        matrix: Array<IntArray>,
        queue: LinkedList<Pair<Int, Int>>,
        visited: Array<BooleanArray>,
        ans: Array<IntArray>
    ) {
        val lineSize = matrix.size
        val columnSize = matrix[0].size
        var count = 0
        while (queue.isNotEmpty()) {
            val size = queue.size
            count++

            for (i in 1..size) {
                val loc = queue.poll()
                for (j in 0..3) {
                    val newX = loc.first + dirsX[j]
                    val newY = loc.second + dirsY[j]
                    if (newX < 0 || newX >= lineSize || newY < 0 || newY >= columnSize || visited[newX][newY]) {
                        continue
                    }

                    ans[newX][newY] = ans[loc.first][loc.second] + 1
                    queue.add(Pair(newX, newY))
                    visited[newX][newY] = true
                }
            }
        }
    }

    private fun bfs(matrix: Array<IntArray>, startX: Int, startY: Int): Int {
        val lineSize = matrix.size
        val columnSize = matrix[0].size
        var count = 0
        val queue = LinkedList<Pair<Int, Int>>()
        queue.add(Pair(startX, startY))
        val visited = Array(lineSize) {
            BooleanArray(columnSize)
        }
        visited[startX][startY] = true
        while (queue.isNotEmpty()) {
            val size = queue.size
            count++
            for (i in 1..size) {
                val loc = queue.poll()
                for (j in 0..3) {
                    val newX = loc.first + dirsX[j]
                    val newY = loc.second + dirsY[j]
                    if (newX < 0 || newX >= lineSize || newY < 0 || newY >= columnSize || visited[newX][newY]) {
                        continue
                    }

                    if (matrix[newX][newY] == 0) {
                        return count
                    }
                    queue.add(Pair(newX, newY))
                    visited[newX][newY] = true
                }
            }
        }
        return -1
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val matrix1 = Array(3) {
            IntArray(3)
        }.apply {
            this[0] = intArrayOf(0, 0, 0)
            this[1] = intArrayOf(0, 1, 0)
            this[2] = intArrayOf(0, 0, 0)
        }

        println(updateMatrix(matrix1).contentDeepToString())
    }
}