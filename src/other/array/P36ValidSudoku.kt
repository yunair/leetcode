package datastructure.array

import kotlin.test.assertEquals

/**
 * 有效的数独
 */
object P36ValidSudoku {
    /**
     * 一个循环内检测row， column和子数独
     *
     * 如何枚举子数独？
     * 可以使用 box_index = (row / 3) * 3 + columns / 3，其中 / 是整数除法。
     *
     */
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        // check row
        val row = checkRow(board)
        // check column
        val column = checkColumn(board)
        // check 3*3
        val smallSudoku = check3by3Sudoku(board)

        return row && column && smallSudoku
    }

    private fun check3by3Sudoku(board: Array<CharArray>): Boolean {
        for (i in board.indices step 3) {
            for (j in board[0].indices step 3) {
                val arr = CharArray(9)
                var index = 0
                for (k in 0..2) {
                    for (l in 0..2) {
                        arr[index++] = board[k + i][j + l]
                    }
                }
                val visited = BooleanArray(9)
                for (c in arr) {
                    if (c == '.') {
                        continue
                    }
                    val vIndex = Integer.parseInt(c.toString()) - 1
                    if (visited[vIndex]) {
                        return false
                    }
                    visited[vIndex] = true
                }



            }
        }
        return true
    }

    private fun checkColumn(board: Array<CharArray>): Boolean {
        for (i in board[0].indices) {
            // row
            val visited = BooleanArray(9)
            for (j in board.indices) {
                val c = board[j][i]
                if (c == '.') {
                    continue
                }

                val index = Integer.parseInt(c.toString()) - 1
                if (visited[index]) {
                    return false
                }
                visited[index] = true
            }
        }
        return true
    }

    private fun checkRow(board: Array<CharArray>): Boolean {
        for (i in board.indices) {
            // row
            val visited = BooleanArray(9)
            for (j in board[i].indices) {
                val c = board[i][j]
                if (c == '.') {
                    continue
                }

                val index = Integer.parseInt(c.toString()) - 1
                if (visited[index]) {
                    return false
                }
                visited[index] = true
            }
        }

        return true
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val arr = Array(9) {
            CharArray(9)
        }.apply {
            this[0] = charArrayOf('.', '.', '.', '.', '5', '.', '.', '1', '.')
            this[1] = charArrayOf('.', '4', '.', '3', '.', '.', '.', '.', '.')
            this[2] = charArrayOf('.', '.', '.', '.', '.', '3', '.', '.', '1')
            this[3] = charArrayOf('8', '.', '.', '.', '.', '.', '.', '2', '.')
            this[4] = charArrayOf('.', '.', '2', '.', '7', '.', '.', '.', '.')
            this[5] = charArrayOf('.', '1', '5', '.', '.', '.', '.', '.', '.')
            this[6] = charArrayOf('.', '.', '.', '.', '.', '2', '.', '.', '.')
            this[7] = charArrayOf('.', '2', '.', '9', '.', '.', '.', '.', '.')
            this[8] = charArrayOf('.', '.', '4', '.', '.', '.', '.', '.', '.')
        }

        assertEquals(false, isValidSudoku(arr))
    }
}