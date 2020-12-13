package greedy

import kotlin.test.assertEquals

/**
 * 单调递增的数字
 */
object P738MonotoneIncreasingDigits {
    fun monotoneIncreasingDigits(n: Int): Int {
        val s = n.toString().toCharArray()
        val len = s.size
        var flag = len
        // 从右往左遍历，找到比左边小的数，将左边的数-1，更新索引
        for (i in len - 1 downTo 1) {
            if (s[i] < s[i - 1]) {
                flag = i
                s[i-1]--
            }
        }
        // 找到左边最大值，将右侧值都设为9
        for (i in flag until len) {
            s[i] = '9'
        }
        return Integer.parseInt(s.joinToString(""))
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(9, monotoneIncreasingDigits(10))
        assertEquals(1234, monotoneIncreasingDigits(1234))
        assertEquals(1229, monotoneIncreasingDigits(1232))
        assertEquals(1499, monotoneIncreasingDigits(1543))
        assertEquals(299, monotoneIncreasingDigits(332))
        assertEquals(119, monotoneIncreasingDigits(120))
        assertEquals(899999, monotoneIncreasingDigits(999998))
        assertEquals(389999, monotoneIncreasingDigits(399443))
        assertEquals(667999, monotoneIncreasingDigits(668841))
        assertEquals(899999, monotoneIncreasingDigits(989998))
    }
}