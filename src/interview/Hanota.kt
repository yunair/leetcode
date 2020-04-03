package interview

import java.util.*

/**
 * 汉诺塔问题
 */
internal class Hanota {
    /**
     * n-1 从A移到B
     * 1 从A移到C
     * n-1 从B移到C
     */
    fun hanota(a: IntArray, b: IntArray, c: IntArray) {
        hanota(a.size - 1, a, b, c)
    }

    fun hanota(n: Int, a: IntArray, b: IntArray, c: IntArray) {
        if (n <= 0) {
            return
        }
        hanota(n - 1, a, c, b)
        c[n - 1] = a[n - 1]
        hanota(n - 1, b, a, c)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val hanota = Hanota()
            val a = intArrayOf(1, 0)
            val b = intArrayOf(0, 0)
            val c = intArrayOf(0, 0)
            hanota.hanota(a, b, c)
            println(Arrays.toString(c))
            val a1 = intArrayOf(2, 1, 0)
            val b1 = intArrayOf(0, 0, 0)
            val c1 = intArrayOf(0, 0, 0)
            hanota.hanota(a1, b1, c1)
            println(Arrays.toString(c1))
        }
    }
}