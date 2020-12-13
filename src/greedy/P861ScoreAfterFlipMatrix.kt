package greedy

import java.lang.StringBuilder
import kotlin.test.assertEquals

/**
 * 翻转矩阵后的得分
 */
object P861ScoreAfterFlipMatrix {
    fun matrixScore(arr: Array<IntArray>): Int {
        for (i in arr.indices) {
            // 第一列保证全是1
            if (arr[i][0] == 0) {
                // 将该行调换顺序
                for (j in arr[i].indices) {
                    arr[i][j] = if (arr[i][j] == 0) {
                        1
                    } else {
                        0
                    }
                }
            }
        }
        // 将一列中出现1的个数 > 0的个数
        for (i in 1 until arr[0].size) {
            var zeroCount = 0
            for (j in arr.indices) {
                if (arr[j][i] == 0) {
                    zeroCount++
                }
            }
            // 0个数较多
            if (arr.size - zeroCount < zeroCount) {
                for (j in arr.indices) {
                    arr[j][i] = if (arr[j][i] == 0) {
                        1
                    } else {
                        0
                    }
                }
            }
        }

        return arr.map {
            val sb = StringBuilder()
            for (i in it) {
                sb.append(i)
            }
            Integer.parseInt(sb.toString(), 2)
        }.sum()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val matrix = Array(3) {
            IntArray(4)
        }.apply {
            this[0] = intArrayOf(0, 0, 1, 1)
            this[1] = intArrayOf(1, 0, 1, 0)
            this[2] = intArrayOf(1, 1, 0, 0)
        }
        assertEquals(39, matrixScore(matrix))
    }
}