package datastructure.array

/**
 * 旋转图像
 */
object P48RotateImage {
    fun rotate(matrix: Array<IntArray>) {
        // 先对角线交换，再左右交换
        // 这样就可以达到旋转90度的效果
        val size = matrix.size

        // 对角线交换
        for (i in 0 until size - 1) {
            for (j in i + 1 until size) {
                val temp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = temp
            }
        }

        // 左右交换
        for (i in 0 until size) {
            var left = 0
            var right = size - 1
            while (left < right) {
                swap(matrix[i], left, right)
                left++
                right--
            }
        }
    }

    private fun swap(arr: IntArray, i: Int, j: Int) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val arr = Array(3) {
            IntArray(3)
        }.apply {
            this[0] = intArrayOf(1, 2, 3)
            this[1] = intArrayOf(4, 5, 6)
            this[2] = intArrayOf(7, 8, 9)
        }
        rotate(arr)
        println(arr.contentDeepToString())
    }
}