package design

import kotlin.test.assertEquals

/**
 * 键值映射
 */
class P677MapSum {
    class Node(var `val`: Int) {
        val next = Array<Node?>(R) {
            null
        }
    }

    /** Initialize your data structure here. */
    private val root = Node(0)

    fun insert(key: String, `val`: Int) {
        insert(key, root, `val`, 0)
    }

    private fun insert(key: String, node: Node, `val`: Int, index: Int) {
        if (index == key.length) {
            return
        }

        val i = key[index] - 'a'
        if (node.next[i] == null) {
            node.next[i] = Node(0)
        }
        if (index == key.length - 1) {
            node.next[i]!!.`val` = `val`
        }
        insert(key, node.next[i]!!, `val`, index + 1)
    }

    fun sum(prefix: String): Int {
        return sum(prefix, root, 0)
    }

    private fun sum(prefix: String, node: Node?, index: Int): Int {
        if (node == null) {
            return 0
        }
        if (index == prefix.length) {
            return node.`val` + sum(node)
        }

        val i = prefix[index] - 'a'
        if (node.next[i] == null) {
            return 0
        }
        return sum(prefix, node.next[i], index + 1)
    }

    private fun sum(node: Node): Int {
        var ans = 0
        for (n in node.next) {
            if (n == null) {
                continue
            }
            ans += n.`val`
            val sub = sum(n)
            ans += sub
        }
        return ans
    }

    companion object {
        const val R = 26
    }
}

fun main() {
    val sum = P677MapSum()
    /*sum.insert("a", 3)
    assertEquals(0, sum.sum("ap"))
    sum.insert("b", 2)
    assertEquals(3, sum.sum("a"))*/
    sum.insert("apple", 3)
    assertEquals(3, sum.sum("app"))
    sum.insert("app", 2)
    assertEquals(5, sum.sum("app"))
    assertEquals(5, sum.sum("ap"))
}