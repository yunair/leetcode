package backtrack

/**
 * 解数独
 */
object P37SudokuSolver {
    fun solveSudoku(board: Array<CharArray>) {
        backtracker(board, 0, 0)
        /*for (i in 0 until 9) {
            for (j in 0 until 9) {
                if (backtracker(board, i, j)) {
                    return
                }
            }
        }*/
    }

    private fun backtracker(board: Array<CharArray>, row: Int, col: Int): Boolean {
        // base case
        if (row == 9) {
            return true
        }
        if (col == 9) {
            return backtracker(board, row + 1, 0)
        }

        // 已有数字，忽略
        if (board[row][col] != '.') {
            return backtracker(board, row, col + 1)
        }
        for (i in 1..9) {
            if (!isValid(board, row, col, '0' + i)) {
                continue
            }
            // check valid
            board[row][col] = '0' + i
            if (backtracker(board, row, col + 1)) {
                return true
            }
            board[row][col] = '.'
        }
        return false
    }

    private fun isValid(board: Array<CharArray>, row: Int, col: Int, value: Char): Boolean {
        // 横行不能有重复值
        for (i in 0..8) {
            if (board[row][i] == value) {
                return false
            }
        }
        // 竖行不能有重复值
        for (i in 0..8) {
            if (board[i][col] == value) {
                return false
            }
        }
        // 所在九宫格
        for (i in 0..2) {
            val k = (row / 3) * 3 + (row + i) % 3
            for (j in 0..2) {
                val l = (col / 3) * 3 + (col + j) % 3
                if (board[k][l] == value) {
                    return false
                }
            }
        }

        return true
    }
}