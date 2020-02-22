package backtrack

/**
 * 括号生成
 */
object P22GenerateParenthesis {
    val ans = mutableListOf<String>()
    fun generateParenthesis(n: Int): List<String> {
        backtrack(n, 1, 0, "(")
        return ans
    }

    private fun backtrack(n: Int, left: Int, right: Int, content: String) {
        if (left == n && right == n) {
            ans.add(content)
            return
        }

        if (left == right) {
            backtrack(n, left + 1, right, "$content(")
            return
        }
        if (left == n) {
            backtrack(n, left, right + 1, "$content)")
            return
        }
        for (i in 0..1) {
            if (i == 0) {
                backtrack(n, left + 1, right, "$content(")
            } else {
                backtrack(n, left , right + 1, "$content)")
            }
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        ans.clear()
        println(generateParenthesis(3))
    }
}