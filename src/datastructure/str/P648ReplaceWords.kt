package datastructure.str

import kotlin.test.assertEquals

/**
 * 单词替换
 */
object P648ReplaceWords {
    fun replaceWords(dict: List<String>, sentence: String): String {
        val words = sentence.split(" ").toMutableList()
        for (i in words.indices) {
            val word = words[i]
            for (root in dict) {
                if (word.startsWith(root)) {
                    words[i] = root
                    break
                }
            }
        }
        return words.joinToString(" ")
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals("the cat was rat by the bat",
            replaceWords(
                listOf("cat", "bat", "rat"),
                "the cattle was rattled by the battery"
            )
        )
    }
}