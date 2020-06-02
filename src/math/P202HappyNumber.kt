package math

import kotlin.math.pow
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * 快乐数
 */
object P202HappyNumber {
    fun isHappy(n: Int): Boolean {
        if (n == 0) {
            return false
        }
        val set = mutableSetOf<Int>()
        var sumValue = sum(n)
        while (sumValue != 1 && !set.contains(sumValue)) {
            set.add(sumValue)
            sumValue = sum(sumValue)
        }
        return sumValue == 1
    }

    private fun sum(n: Int): Int {
        var ans = 0
        var value = n
        while (value != 0) {
            val remain = value % 10
            ans += remain * remain
            value /= 10
        }
        return ans
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertTrue(isHappy(19))
        assertFalse(isHappy(2))
    }
}