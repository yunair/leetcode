package dp.climbstairs

import kotlin.test.assertEquals

object P647PalindromicSubstrings {
    private var count = 0
    fun countSubstrings(s: String): Int {
        count = s.length
        for (i in 1 until s.length) {
            for (j in i until s.length) {
                // 判断2个字符，3个字符。。。n个字符是否为回文
                dp(s.substring(j - i, j + 1))
            }
        }
        return count
    }

    private fun dp(str: String) {
        for (i in 0..(str.length / 2)) {
            if (str[i] != str[str.length - 1 - i]) {
                return
            }
        }
        count += 1
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(3, countSubstrings("abc"))
        assertEquals(6, countSubstrings("aaa"))
    }
}