package datastructure

import kotlin.test.assertEquals

/**
 * 罗马数字转整数
 */
object P13RomanToInt {
    val map = mutableMapOf<String, Int>()

    /**
     * 更好的思路： "把小值放在大值左边就做减法， 否则做加法"
     */
    fun romanToInt(s: String): Int {
        map["I"] = 1
        map["V"] = 5
        map["X"] = 10
        map["L"] = 50
        map["C"] = 100
        map["D"] = 500
        map["M"] = 1000
        map["IV"] = 4
        map["IX"] = 9
        map["XL"] = 40
        map["XC"] = 90
        map["CD"] = 400
        map["CM"] = 900

        if (s.isEmpty()) {
            return 0
        }
        var i = 0
        var ans = 0
        while (i < s.length) {
            if (i == s.length - 1) {
                ans += map[s[i].toString()]!!
                break
            }

            when {
                s[i] == 'I' -> {
                    when {
                        s[i + 1] == 'V' -> {
                            ans += map["IV"]!!
                            i++
                        }
                        s[i + 1] == 'X' -> {
                            ans += map["IX"]!!
                            i++
                        }
                        else -> {
                            ans += map["I"]!!
                        }
                    }
                }
                s[i] == 'X' -> {
                    when {
                        s[i + 1] == 'L' -> {
                            ans += map["XL"]!!
                            i++
                        }
                        s[i + 1] == 'C' -> {
                            ans += map["XC"]!!
                            i++
                        }
                        else -> {
                            ans += map["X"]!!
                        }
                    }
                }
                s[i] == 'C' -> {
                    when {
                        s[i + 1] == 'D' -> {
                            ans += map["CD"]!!
                            i++
                        }
                        s[i + 1] == 'M' -> {
                            ans += map["CM"]!!
                            i++
                        }
                        else -> {
                            ans += map["C"]!!
                        }
                    }
                }
                else -> {
                    ans += map[s[i].toString()]!!
                }
            }
            i++
        }
        return ans
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(1994, romanToInt("MCMXCIV"))
        assertEquals(58, romanToInt("LVIII"))
        assertEquals(9, romanToInt("IX"))
        assertEquals(3, romanToInt("III"))
    }
}