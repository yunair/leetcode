package math

import kotlin.test.assertEquals

/**
 * Excel表列序号
 */
object P171ExcelSheetColumnNumber {
    /**
     * 26进制数
     */
    fun titleToNumber(s: String): Int {
        var ans = 0
        for (c in s) {
            ans = ans * 26 + (c - 'A') + 1
        }
        return ans
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(1, titleToNumber("A"))
        assertEquals(28, titleToNumber("AB"))
        assertEquals(701, titleToNumber("ZY"))
    }
}