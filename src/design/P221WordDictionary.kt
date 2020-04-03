package design

import kotlin.test.assertEquals

/**
 * 添加与搜索单词
 */
class P221WordDictionary {
    class Node(var end: Boolean = false) {
        val next = Array<Node?>(R) {
            null
        }
    }


    /** Initialize your data structure here. */
    private val root = Node()


    /** Adds a word into the data structure. */
    fun addWord(word: String) {
        insert(word, root, 0)
    }

    private fun insert(word: String, node: Node, index: Int) {
        if (index >= word.length) {
            return
        }
        val i = word[index] - 'a'
        if (node.next[i] == null) {
            node.next[i] = Node(index == word.length - 1)
        }
        if (index == word.length - 1) {
            node.next[i]!!.end = true
        }
        insert(word, node.next[i]!!, index + 1)
    }


    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    fun search(word: String): Boolean {
        return search(word, root, 0)
    }

    private fun search(word: String, node: Node?, index: Int): Boolean {
        if (node == null) {
            return false
        }

        if (index == word.length) {
            return node.end
        }

        val ch = word[index]
        if (ch == '.') {
            var match = false
            for (i in 0 until R) {
                match = match or search(word, node.next[i], index + 1)
                if (match) {
                    return true
                }
            }
            return match
        }
        if (node.next[ch - 'a'] != null) {
            return search(word, node.next[ch - 'a'], index + 1)
        }

        return false
    }

    companion object {
        const val R = 26
    }
}

fun main() {
    val wd = P221WordDictionary()
    wd.addWord("a")
    wd.addWord("a")
    assertEquals(true, wd.search(".")) // -> false
    assertEquals(true, wd.search("a")) // -> true
    assertEquals(false, wd.search("aa")) // -> true
    assertEquals(false, wd.search("a.")) // -> true

}