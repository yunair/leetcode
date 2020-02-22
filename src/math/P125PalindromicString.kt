package math

import kotlin.test.assertEquals

/**
 * 回文数
 */
object P9PalindromicNumber {
    /**
     * 数字是回文
     * 1。 不能为负数
     *
     *
     * 数字不转成字符串的做法:
     *
     * 不能反转全部，因为可能超过Int.MAX_VALUE
     * 反转一半数字
     * 比较前一半和后一半是否一致
     *
     * 将原始数字除以 10，然后给反转后的数字乘上 10，所以，当原始数字小于反转后的数字时，就意味着我们已经处理了一半位数的数字。
     */
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) {
            return false
        }
        if (x < 10) {
            return true
        }
        val str = x.toString()
        for (i in 0..(str.length / 2)) {
            if (str[i] != str[str.length - 1 - i]) {
                return false
            }
        }
        return true
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(true, isPalindrome(121))
        assertEquals(false, isPalindrome(-121))
        assertEquals(false, isPalindrome(10))
    }
}