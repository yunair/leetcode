package other.bfs

import java.util.*
import kotlin.collections.HashSet
import kotlin.test.assertEquals

/**
 * 单词接龙
 */
object P127WordLadder {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        if (!wordList.contains(endWord)) {
            return 0
        }

        val queue = LinkedList<String>()
        queue.add(beginWord)
        // use int instead
//        val visited = mutableSetOf<String>()
        val visited = BooleanArray(wordList.size + 1)
        var count = 0
        while (queue.isNotEmpty()) {
            val size = queue.size
            count++
            for (i in 0 until size) {
                val curWord = queue.poll()
                for ((j, word) in wordList.withIndex()) {
                    if (visited[j]) {
                        continue
                    }
                    if (canTrans(curWord, word)) {
                        if (word == endWord) {
                            return count + 1
                        }
                        queue.add(word)
                        visited[j] = true
                    }
                }
            }
        }
        return 0
    }

    private fun canTrans(beginWord: String, word: String): Boolean {
        var difCount = 0
        for ((i, bw) in beginWord.withIndex()) {
            if (word[i] != bw) {
                difCount++
            }
        }
        return difCount == 1
    }

    fun ladderLengthMultiBFS(beginWord: String, endWord: String, wordList: List<String>): Int {
        if (!wordList.contains(endWord)) {
            return 0
        }
        var queue1 = LinkedList<String>()
        queue1.add(beginWord)
        var queue2 = LinkedList<String>()
        queue2.add(endWord)
        var visitedStart = mutableSetOf<String>()
        var visitedEnd = mutableSetOf<String>()
        visitedStart.add(beginWord)
        visitedEnd.add(endWord)
        var count = 0
        val allWordSet = HashSet<String>(wordList)

        while (queue1.isNotEmpty() && queue2.isNotEmpty()) {
            count++

            // 交换两者，从节点更少的一端遍历
            if (queue1.size > queue2.size) {
                val tmpQ = queue1
                queue1 = queue2
                queue2 = tmpQ
                val tmpV = visitedStart
                visitedStart = visitedEnd
                visitedEnd = tmpV
            }

            val size1 = queue1.size

            for (i in 0 until size1) {
                val curWord = queue1.poll()
                // 让字母变，看能不能变成最终的
                val arr = curWord.toCharArray()
                for (j in curWord.indices) {
                    val oriC = arr[j]
                    for (c in 'a'..'z') {
                        arr[j] = c
                        val str = String(arr)
                        if (visitedStart.contains(str)) {
                            continue
                        }
                        if (visitedEnd.contains(str)) {
                            return count+1
                        }
                        if (allWordSet.contains(str)) {
                            queue1.add(str)
                            visitedStart.add(str)
                        }
                    }
                    // 恢复第j位的原始字符
                    arr[j] = oriC
                }
                /*for ((j, word) in wordList.withIndex()) {
                    if (visitedStart.contains(j)) {
                        continue
                    }
                    if (canTrans(curWord, word)) {
                        if (visitedEnd.contains(j)) {
                            return count + 1
                        }
                        queue1.add(word)
                        visitedStart.add(j)
                    }
                }*/
            }
        }
        return 0
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(5, ladderLengthMultiBFS("hit", "cog", listOf("hot", "dot", "dog", "lot", "log", "cog")))
        assertEquals(0, ladderLengthMultiBFS("hit", "cog", listOf("hot", "dot", "dog", "lot", "log")))
        assertEquals(2, ladderLengthMultiBFS("a", "c", listOf("a", "b", "c")))
    }
}