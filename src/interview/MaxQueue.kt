package interview

import java.util.*
import kotlin.test.assertEquals

class MaxQueue {
    val map = TreeMap<Int, Int>()
    val queue = LinkedList<Int>()
    var max = -1
    fun max_value(): Int {
        if (queue.isEmpty()) {
            return -1
        }
        return max
    }

    fun push_back(value: Int) {
        // 存max
        if (max < value) {
            max = value
        }
        map[value] = map.getOrDefault(value, 0) + 1
        queue.add(value)
    }

    fun pop_front(): Int {
        if (queue.isEmpty()) {
            return -1
        }
        val pop = queue.pop()
        // 根据pop和max关系，更新max值
        val count = map.getOrDefault(pop, 0) - 1
        if (count > 0) {
            map[pop] = count
        } else {
            map.remove(pop)
        }
        if (pop == max && count == 0) {
            max = if (queue.isEmpty()) {
                -1
            } else {
                map.lastKey()
            }
        }

        return pop
    }
}

fun main() {
    val obj = MaxQueue()
    obj.push_back(2)
    obj.push_back(1)
    assertEquals(2, obj.max_value())
    assertEquals(2, obj.pop_front())
    assertEquals(1, obj.max_value())
}