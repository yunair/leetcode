package backtrack

import kotlin.test.assertEquals

/**
 * 第k个排列
 */
object P60PermutationSequence {
    private var count = 0
    var ans = ""
    fun getPermutation(n: Int, k: Int): String {
        count = 0
        backtrack(n, k, "", BooleanArray(n + 1))
        return ans
    }

    private fun backtrack(n: Int, k: Int, result: String, visited: BooleanArray) {
        if (result.length == n) {
            count++
            if (count == k) {
                ans = result
            }
            return
        }


        for (i in 1..n) {
            if (visited[i]) {
                continue
            }
            visited[i] = true
            backtrack(n, k, result + i, visited)
            visited[i] = false
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals("213", getPermutation(3, 3))
        assertEquals("2314", getPermutation(4, 9))
    }
}