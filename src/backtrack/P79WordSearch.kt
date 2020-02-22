package backtrack

import kotlin.test.assertEquals

/**
 * 单词搜索
 */
object P79WordSearch {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        if (word.isEmpty()) {
            return true
        }

        if (board.isEmpty()) {
            return false
        }
        for (rowIndex in board.indices) {
            val row = board[rowIndex]
            for (columnIndex in row.indices) {
                if (backtrack(board, 0, rowIndex, columnIndex, word)) {
                    return true
                }
            }
        }
        return false
    }

    /**
     * 查到当前值，往四面走
     */
    private fun backtrack(board: Array<CharArray>, wordIndex: Int, row: Int, column: Int, word: String): Boolean {
        if (board[row][column] != word[wordIndex]) {
            return false
        }

        // 最后一个字母也一样
        if (word.length - 1 == wordIndex) {
            return true
        }

        val tmp = board[row][column]
        board[row][column] = '-' // 用过了就不能再次查
        if ((row > 0 && backtrack(board, wordIndex + 1, row - 1, column, word)) // 向左
            || (column > 0 && backtrack(board, wordIndex + 1, row, column - 1, word)) //向上
            || (row < board.size - 1 && backtrack(board, wordIndex + 1, row + 1, column, word)) // 向右
            || (column < board[0].size - 1 && backtrack(board, wordIndex + 1, row, column + 1, word)) // 向下
        ) {
            return true
        }

        board[row][column] = tmp //回朔
        return false

    }

    @JvmStatic
    fun main(args: Array<String>) {
        val arr1 = Array<CharArray>(3) {
            CharArray(4)
        }.apply {
            this[0] = charArrayOf('A', 'B', 'C', 'E')
            this[1] = charArrayOf('S', 'F', 'C', 'S')
            this[2] = charArrayOf('A', 'D', 'E', 'E')
        }
        assertEquals(true, exist(arr1, "ABCCED"))
        assertEquals(true, exist(arr1, "SEE"))
        assertEquals(true, exist(arr1, "ADFC"))
        assertEquals(false, exist(arr1, "ABCB"))
        val arr2 = Array<CharArray>(3) {
            CharArray(3)
        }.apply {
            this[0] = charArrayOf('C', 'A', 'A')
            this[1] = charArrayOf('A', 'A', 'A')
            this[2] = charArrayOf('B', 'C', 'D')
        }
        assertEquals(true, exist(arr2, "AAB"))
    }
}