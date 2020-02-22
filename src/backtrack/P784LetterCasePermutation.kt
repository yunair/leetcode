package backtrack

/**
 * 字母大小写全排列
 */
object P784LetterCasePermutation {
    val ans = mutableListOf<String>()
    fun letterCasePermutation(S: String): List<String> {
        ans.clear()
        ans.add(S)
        backtrack(S, 0)
        return ans
    }

    private fun backtrack(S: String, start: Int) {
        if (start == S.length) {
            return
        }
        for (i in start until S.length) {
            val c = S[i]
            if (c.toUpperCase() != c) {
                val replaced = S.replaceRange(i, i + 1, c.toUpperCase().toString())
                ans.add(replaced)
                backtrack(replaced, i + 1)
            }
            if (c.toLowerCase() != c) {
                val replaced = S.replaceRange(i, i + 1, c.toLowerCase().toString())
                ans.add(replaced)
                backtrack(replaced, i + 1)
            }
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(letterCasePermutation("a1b2"))
        ans.clear()
        println(letterCasePermutation("3z4"))
        ans.clear()
        println(letterCasePermutation("12345"))
        ans.clear()
        println(letterCasePermutation("a1b2c3"))
        ans.clear()
        println(letterCasePermutation("C"))
    }
}