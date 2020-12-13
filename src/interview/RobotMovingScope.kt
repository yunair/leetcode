package interview

import java.util.*
import kotlin.test.assertEquals

/**
 * 机器人的运动范围
 */
object RobotMovingScope {
    fun movingCount(m: Int, n: Int, k: Int): Int {
        if (k == 0) {
            return 1
        }
        var ans = 0
        // 因为不能回头，所以一定是向右或者向下走
        val dirsX = intArrayOf(1, 0)
        val dirsY = intArrayOf(0, 1)
        val visited = Array(m) { BooleanArray(n) }
        val queue = LinkedList<Pair<Int/*x*/, Int/*y*/>>()
        queue.addLast(Pair(0, 0))
        visited[0][0] = true
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 1..size) {
                val loc = queue.poll()
                ans++
                for (j in dirsX.indices) {
                    val newX = loc.first + dirsX[j]
                    val newY = loc.second + dirsY[j]
                    if (newX < 0 || newX >= m || newY < 0 || newY >= n || sumDir(newX) + sumDir(newY) > k || visited[newX][newY]) {
                        continue
                    }

                    visited[newX][newY] = true
                    queue.addLast(Pair(newX, newY))
                }
            }
        }

        return ans
    }

    private fun sumDir(dir: Int): Int {
        var count = 0
        var innerdir = dir
        while (innerdir > 0) {
            count += innerdir % 10
            innerdir /= 10
        }
        return count
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(3, movingCount(2, 3, 1))
        assertEquals(1, movingCount(3, 1, 0))
        assertEquals(2, movingCount(1, 2, 1))
        assertEquals(6, movingCount(3, 2, 17))
        assertEquals(88, movingCount(11, 8, 16))
    }
}