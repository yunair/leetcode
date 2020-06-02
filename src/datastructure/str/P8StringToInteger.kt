package other.str

import java.lang.StringBuilder
import kotlin.test.assertEquals

/**
 * 字符串转换整数 (atoi)
 */
object P8StringToInteger {
    fun myAtoi(str: String): Int {
        if (str.isEmpty()) {
            return 0
        }
        var i = 0
        val n = str.length
        // 去除前面空格
        while (i < n && str[i] == ' ') {
            i++
        }
        if (i == n) {
            return 0
        }
        // 去除正负号
        var sign = 1
        if (str[i] == '-') {
            sign = -1
            i++
        } else if (str[i] == '+') {
            i++
        }

        var res = 0
        while (i < n) {
            val curChar = str[i]
            // 去除非数字
            if (curChar > '9' || curChar < '0') {
                break
            }
            val curValue = curChar - '0'
            i++
            // 最大值
            if (sign == 1 && (res > Int.MAX_VALUE / 10 || (res == Int.MAX_VALUE / 10 && curValue > 7))) {
                return Int.MAX_VALUE
            }
            // 最小值
            if (sign == -1 && (res < Int.MIN_VALUE / 10 || (res == Int.MIN_VALUE / 10 && curValue > 8))) {
                return Int.MIN_VALUE
            }
            res = res * 10 + (curChar - '0') * sign
        }
        return res
    }

    fun myAtoiExtraString(str: String): Int {
        val trimed = str.trimStart()
        if (trimed.isEmpty()) {
            return 0
        }

        if (!(trimed[0] == '+' || trimed[0] == '-' || trimed[0].isDigit())) {
            return 0
        }

        val sb = StringBuilder()
        sb.append(trimed[0])
        for (i in 1 until trimed.length) {
            val s = trimed[i]
            if (s == ' ' || !s.isDigit()) {
                break
            }
            sb.append(s)
        }

        val ansStr = when {
            sb[0] == '-' -> {
                '-' + sb.trimStart('-').trimStart('0').toString()
            }
            sb[0] == '+' -> {
                sb.trimStart('+').trimStart('0').toString()
            }
            else -> {
                sb.trimStart('0')
            }
        }
        if (ansStr.isEmpty()) {
            return 0
        }
        if (ansStr.length == 1 && (ansStr[0] == '+' || ansStr[0] == '-')) {
            return 0
        }

        val intMaxStr = Int.MAX_VALUE.toString()
        val intMaxStrLength = intMaxStr.length
        if (sb[0] == '-') {
            return when {
                ansStr.length > intMaxStrLength + 1 -> {
                    Int.MIN_VALUE
                }
                ansStr.length == intMaxStrLength + 1 -> {
                    for (i in 1 until ansStr.length) {
                        if (ansStr[i] > intMaxStr[i - 1]) {
                            return Int.MIN_VALUE
                        } else if (ansStr[i] < intMaxStr[i - 1]) {
                            break
                        }
                    }
                    return Integer.parseInt(ansStr.toString())
                }
                else -> {
                    Integer.parseInt(ansStr.toString())
                }
            }
        } else {
            return when {
                ansStr.length > intMaxStrLength -> {
                    Int.MAX_VALUE
                }
                ansStr.length == intMaxStrLength -> {
                    for (i in ansStr.indices) {
                        if (ansStr[i] > intMaxStr[i]) {
                            return Int.MAX_VALUE
                        } else if (ansStr[i] < intMaxStr[i]) {
                            break
                        }
                    }
                    return Integer.parseInt(ansStr.toString())
                }
                else -> {
                    Integer.parseInt(ansStr.toString())
                }
            }
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(42, myAtoi("42"))
        assertEquals(-42, myAtoi("       -42"))
        assertEquals(4193, myAtoi("4193 with words"))
        assertEquals(0, myAtoi("words and 987"))
        assertEquals(Int.MIN_VALUE, myAtoi("-91283472332"))
        assertEquals(3, myAtoi("3.1415"))
        assertEquals(0, myAtoi("-"))
        assertEquals(1, myAtoi("+1"))
        assertEquals(0, myAtoi(" 0000 "))
        assertEquals(12345678, myAtoi("  0000000000012345678"))
        assertEquals(-12345678, myAtoi("  -0000000000012345678"))
        assertEquals(-2147483647, myAtoi("-2147483647"))
        assertEquals(1095502006, myAtoi("1095502006p8"))
        assertEquals(1146905820, myAtoi("    +1146905820n1"))
    }
}