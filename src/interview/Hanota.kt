package interview

import java.util.*

/**
 * 汉诺塔问题
 */
object Hanota {
    /**
     * n-1 从A移到B
     * 1 从A移到C
     * n-1 从B移到C
     */
    fun hanota(a: MutableList<Int>, b: MutableList<Int>, c: MutableList<Int>) {
        hanota(a.size, a, b, c)
    }

    fun hanota(n: Int, a: MutableList<Int>, b: MutableList<Int>, c: MutableList<Int>) {
        if (n == 1) {
            c.add(a.removeAt(a.size - 1))
            return
        }
        hanota(n - 1, a, c, b)
        c.add(a.removeAt(a.size - 1))
        hanota(n - 1, b, a, c)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val c1 = mutableListOf<Int>()
        hanota(mutableListOf(1, 0), mutableListOf(), c1)
        println(c1)
        val c2 = mutableListOf<Int>()
        hanota(mutableListOf(2, 1, 0), mutableListOf(), c2)
        println(c2)

        val c3 = mutableListOf<Int>()
        hanota(mutableListOf(0), mutableListOf(), c3)
        println(c3)
    }
}