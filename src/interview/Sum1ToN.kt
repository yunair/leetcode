package interview

import kotlin.test.assertEquals

/**
 * 求1+2+…+n
 */
object Sum1ToN {
    fun sumNums(n: Int): Int {
        var sum = n
        n > 0 && (sum + sumNums(n - 1)).apply {
            sum = this
        } > 0
        return sum
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(6, sumNums(3))
        assertEquals(45, sumNums(9))
    }
}