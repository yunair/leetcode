package datastructure.array

/**
 * 加一
 */
object P66PlusOne {
    fun plusOne(digits: IntArray): IntArray {
        for (i in (digits.size - 1) downTo 0) {
            digits[i]++
            digits[i] %= 10
            if (digits[i] != 0) {
                return digits
            }
        }
        // 最后一位进位
        val ans = IntArray(digits.size + 1)
        // 一定会是1后面跟digits.size个0
        ans[0] = 1
        return ans
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(plusOne(intArrayOf(9)).contentToString())
    }
}