package other

import java.lang.StringBuilder

/**
 * 字母异位词分组
 */
object P49GroupAnagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val ans = mutableListOf<MutableList<String>>()
        if (strs.isEmpty()) {
            return ans
        }
        val visited = BooleanArray(strs.size)

        while (hasMore(visited)) {
            val cache = mutableMapOf<Char, Int>()
            var start = false
            val list = mutableListOf<String>()
            for ((i, str) in strs.withIndex()) {
                if (visited[i]) {
                    continue
                }
                if (!start) {
                    visited[i] = true
                    start = true
                    for (c in str) {
                        cache[c] = cache.getOrDefault(c, 0) + 1
                    }
                    list.add(str)
                } else {
                    if (str.length != list[0].length) {
                        continue
                    }
                    // 检测是否和cache一致
                    val clone = HashMap(cache)
                    for (c in str) {
                        clone[c] = clone.getOrDefault(c, 0) - 1
                    }
                    var same = true
                    for (entry in clone.entries) {
                        if (entry.value != 0) {
                            same = false
                            break
                        }
                    }
                    if (same) {
                        visited[i] = true
                        list.add(str)
                    }

                }
            }
            cache.clear()
            ans.add(list)
        }

        return ans
    }

    private fun hasMore(visited: BooleanArray): Boolean {
        for (visit in visited) {
            if (!visit) {
                return true
            }
        }
        return false
    }

    /**
     * 当且仅当它们的字符计数（每个字符的出现次数）相同时，两个字符串是字母异位词。
     */
    fun groupAnagramsEasy(strs: Array<String>): List<List<String>> {
        val ans = mutableListOf<MutableList<String>>()
        if (strs.isEmpty()) {
            return ans
        }
        val map = mutableMapOf<String, MutableList<String>>()
        for (str in strs) {
            val arr = IntArray(26)
            for (c in str) {
                arr[c - 'a']++
            }
            // 将该26个字母组成唯一的key
            val keySb = StringBuilder()
            for (i in arr.indices) {
                keySb.append(arr[i]).append("@")
            }
            val key = keySb.toString()
            val list = map.getOrDefault(key, mutableListOf())
            list.add(str)
            map[key] = list
        }
        for (entry in map.entries) {
            ans.add(entry.value)
        }
        return ans
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(groupAnagramsEasy(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")))
    }
}