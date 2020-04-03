package design

import kotlin.test.assertEquals

class P1286CombinationIterator(characters: String, combinationLength: Int) {
    private val ans = mutableListOf<String>()

    init {
        backtrack(characters, combinationLength, 0, "")
    }

    private fun backtrack(characters: String, length: Int, start: Int, s: String) {
        if (s.length == length) {
            ans.add(s)
            return
        }
        for (i in start until characters.length) {
            backtrack(characters, length, i + 1, s + characters[i])
        }
    }

    fun next(): String {
        return ans.removeAt(0)
    }

    fun hasNext(): Boolean {
        return ans.isNotEmpty()
    }

}

fun main() {
    val iterator = P1286CombinationIterator("abc", 2); // 创建迭代器 iterator

    assertEquals("ab", iterator.next()); // 返回 "ab"
    assertEquals(true, iterator.hasNext()); // 返回 true
    assertEquals("ac", iterator.next()) // 返回 "ac"
    assertEquals(true, iterator.hasNext()) // 返回 true
    assertEquals("bc", iterator.next()) // 返回 "bc"
    assertEquals(false, iterator.hasNext()) // 返回 false
}