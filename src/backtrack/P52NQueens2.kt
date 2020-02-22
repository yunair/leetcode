package backtrack

import kotlin.test.assertEquals

/**
 * N皇后2
 */
object P52NQueens2 {
    var count = 0
    /**
     * 优化思路，将String替换成二进制处理
     */
    fun totalNQueens(n: Int): Int {
        count = 0
        val board = MutableList(n) {
            val sb = StringBuilder()
            for (i in 0 until n) {
                sb.append('.')
            }
            sb.toString()
        }
        backtrack(board, 0)
        return count
    }

    private fun backtrack(board: MutableList<String>, row: Int) {
        if (row == board.size) {
            count++
            return
        }
        for (col in board[row].indices) {
            if (!valid(board, row, col)) {
                continue
            }
            val origin = board[row]
            board[row] = board[row].replaceRange(col, col + 1, "Q")

            backtrack(board, row + 1)

            board[row] = origin
        }
    }

    private fun valid(board: MutableList<String>, row: Int, column: Int): Boolean {
        if (row == 0) {
            return true
        }


        for (col in (row - 1) downTo 0) {
            // 竖线
            if (board[col][column] == 'Q') {
                return false
            }
            // 斜线
            val top = row - col
            if (column - top >= 0 && board[col][column - top] == 'Q') {
                return false
            }

            if (column + top < board[col].length && board[col][column + top] == 'Q') {
                return false
            }
        }
        return true
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(2, totalNQueens(4))
    }
}