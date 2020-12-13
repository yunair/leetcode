package interview

import kotlin.test.assertEquals

/**
 * 圆圈中最后剩下的数字
 */
object LastRemainInCircle {
    fun lastRemaining(n: Int, m: Int): Int {
        val list = mutableListOf<Int>()
        (0 until n).forEach {
            list.add(it)
        }
        var startIndex = 0
        while (list.size > 1) {
            val removeIndex = (startIndex + m - 1) % list.size
            list.removeAt(removeIndex)
            startIndex = removeIndex
        }

        return list[0]
    }

    fun lastRemainingRecur(n: Int, m: Int): Int {
        return f(n, m)
    }

    /**
     * 长度为 n 的序列会先删除第 m % n 个元素，然后剩下一个长度为 n - 1 的序列。
     * 那么，我们可以递归地求解 f(n - 1, m)，
     * 就可以知道对于剩下的 n - 1 个元素，最终会留下第几个元素，
     * 我们设答案为 x = f(n - 1, m)。
     *
     *
     * 由于我们删除了第 m % n 个元素，将序列的长度变为 n - 1。
     * 当我们知道了 f(n - 1, m) 对应的答案 x 之后，
     * 我们也就可以知道，长度为 n 的序列最后一个删除的元素，应当是从 m % n 开始数的第 x 个元素。
     * 因此有 f(n, m) = (m % n + x) % n = (m + x) % n。
     */
    private fun f(n: Int, m: Int): Int {
        if (n == 1) {
            return 0
        }
        val x = f(n - 1, m)
        return (m + x) % n
    }


    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(3, lastRemaining(5, 3))
        assertEquals(2, lastRemaining(10, 17))
    }

}