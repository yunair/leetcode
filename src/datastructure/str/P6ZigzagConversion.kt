package other.str

import java.lang.StringBuilder
import kotlin.test.assertEquals

/**
 * Z 字形变换
 */
object P6ZigzagConversion {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) {
            return s
        }

        val arr = Array(numRows) {
            CharArray(s.length) {
                ' '
            }
        }

        var index = 0
        var col = 0

        while (index < s.length) {
            for (i in 0 until numRows) {
                val remain = col % (numRows - 1)
                if (remain == 0 || (i == (numRows - 1 - remain))) {
                    arr[i][col] = s[index++]
                }
                if (index == s.length) {
                    break
                }
            }
            col++
        }

        val res = StringBuilder()
        for (i in arr.indices) {
            for (j in arr[0].indices) {
                if (arr[i][j] != ' ') {
                    res.append(arr[i][j])
                }
            }
        }
        return res.toString()
    }

    /**
     * 按行排序
     * 通过从左向右迭代字符串，我们可以轻松地确定字符位于 Z 字形图案中的哪一行。
     */
    fun convertBetter(s: String, numRows: Int): String {
        if (numRows == 1) {
            return s
        }
        val rows = mutableListOf<StringBuilder>()

        // 需要的行数
        val minLen = minOf(numRows, s.length)
        for (i in 1..minLen) {
            rows.add(StringBuilder())
        }

        var curRow = 0
        var goingDown = false
        for (c in s) {
            rows[curRow].append(c)
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown
            }

            curRow += if (goingDown) {
                1
            } else {
                -1
            }
        }

        val res = StringBuilder()
        for (row in rows) {
            res.append(row)
        }
        return res.toString()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals("LCIRETOESIIGEDHN", convertBetter("LEETCODEISHIRING", 3))
        assertEquals("LDREOEIIECIHNTSG", convertBetter("LEETCODEISHIRING", 4))
        assertEquals("PAHNAPLSIIGYIR", convertBetter("PAYPALISHIRING", 3))
    }
}