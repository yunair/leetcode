package greedy

import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * 柠檬水找零
 */
object P860LemonadeChange {
    fun lemonadeChange(bills: IntArray): Boolean {
        var remain5Count = 0
        var remain10Count = 0
        var remain20Count = 0
        for (bill in bills) {
            when (bill) {
                5 -> {
                    remain5Count++
                }
                10 -> {
                    remain10Count++
                    remain5Count--
                }
                20 -> {
                    remain5Count--
                    if (remain10Count > 0) {
                        remain10Count--
                    } else {
                        remain5Count -= 2
                    }
                    remain20Count++
                }
            }

            if (remain5Count < 0) {
                return false
            }
        }
        return true
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertTrue(lemonadeChange(intArrayOf(5, 5, 5, 10, 20)))
        assertTrue(lemonadeChange(intArrayOf(5, 5, 10)))
        assertFalse(lemonadeChange(intArrayOf(10, 10)))
        assertFalse(lemonadeChange(intArrayOf(5, 5, 10, 10, 20)))
    }
}