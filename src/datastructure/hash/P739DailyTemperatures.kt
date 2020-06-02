package other.hash

import java.util.*

/**
 * 每日温度
 */
object P739DailyTemperatures {
    fun dailyTemperatures(t: IntArray): IntArray {
        val stack = LinkedList<Int/*index*/>()
        val arr = IntArray(t.size)
        for (i in t.indices) {
            val v = t[i]
            while (stack.isNotEmpty() && v > t[stack.peek()]) {
                val pop = stack.pop()
                arr[pop] = i - pop
            }
            stack.push(i)
        }
        return arr
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(dailyTemperatures(intArrayOf(89, 62, 70, 58, 47, 47, 46, 76, 100, 70)).contentToString())
    }
}