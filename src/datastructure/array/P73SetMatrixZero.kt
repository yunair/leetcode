package other.array

/**
 *  矩阵置零
 */
object P73SetMatrixZero {
    fun setZeroes(matrix: Array<IntArray>) {
        val list = mutableListOf<Pair<Int, Int>>()
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                if (matrix[i][j] == 0) {
                    list.add(Pair(i, j))
                }
            }
        }

        for (item in list) {
            for (j in matrix[0].indices) {
                matrix[item.first][j] = 0
            }
            for (i in matrix.indices) {
                matrix[i][item.second] = 0
            }
        }
    }
}