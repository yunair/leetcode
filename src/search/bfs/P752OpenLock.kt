package search.bfs

import java.util.*
import kotlin.test.assertEquals

object P752OpenLock {
    fun openLock(deadends: Array<String>, target: String): Int {
        val visited = mutableSetOf<String>()
        val deads = mutableSetOf<String>()
        val queue = LinkedList<String>()
        queue.add("0000")
        visited.add("0000")
        for (deadend in deadends) {
            deads.add(deadend)
        }
        var ans = 0
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val cur = queue.poll()
                if (cur == target) {
                    return ans
                }

                if (deads.contains(cur))
                    continue

                for (j in 0..3) {
                    val up = move(cur, j)
                    if (!visited.contains(up)) {
                        queue.add(up)
                        visited.add(up)
                    }
                    val down = move(cur, j, false)
                    if (!visited.contains(down)) {
                        queue.add(down)
                        visited.add(down)
                    }
                }
            }
            ans++
        }

        return -1
    }

    private fun move(str: String, i: Int, up: Boolean = true): String {
        val arr = str.toCharArray()
        arr[i] = if (up) {
            if (arr[i] == '9') {
                '0'
            } else {
                arr[i] + 1
            }
        } else {
            if (arr[i] == '0') {
                '9'
            } else {
                arr[i] - 1
            }
        }
        return String(arr)
    }


    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(6, openLock(arrayOf("0201", "0101", "0102", "1212", "2002"), "0202"))
        assertEquals(1, openLock(arrayOf("0201", "0101", "0102", "1212", "2002"), "0009"))
        assertEquals(-1, openLock(arrayOf("8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"), "8888"))
        assertEquals(-1, openLock(arrayOf("0000"), "8888"))
    }
}