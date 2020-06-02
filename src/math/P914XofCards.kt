package math

import java.util.*
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * 卡牌分组
 */
object P914XofCards {
    fun hasGroupsSizeX(deck: IntArray): Boolean {
        val map = mutableMapOf<Int, Int>()
        var max = 0
        for (num in deck) {
            val value = map.getOrDefault(num, 0) + 1
            max = maxOf(value, max)
            map[num] = value
        }
        var res = false
        for (i in 2..max) {
            var confirm = true
            for (entry in map) {
                if (entry.value < i) {
                    confirm = false
                    break
                }
                if (entry.value % i != 0) {
                    confirm = false
                    break
                }
            }
            if (confirm) {
                res = true
                break
            }
        }

        return res
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertTrue(hasGroupsSizeX(intArrayOf(1, 2, 3, 4, 4, 3, 2, 1)))
        assertTrue(hasGroupsSizeX(intArrayOf(1, 1)))
        assertTrue(hasGroupsSizeX(intArrayOf(1, 1, 2, 2, 2, 2)))
        assertTrue(hasGroupsSizeX(intArrayOf(1, 1, 1, 1, 2, 2, 2, 2, 2, 2)))
        assertFalse(hasGroupsSizeX(intArrayOf(1, 1, 1, 2, 2, 2, 3, 3)))
        assertFalse(hasGroupsSizeX(intArrayOf(1)))
    }
}