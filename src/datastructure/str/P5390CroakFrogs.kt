package other.str

import contest.Weekly185
import kotlin.test.assertEquals

object P5390CroakFrogs {
    fun minNumberOfFrogs(croakOfFrogs: String): Int {
        var c = 0
        var r = 0
        var o = 0
        var a = 0
        var k = 0
        var num = 0
        for (ch in croakOfFrogs) {
            if (ch == 'c') {
                c++
            }
            if (ch == 'r') {
                r++
            }
            if (ch == 'o') {
                o++
            }
            if (ch == 'a') {
                a++
            }
            if (ch == 'k') {
                k++
            }
            if (r > c || o > r || a > o || k > a) {
                return -1
            }

            num = maxOf(num, c)
            if (k == 1) {
                c--
                r--
                o--
                a--
                k--
            }
        }

        if (c > 0) {
            return -1
        }
        return num
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(1, minNumberOfFrogs("croakcroak"))
        assertEquals(2, minNumberOfFrogs("crcoakroak"))
        assertEquals(-1, minNumberOfFrogs("croakcrook"))
        assertEquals(-1, minNumberOfFrogs("croakcroa"))
        assertEquals(3, minNumberOfFrogs("crocracokrakoak"))
        assertEquals(2, minNumberOfFrogs("crocakcroraoakk"))
    }
}