package backtrack

import kotlin.test.assertEquals

/**
 * 串联字符串的最大长度
 */
object P1239MaxLengthOfString {
    var max = 0
    fun maxLength(arr: List<String>): Int {
        max = 0
        backtrack(arr, 0, "")
        return max
    }

    private fun backtrack(arr: List<String>, index: Int, str: String) {
        val count = IntArray(26)
        for (c in str) {
            count[c - 'a']++
            if (count[c - 'a'] > 1) {
                return
            }
        }

        max = maxOf(str.length, max)
        if (index == arr.size) {
            return
        }

        for (i in index until arr.size) {
            backtrack(arr, i + 1, str + arr[i])
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(4, maxLength(listOf("un", "iq", "ue")))
        assertEquals(6, maxLength(listOf("cha", "r", "act", "ers")))
        assertEquals(26, maxLength(listOf("abcdefghijklmnopqrstuvwxyz")))
    }
}