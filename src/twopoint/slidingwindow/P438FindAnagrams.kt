package twopoint.slidingwindow

/**
 *  找到字符串中所有字母异位词
 */
object P438FindAnagrams {
    fun findAnagrams(s: String, p: String): List<Int> {
        val n = s.length
        val res = mutableListOf<Int>()
        var left = 0
        var right = 0
        val window = mutableMapOf<Char, Int>()
        val needs = mutableMapOf<Char, Int>()
        var match = 0
        // 满足条件
        for (c in p) {
            needs[c] = needs.getOrDefault(c, 0) + 1
        }
        while (right < n) {
            val c1 = s[right]
            right++
            if (!needs.containsKey(c1)) {
                window.clear()
                left = right
                match = 0
                continue
            }
            window[c1] = window.getOrDefault(c1, 0) + 1
            match++
            // 不符合条件
            while (window[c1]!! > needs[c1]!!) {
                val c2 = s[left]
                window[c2] = window.getOrDefault(c2, 0) - 1
                left++
                match--
            }
            // 满足条件，缩减左边
            if (match == p.length) {
                res.add(left)
                window[s[left]] = window.getOrDefault(s[left], 0) - 1
                left++
                match--
            }
        }
        return res
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(findAnagrams("cbaebabacd", "abc"))
        println(findAnagrams("abab", "ab"))
        println(findAnagrams("abacbabc", "abc"))
        println(findAnagrams("baa", "aa"))
    }
}