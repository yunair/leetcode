package other

/**
 * 螺旋矩阵
 */
object P54SpiralMatrix {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val list = mutableListOf<Int>()
        if (matrix.isEmpty()) {
            return list
        }
        // 1向右  2向下 3向左 4向上
        var direct = 1
        var left = 0
        var top = 0
        var right = matrix[0].size - 1
        var bottom = matrix.size - 1
        while (bottom >= top && right >= left) {
            when (direct) {
                1 -> {
                    for (i in left..right) {
                        list.add(matrix[top][i])
                    }
                    top++
                    direct = 2
                }
                2 -> {
                    for (num in top..bottom) {
                        list.add(matrix[num][right])
                    }
                    right--
                    direct = 3
                }
                3 -> {
                    for (i in right downTo left) {
                        list.add(matrix[bottom][i])
                    }
                    bottom--
                    direct = 4
                }
                else -> {
                    for (i in bottom downTo top) {
                        list.add(matrix[i][left])
                    }
                    left++
                    direct = 1
                }
            }
        }

        return list
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val arr1 = Array(3) {
            IntArray(4)
        }.apply {
            this[0] = intArrayOf(1, 2, 3, 4)
            this[1] = intArrayOf(5, 6, 7, 8)
            this[2] = intArrayOf(9, 10, 11, 12)
        }
        println(spiralOrder(arr1))
    }
}