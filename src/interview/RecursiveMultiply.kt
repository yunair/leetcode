package interview

import kotlin.test.assertEquals

/**
 * 递归乘法
 */
object RecursiveMultiply {
    fun multiply(a: Int, b: Int): Int {
        if (a == 1) {
            return b
        }
        if (b == 1) {
            return a
        }
        var ans = 0
        ans += if (a > b) {
            a + multiply(a, b - 1)
        } else {
            b + multiply(b, a - 1)
        }
        return ans
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(10, multiply(1, 10))
        assertEquals(12, multiply(3, 4))
    }
}