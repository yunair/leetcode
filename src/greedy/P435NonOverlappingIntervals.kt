package greedy

import java.util.*
import kotlin.test.assertEquals

/**
 * 无重叠区间
 */
object P435NonOverlappingIntervals {
    /**
     * 总长度-不重复区间，即为需要移除的区间
     */
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        return intervals.size - intervalsCount(intervals)
    }

    private fun intervalsCount(intervals: Array<IntArray>): Int {
        Arrays.sort(intervals) { o1, o2 -> o1[1].compareTo(o2[1]) }
        var count = 0
        var maxRight = Int.MIN_VALUE
        for (interval in intervals) {
            if (interval[0] >= maxRight) {
                maxRight = interval[1]
                count++
            }
        }
        return count
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(
            1, eraseOverlapIntervals(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 3),
                    intArrayOf(3, 4),
                    intArrayOf(1, 3)
                )
            )
        )

        assertEquals(
            2, eraseOverlapIntervals(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(1, 2),
                    intArrayOf(1, 2)
                )
            )
        )
    }
}