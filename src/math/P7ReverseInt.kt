package math

import kotlin.test.assertEquals

/**
 * 整数反转
 */
object P7ReverseInt {
    fun reverse(x: Int): Int {
        var value = x
        var ans = 0
        while (value != 0) {
            val cur = value % 10
            val next = ans * 10 + cur
            if ((next - cur) / 10 != ans) {
                return 0
            }
            ans = next
            value /= 10
        }
        return ans
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(321, reverse(123))
        assertEquals(-321, reverse(-123))
        assertEquals(21, reverse(120))
        assertEquals(0, reverse(Int.MAX_VALUE))
        assertEquals(0, reverse(Int.MIN_VALUE))
        assertEquals(0, reverse(1534236469))
        assertEquals(-2143847412, reverse(-2147483412))
    }
}