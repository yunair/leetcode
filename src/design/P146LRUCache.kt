package design

import kotlin.test.assertEquals

/**
 * LRU缓存机制
 *
 * LinkedHashMap的实现
 */
class P146LRUCache(capacity: Int) {
    private val cap = capacity


    val list = mutableListOf<Int>()
    private val map = linkedMapOf<Int, Int>()

    fun get(key: Int): Int {
        val ans = map.getOrDefault(key, -1)
        if (ans != -1) {
            // 访问过就放最前面
            list.remove(key)
            list.add(0, key)
        }
        return ans
    }

    fun put(key: Int, value: Int) {
        // 存在 key，更新即可
        if (map.containsKey(key)) {
            map[key] = value
            list.remove(key)
            list.add(0, key)
            return
        }
        // 不存在，删除不常用的那个
        if (list.size == cap) {
            val delKey = list.removeAt(list.size - 1)
            map.remove(delKey)
        }
        list.add(0, key)
        map[key] = value
    }

}

fun main() {
    val cache = P146LRUCache(2)
    cache.put(1, 1);
    cache.put(2, 2);
    assertEquals(1, cache.get(1));       // 返回  1
    cache.put(3, 3);    // 该操作会使得密钥 2 作废
    assertEquals(-1, cache.get(2))       // 返回 -1 (未找到)
    cache.put(4, 4);    // 该操作会使得密钥 1 作废
    assertEquals(-1, cache.get(1))       // 返回 -1 (未找到)
    assertEquals(3, cache.get(3))       // 返回  3
    assertEquals(4, cache.get(4))       // 返回  4

}