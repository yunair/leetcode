package design

import java.util.*
import kotlin.collections.HashMap
import kotlin.test.assertEquals

/**
 * LFU缓存
 */
class Node(val key: Int, val value: Int, val freq: Int = 1) : Comparable<Node> {
    private val idx = System.nanoTime()


    override fun compareTo(other: Node): Int {
        if (this.freq == other.freq) {
            return this.idx.compareTo(other.idx)
        }
        return this.freq.compareTo(other.freq)
    }
}

class LFUCache(private val capacity: Int) {
    private val map = HashMap<Int, Node>(capacity)
    private val minQueue = PriorityQueue<Node>()

    fun get(key: Int): Int {
        val node = map[key] ?: return -1
        minQueue.remove(node)
        minQueue.add(Node(key, node.value, node.freq + 1))
        return node.value
    }

    fun put(key: Int, value: Int) {
        if (capacity == 0) {
            return
        }
        val node = map[key]
        if (node != null) {
            minQueue.remove(node)
            map[key] = Node(key, value, node.freq + 1)
        } else {
            if (map.size == capacity) {
                val removed = minQueue.remove()
                map.remove(removed.key)
            }
            map[key] = Node(key, value)
        }
        minQueue.add(map[key])
    }
}

fun main() {
    val cache = LFUCache(3)
    cache.put(1, 1)
    cache.put(2, 2)
    cache.put(3, 3)
    cache.put(4, 4)
    assertEquals(4, cache.get(4));
    assertEquals(3, cache.get(3));
    assertEquals(2, cache.get(2));
    assertEquals(-1, cache.get(1));
    cache.put(5, 5)
    assertEquals(-1, cache.get(1));
    assertEquals(2, cache.get(2));
    assertEquals(3, cache.get(3));
    assertEquals(-1, cache.get(4));
    assertEquals(5, cache.get(5));
}