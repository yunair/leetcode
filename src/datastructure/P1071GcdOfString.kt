package datastructure

import kotlin.test.assertEquals

/**
 * 字符串的最大公因子
 */
object P1071GcdOfString {
    fun gcdOfStrings(str1: String, str2: String): String {
        // 假设str1是N个x，str2是M个x，那么str1+str2肯定是等于str2+str1的。
        if ((str1 + str2) != str2 + str1) {
            return ""
        }


        return str1.substring(0, gcd(str1.length, str2.length))
    }

    fun gcd(a: Int, b: Int): Int {
        if (b == 0) {
            return a
        }

        return gcd(b, a % b)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals("ABC", gcdOfStrings("ABCABC", "ABC"))
        assertEquals("AB", gcdOfStrings("ABABAB", "ABAB"))
        assertEquals(
            "OBCNO",
            gcdOfStrings(
                "OBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNO",
                "OBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNO"
            )
        )
        assertEquals("", gcdOfStrings("ABACAB", "ABAC"))
        assertEquals("", gcdOfStrings("LEET", "CODE"))
        assertEquals("", gcdOfStrings("ABCABD", "ABC"))
    }
}