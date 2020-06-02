package search

/**
 * 搜索二维矩阵 II
 */
object P240SearchA2DMatrix {
    /**
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     */
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isEmpty() || matrix[0].isEmpty()) {
            return false
        }

        // 从左下角开始检查，大往右，小往上
        var i = matrix.size - 1
        var j = 0
        while (i >= 0 && j < matrix[0].size) {
            when {
                matrix[i][j] == target -> {
                    return true
                }
                matrix[i][j] > target -> {
                    i--
                }
                else -> {
                    j++
                }
            }
        }

        return false
    }
}