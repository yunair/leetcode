package design

import java.util.*
import kotlin.collections.LinkedHashSet
import kotlin.test.assertEquals

class FirstUnique(nums: IntArray) {
    val map = mutableMapOf<Int, Int>()
    val list = LinkedHashSet<Int>()

    init {
        for (num in nums) {
            val count = map.getOrDefault(num, 0) + 1
            map[num] = count
            if (count == 1) {
                list.add(num)
            } else {
                list.remove(num)
            }
        }
    }

    fun showFirstUnique(): Int {
        if (list.isEmpty()) {
            return -1
        }
        return list.first()
    }

    fun add(value: Int) {
        val count = map.getOrDefault(value, 0) + 1
        map[value] = count
        if (count == 1) {
            list.add(value)
        } else {
            list.remove(value)
        }
    }

}

fun main() {
    val obj = FirstUnique(intArrayOf(1, 2, 3))
    assertEquals(1, obj.showFirstUnique())
    obj.add(2)
    assertEquals(1, obj.showFirstUnique())
    obj.add(1)
    assertEquals(3, obj.showFirstUnique())
    obj.add(3)
    assertEquals(-1, obj.showFirstUnique())
}