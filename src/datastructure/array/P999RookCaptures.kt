package other.array

/**
 * 车的可用捕获量
 */
object P999RookCaptures {
    fun numRookCaptures(board: Array<CharArray>): Int {
        for (i in board.indices) {
            for (j in board[0].indices) {
                if (board[i][j] == 'R') {
                    return search(board, i, j)
                }
            }
        }
        return 0
    }

    private fun search(board: Array<CharArray>, ri: Int, rj: Int): Int {
        var count = 0
        val dx = intArrayOf(-1, 1, 0, 0)
        val dy = intArrayOf(0, 0, -1, 1)
        for (i in 0..3) {
            var x = ri
            var y = rj
            while (true) {
                x += dx[i]
                y += dy[i]
                if (x < 0 || x == 8 || y < 0 || y == 8 || board[x][y] == 'B') {
                    break
                }
                if (board[x][y] == 'p') {
                    count++
                    break
                }
            }
        }

        return count
    }
}