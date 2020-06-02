package design

import kotlin.test.assertEquals

/**
 * 实现 Trie (前缀树)
 */

class Trie(var end: Boolean = false) {
    companion object {
        const val R = 26
    }

    private val next = Array<Trie?>(R) { null }

    /** Initialize your data structure here. */

    /** Inserts a word into the trie. */
    fun insert(word: String) {
        insert(word, this, 0)
    }

    private fun insert(word: String, node: Trie, index: Int) {
        if (index >= word.length) {
            return
        }
        val i = word[index] - 'a'
        if (node.next[i] == null) {
            node.next[i] = Trie(index == word.length - 1)
        }
        if (index == word.length - 1) {
            node.next[i]!!.end = true
        }
        insert(word, node.next[i]!!, index + 1)
    }


    /** Returns if the word is in the trie. */
    fun search(word: String): Boolean {
        return search(word, this, false, 0)
    }

    private fun search(word: String, node: Trie?, prefix: Boolean, index: Int): Boolean {
        if (node == null) {
            return false
        }

        if (index == word.length) {
            return if (prefix) true else node.end
        }


        val i = word[index] - 'a'
        if (node.next[i] == null) {
            return false
        }

        return search(word, node.next[i], prefix, index + 1)
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    fun startsWith(prefix: String): Boolean {
        return search(prefix, this, true, 0)
    }

}

fun main() {
    val trie = Trie()
    trie.insert("apple");
    assertEquals(true, trie.search("apple"));   // 返回 true
    assertEquals(false, trie.search("app"));   // 返回 false
    assertEquals(true, trie.startsWith("app")); // 返回 true
    trie.insert("app");
    assertEquals(true, trie.search("app"));     // 返回 true
}