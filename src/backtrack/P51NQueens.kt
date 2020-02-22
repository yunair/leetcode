package backtrack

/**
 * N皇后
 */
object P51NQueens {
    val ans = mutableListOf<List<String>>()
    fun solveNQueens(n: Int): List<List<String>> {
        val board = MutableList(n) {
            val sb = StringBuilder()
            for (i in 0 until n) {
                sb.append('.')
            }
            sb.toString()
        }
        backtrack(board, 0)
        return ans
    }

    private fun backtrack(board: MutableList<String>, row: Int) {
        if (row == board.size) {
            ans.add(ArrayList(board))
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
        ans.clear()
        println(solveNQueens(4))
    }
}