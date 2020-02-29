package math

import kotlin.test.assertEquals

/**
 * Pow(x, n)
 */
object P50Pow {
    fun myPow(x: Double, n: Int): Double {
        if (x == 0.0) {
            return 0.0
        }
        if (n == 0) {
            return 1.0
        }
        val flag = n < 0
        return if (flag) {
            1 / fastPow(x, -n)
        } else {
            fastPow(x, n)
        }
    }

    fun fastPow(x: Double, n: Int): Double {
        if (n == 0) {
            return 1.0
        }
        if (n == 1) {
            return x
        }
        return if (n % 2 == 0) {
            x * x * fastPow(x * x, (n - 1) / 2)
        } else {
            x * x * x * fastPow(x * x, (n - 3) / 2)
        }
    }

    /**
     * 二分思想递归
     */
    fun myPowBinary(x: Double, n: Int): Double {
        if (n == 0) {
            return 1.0
        }
        if (n == 1) {
            return x
        }
        if (n == -1) {
            return 1 / x
        }

        val half = myPowBinary(x, n / 2)
        val rest = myPowBinary(x, n % 2)
        return half * half * rest

    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(1024.00000, myPow(2.00000, 10))
        assertEquals(0.25000, myPow(2.00000, -2))
        assertEquals(128.0, myPow(2.00000, 7))
        assertEquals(128.0, myPow(2.00000, 7))
    }
}