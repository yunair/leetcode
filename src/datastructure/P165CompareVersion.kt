package datastructure

import kotlin.test.assertEquals

/**
 * 比较版本号
 */
object P165CompareVersion {
    fun compareVersion(version1: String, version2: String): Int {
        val items1 = version1.split(".")
        val items2 = version2.split(".")
        val size = minOf(items1.size, items2.size)
        for (i in 0 until size) {
            val v1 = Integer.valueOf(items1[i])
            val v2 = Integer.valueOf(items2[i])
            if (v1 > v2) {
                return 1
            }

            if (v1 < v2) {
                return -1
            }
        }

        if (items1.size > size) {
            var index = size
            while (index < items1.size) {
                val v = Integer.parseInt(items1[index])
                if (v > 0) {
                    return 1
                }
                index++
            }
            return 0
        }

        if (items2.size > size) {
            var index = size
            while (index < items2.size) {
                val v = Integer.parseInt(items2[index])
                if (v > 0) {
                    return -1
                }
                index++
            }
            return 0
        }

        return 0
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(-1, compareVersion("0.1", "1.1"))
        assertEquals(-1, compareVersion("7.5.2.4", "7.5.3"))
        assertEquals(1, compareVersion("1.0.1", "1"))
        assertEquals(0, compareVersion("1.01", "1.001"))
        assertEquals(0, compareVersion("1.0", "1.0.0"))
    }
}