package other

import jdk.nashorn.internal.runtime.JSONFunctions
import java.lang.StringBuilder
import java.util.*
import kotlin.Comparator
import kotlin.test.assertEquals

/**
 * 单词的压缩编码
 */
object P820ShortEncodingOfWord {
    fun minimumLengthEncoding(words: Array<String>): Int {
        val sb = StringBuilder()
        Arrays.sort(words) { o1, o2 -> o2.length.compareTo(o1.length) }
        for (word in words) {
            // 防止前缀匹配，只能后缀匹配
            val index = sb.indexOf("$word#")
            if (index == -1) {
                sb.append(word).append("#")
            }
        }
        return sb.length
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(10, minimumLengthEncoding(arrayOf("time", "me", "bell")))
        assertEquals(5, minimumLengthEncoding(arrayOf("me", "time")))
    }
}