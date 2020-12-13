package greedy

/**
 * 划分字母区间
 */
object P763PartitionLabels {
    fun partitionLabels(s: String): List<Int> {
        val ans = mutableListOf<Int>()
        val map = mutableMapOf<Char, Int/*最后索引位置*/>()
        var start = 0
        while (start < s.length) {
            map[s[start]] = start
            var next = start
            for (i in start until s.length) {
                if (map.containsKey(s[i])) {
                    for (j in next..i) {
                        map[s[j]] = j
                        next = j
                    }
                }
            }
            ans.add(next + 1 - start)
            start = next + 1
            map.clear()
        }

        return ans
    }

    fun partitionLabelsBetter(s: String): List<Int> {
        val ans = mutableListOf<Int>()
        // 找出每个字符出现的最后位置
        val last = IntArray(26)
        for ((i, c) in s.withIndex()) {
            last[c - 'a'] = i
        }
        var j = 0
        var anchor = 0
        for (i in s.indices) {
            // 当前字符是不是该最后位置
            j = maxOf(j, last[s[i] - 'a'])
            if (i == j) {
                ans.add(i - anchor + 1)
                anchor = i + 1
            }
        }

        return ans
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(partitionLabels("ababcbacadefegdehijhklij"))
        println(partitionLabels("abaccbdeffed"))
    }
}