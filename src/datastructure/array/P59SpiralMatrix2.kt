package other.array

/**
 * 螺旋矩阵2
 */
object P59SpiralMatrix2 {
    fun generateMatrix(n: Int): Array<IntArray> {
        val arr = Array(n) {
            IntArray(n)
        }
        if (n == 0) {
            return arr
        }
        // 1向右  2向下 3向左 4向上
        var direct = 1
        var left = 0
        var top = 0
        var right = n - 1
        var bottom = n - 1
        var value = 1
        while (bottom >= top && right >= left) {
            when (direct) {
                1 -> {
                    for (i in left..right) {
                        arr[top][i] = value++
                    }
                    top++
                    direct = 2
                }
                2 -> {
                    for (num in top..bottom) {
                        arr[num][right] = value++
                    }
                    right--
                    direct = 3
                }
                3 -> {
                    for (i in right downTo left) {
                        arr[bottom][i] = value++
                    }
                    bottom--
                    direct = 4
                }
                else -> {
                    for (i in bottom downTo top) {
                        arr[i][left] = value++
                    }
                    left++
                    direct = 1
                }
            }
        }

        return arr
    }

    @JvmStatic
    fun main(args: Array<String>) {
        for (arr in generateMatrix(3)) {
            println(arr.contentToString())
        }
    }
}