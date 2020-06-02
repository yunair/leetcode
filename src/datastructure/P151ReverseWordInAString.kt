package other

import kotlin.test.assertEquals

/**
 * 翻转字符串里的单词
 */
object P151ReverseWordInAString {
    fun reverseWords(s: String): String {
        return s.trim().split(Regex(" +"))
            .reversed()
            .joinToString(" ")
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals("blue is sky the", reverseWords("the sky is blue"))
        assertEquals("world! hello", reverseWords("  hello world!  "))
        assertEquals("example good a", reverseWords("a good   example"))
    }
}