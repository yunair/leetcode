package contest

import java.time.LocalDate
import java.time.temporal.ChronoUnit
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.abs
import kotlin.math.sqrt
import kotlin.test.assertEquals

object Weekly177 {

    /**
     * 请你编写一个程序来计算两个日期之间隔了多少天。
     * 日期以字符串形式给出，格式为 YYYY-MM-DD，如示例所示。
     */
    fun daysBetweenDates(date1: String, date2: String): Int {
        val d1 = LocalDate.parse(date1)
        val d2 = LocalDate.parse(date2)
        return abs(d1.until(d2, ChronoUnit.DAYS).toInt())
    }

    /**
     * Title: 验证二叉树
     *
     * Desc: 二叉树上有 n 个节点，按从 0 到 n - 1 编号，其中节点 i 的两个子节点分别是 leftChild[i] 和 rightChild[i]。
     * 只有 所有 节点能够形成且 只 形成 一颗 有效的二叉树时，返回 true；否则返回 false。
     * 如果节点 i 没有左子节点，那么 leftChild[i] 就等于 -1。右子节点也符合该规则。
     * 注意：节点没有值，本问题中仅仅使用节点编号。
     */
    fun validateBinaryTreeNodes(n: Int, leftChild: IntArray, rightChild: IntArray): Boolean {
        val set = mutableSetOf<Int>()
        set.add(0)
        for (i in 0 until n) {
            if (!set.contains(i)) {
                // 没有父节点
                return false
            }
            val left = leftChild[i]
            val right = rightChild[i]
            if (set.contains(left) || set.contains(right)) {
                // 左右节点之前已存在
                return false
            }
            if (left != -1) {
                set.add(left)
            }

            if (right != -1) {
                set.add(right)
            }
            set.add(i)
        }
        return true
    }


    /**
     * Title: 最接近的因数
     *
     * Desc: 给你一个整数 num，请你找出同时满足下面全部要求的两个整数：
     *  两数乘积等于  num + 1 或 num + 2
     *  以绝对差进行度量，两数大小最接近
     *
     * 你可以按任意顺序返回这两个整数。
     */
    fun closestDivisors(num: Int): IntArray {
        // 能开根号，肯定最小
        val num1 = sqrt((num + 1).toDouble()).toInt()
        if (num1 * num1 == (num + 1)) {
            return intArrayOf(num1, num1)
        }

        val num2 = sqrt((num + 2).toDouble()).toInt()
        if (num2 * num2 == (num + 2)) {
            return intArrayOf(num2, num2)
        }

        // 不能开，计算两者
        val ans1 = IntArray(2)
        var minus1 = Int.MAX_VALUE
        for (i in num1 downTo 1) {
            if ((num + 1) % i == 0) {
                ans1[0] = i
                ans1[1] = (num + 1) / i
                minus1 = minOf(ans1[1] - ans1[0], minus1)
                break
            }
        }

        val ans2 = IntArray(2)
        var minus2 = Int.MAX_VALUE
        for (i in num2 downTo 1) {
            if ((num + 2) % i == 0) {
                ans2[0] = i
                ans2[1] = (num + 2) / i
                minus2 = minOf(ans2[1] - ans2[0], minus2)
                break
            }
        }

        return if (minus1 > minus2) {
            ans2
        } else {
            ans1
        }
    }

    /**
     * Title: 形成三的最大倍数
     *
     * Desc: 给你一个整数数组 digits，你可以通过按任意顺序连接其中某些数字来形成 3 的倍数，请你返回所能得到的最大的 3 的倍数。
     * 由于答案可能不在整数数据类型范围内，请以字符串形式返回答案。
     * 如果无法得到答案，请返回一个空字符串。。
     */
    val ans = mutableListOf<List<Int>>()

    fun largestMultipleOfThree(digits: IntArray): String {
        ans.clear()
        digits.sortDescending()
        backtrack(digits, 0, ArrayDeque())
        if (ans.isEmpty()) {
            return ""
        }
        var max = ans[0].size
        var result = ans[0]
        for (list in ans) {
            if (list.size > max) {
                max = list.size
                result = list
            }
        }

        return result.joinToString("")
    }

    private fun backtrack(digits: IntArray, start: Int, tracker: Deque<Int>) {
        if (tracker.isNotEmpty() && tracker.sum() % 3 == 0) {
            if (tracker.sum() == 0) {
                ans.add(arrayListOf(0))
            } else {
                ans.add(ArrayList(tracker))
            }
        }
        if (start == digits.size) {
            return
        }
        for (i in start until digits.size) {
            tracker.add(digits[i])
            backtrack(digits, i + 1, tracker)
            tracker.removeLast()
        }
    }


    @JvmStatic
    fun main(args: Array<String>) {
        /*assertEquals(1, daysBetweenDates("2019-06-29", "2019-06-30"))
        assertEquals(15, daysBetweenDates("2020-01-15", "2019-12-31"))
        assertEquals(14331, daysBetweenDates("1971-06-29", "2010-09-23"))
*/
        /* assertEquals(true, validateBinaryTreeNodes(4, intArrayOf(1, -1, 3, -1), intArrayOf(2, -1, -1, -1)))
         assertEquals(false, validateBinaryTreeNodes(4, intArrayOf(1, -1, 3, -1), intArrayOf(2, 3, -1, -1)))
         assertEquals(false, validateBinaryTreeNodes(2, intArrayOf(1, 0), intArrayOf(-1, -1)))
         assertEquals(
             false,
             validateBinaryTreeNodes(6, intArrayOf(1, -1, -1, 4, -1, -1), intArrayOf(2, -1, -1, 5, -1, -1))
         )*/

//        println(closestDivisors(8).contentToString())
//        println(closestDivisors(123).contentToString())
//        println(closestDivisors(999).contentToString())

        /*assertEquals("8760", largestMultipleOfThree(intArrayOf(8, 6, 7, 1, 0)))
        assertEquals("981", largestMultipleOfThree(intArrayOf(8, 1, 9)))
        assertEquals("", largestMultipleOfThree(intArrayOf(1)))
        assertEquals("0", largestMultipleOfThree(intArrayOf(0, 0, 0, 0, 0, 0)))*/
        assertEquals("111", largestMultipleOfThree(intArrayOf(1, 1, 1, 2)))
        assertEquals("874431000", largestMultipleOfThree(intArrayOf(7, 1, 2, 4, 0, 0, 4, 0, 3, 8)))
    }
}

