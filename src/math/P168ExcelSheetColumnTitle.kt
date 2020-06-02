package math

import java.lang.StringBuilder
import kotlin.test.assertEquals

/**
 * Excel表列名称
 */
object P168ExcelSheetColumnTitle {
    fun convertToTitle(n: Int): String {
        val sb = StringBuilder()
        var value = n
        while (value > 0) {
            value--
            sb.insert(0, 'A' + value % 26)
            value /= 26
        }
        return sb.toString()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals("A", convertToTitle(1))
        assertEquals("AB", convertToTitle(28))
        assertEquals("ZY", convertToTitle(701))
        assertEquals("AZ", convertToTitle(52))
    }
}