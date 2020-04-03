package design

class P676MagicDictionary {
    /** Initialize your data structure here. */
    private val sizeMap = mutableMapOf<Int, MutableSet<String>>()

    /** Build a dictionary through a list of words */
    fun buildDict(dict: Array<String>) {
        for (s in dict) {
            val set = sizeMap.getOrDefault(s.length, mutableSetOf())
            set.add(s)
            sizeMap[s.length] = set
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    fun search(word: String): Boolean {
        if (!sizeMap.containsKey(word.length)) {
            return false
        }

        val dict = sizeMap[word.length]!!
        for (item in dict) {
            var count = 0
            for (i in word.indices) {
                if (word[i] != item[i]) {
                    count++
                }
            }
            if (count == 1) {
                return true
            }
        }
        return false
    }
}