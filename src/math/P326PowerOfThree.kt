package math

import kotlin.test.assertEquals

/**
 * 3的幂
 */
object P326PowerOfThree {
    fun isPowerOfThree(n: Int): Boolean {
        if (n == 0) {
            return false
        }

        var remain = n
        while (remain % 3 == 0) {
            remain /= 3
        }
        return remain == 1
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(true, isPowerOfThree(27))
        assertEquals(true, isPowerOfThree(9))
        assertEquals(false, isPowerOfThree(0))
        assertEquals(false, isPowerOfThree(45))
        assertEquals(false, isPowerOfThree(19684))
    }
}