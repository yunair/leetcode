package design

import kotlin.random.Random
import kotlin.test.assertEquals

/**
 * 常数时间插入、删除和获取随机元素
 */
class P380RandomizedSet {
    /**
     * 用set无法在常数时间获取随机元素
     *
     * 可以用list和map组合，删除的时候每次都将要删除的数和最后一个数互换，每次都删除最后一个元素
     *
     * 还可以用两个hashmap，一个<index,value>，一个<value, index>，模拟list, 删除也要处理index问题
     */
    /** Initialize your data structure here. */
    private val list = mutableListOf<Int>()
    private val map = mutableMapOf<Int, Int/*index in list*/>()

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    fun insert(`val`: Int): Boolean {
        if (map.contains(`val`)) {
            return false
        }
        list.add(`val`)
        map[`val`] = list.size - 1
        return true
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    fun remove(`val`: Int): Boolean {
        if (map.contains(`val`)) {
            val index = map[`val`]!!
            // 将当前值和最后一个值交换
            val last = list[list.size - 1]
            list[index] = last
            map[last] = index
            map.remove(`val`)
            list.removeAt(list.size - 1)
            return true
        }
        return false
    }

    /** Get a random element from the set. */
    fun getRandom(): Int {
        val ran = Random.nextInt(list.size)
        return list[ran]
    }
}

fun main() {
    val obj = P380RandomizedSet()
    assertEquals(false, obj.remove(0))
    assertEquals(false, obj.remove(0))
    assertEquals(true, obj.insert(0))
    assertEquals(0, obj.getRandom())
    assertEquals(true, obj.remove(0))
    assertEquals(true, obj.insert(0))
    /*assertEquals(true, obj.insert(1))
    assertEquals(false, obj.remove(2))
    assertEquals(true, obj.insert(2))
    println(obj.getRandom())
    assertEquals(true, obj.remove(1))
    assertEquals(false, obj.insert(2))
    assertEquals(2, obj.getRandom())*/
}