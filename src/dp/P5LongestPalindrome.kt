package twopoint

/**
 * 最长回文子串
 */
object P5LongestPalindrome {
    fun longestPalindrome(s: String): String {
        var start = 0
        var end = 0
        for (i in s.indices) {
            // 从中间往两边找
            val len1 = findPalindrome(s, i, i)
            // 从中间和中间+1往两侧找
            val len2 = findPalindrome(s, i, i + 1)
            val len = maxOf(len1, len2)
            if (len > end - start) {
                // 偶数情况，i是靠前的那个
                start = i - (len - 1) / 2
                end = i + len / 2
            }
        }
        return s.substring(start, end + 1)
    }

    private fun findPalindrome(s: String, start: Int, end: Int): Int {
        var i = start
        var j = end
        while (i >= 0 && j < s.length && s[i] == s[j]) {
            i--
            j++
        }
        return j - i - 1
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(longestPalindrome("babad"))
        println(longestPalindrome("cbbd"))
    }
}