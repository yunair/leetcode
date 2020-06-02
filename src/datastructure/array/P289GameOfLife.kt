package datastructure.array

import kotlin.math.abs


object P289GameOfLife {
    /**
     * 不用额外空间，则需要修改成某个数，标识状态
     */
    fun gameOfLife(board: Array<IntArray>) {
        if (board.isEmpty()) {
            return
        }
        val dirX = intArrayOf(1, -1, 1, -1, 1, -1, 0, 0)
        val dirY = intArrayOf(0, 0, 1, -1, -1, 1, 1, -1)

        for (i in board.indices) {
            for (j in board[0].indices) {
                val cur = board[i][j]
                var live = 0
                for (k in 0..7) {
                    val x = i + dirX[k]
                    val y = j + dirY[k]
                    if (x < 0 || x >= board.size || y < 0 || y >= board[0].size) {
                        continue
                    }
                    val round = board[x][y]
                    if (abs(round) == 1) {
                        live++
                    }
                }
                if (cur == 1) {
                    when {
                        live < 2 -> {
                            // 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
                            board[i][j] = -1
                        }
                        live > 3 -> {
                            // 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
                            board[i][j] = -1
                        }
                        else -> {
                            // 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活
                        }
                    }
                } else {
                    // 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
                    if (live == 3) {
                        board[i][j] = 2
                    }
                }
            }
        }

        for (i in board.indices) {
            for (j in board[0].indices) {
                if (board[i][j] == -1) {
                    board[i][j] = 0
                }
                if (board[i][j] == 2) {
                    board[i][j] = 1
                }
            }
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        /*val arr = Array(2) {
            IntArray(2)
        }.apply {
            this[0] = intArrayOf(1, 1)
            this[1] = intArrayOf(1, 0)
        }
        gameOfLife(arr)
        println(arr.contentDeepToString())*/

        val arr1 = Array(4) {
            IntArray(3)
        }.apply {
            this[0] = intArrayOf(0, 1, 0)
            this[1] = intArrayOf(0, 0, 1)
            this[2] = intArrayOf(1, 1, 1)
            this[3] = intArrayOf(0, 0, 0)
        }
        gameOfLife(arr1)
        println(arr1.contentDeepToString())
    }
}