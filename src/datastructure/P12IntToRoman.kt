package other

import kotlin.test.assertEquals

/**
 * 整数转罗马数字
 */
object P12IntToRoman {
    /**
     */
    fun intToRoman(num: Int): String {
        val list = mutableListOf<Pair<Int, String>>()
        list.add(Pair(1000, "M"))
        list.add(Pair(900, "CM"))
        list.add(Pair(500, "D"))
        list.add(Pair(400, "CD"))
        list.add(Pair(100, "C"))
        list.add(Pair(90, "XC"))
        list.add(Pair(50, "L"))
        list.add(Pair(40, "XL"))
        list.add(Pair(10, "X"))
        list.add(Pair(9, "IX"))
        list.add(Pair(5, "V"))
        list.add(Pair(4, "IV"))
        list.add(Pair(1, "I"))


        if (num == 0) {
            return ""
        }
        var number = num
        var ans = ""
        for (item in list) {
            if (number >= item.first) {
                val count = number / item.first
                for (i in 1..count) {
                    ans += item.second
                }
                number %= item.first
            }
        }
        return ans
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals("III", intToRoman(3))
        assertEquals("IV", intToRoman(4))
        assertEquals("IX", intToRoman(9))
        assertEquals("LVIII", intToRoman(58))
        assertEquals("MCMXCIV", intToRoman(1994))
    }
}