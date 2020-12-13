package interview

import java.lang.StringBuilder
import kotlin.test.assertEquals

/**
 * 字符串压缩
 */
object CompressString {
    fun compressString(s: String): String {
        if (s.isEmpty()) {
            return ""
        }

        var tmp = s[0]
        var count = 1
        val ans = StringBuilder()
        for (i in 1 until s.length) {
            if (s[i] == tmp) {
                count++
            } else {
                ans.append(tmp).append(count)
                tmp = s[i]
                count = 1
            }
        }
        ans.append(tmp).append(count)

        return if (ans.toString().length >= s.length) {
            s
        } else {
            ans.toString()
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals("a2b1c5a3", compressString("aabcccccaaa"))
        assertEquals("abbccd", compressString("abbccd"))
    }
}