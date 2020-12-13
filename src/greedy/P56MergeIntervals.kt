package greedy

import java.util.*
import kotlin.Comparator

/**
 * 合并区间
 */
object P56MergeIntervals {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        Arrays.sort(intervals) { o1, o2 ->
            o1[0].compareTo(o2[0])
        }

        val ans = mutableListOf<IntArray>()
        if (intervals.isEmpty()) {
            return ans.toTypedArray()
        }
        var startLeft = intervals[0][0]
        var startRight = intervals[0][1]
        for (i in 1 until intervals.size) {
            if (intervals[i][0] > startRight) {
                ans.add(intArrayOf(startLeft, startRight))
                startLeft = intervals[i][0]
                startRight = intervals[i][1]
            } else {
                startRight = maxOf(startRight, intervals[i][1])
            }
            if (i == intervals.size - 1) {
                startRight = maxOf(startRight, intervals[i][1])
            }
        }
        ans.add(intArrayOf(startLeft, startRight))
        return ans.toTypedArray()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(
            merge(
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(2, 6),
                    intArrayOf(8, 10),
                    intArrayOf(15, 18)
                )
            ).contentDeepToString()
        )

        println(
            merge(
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(2, 6),
                    intArrayOf(8, 10),
                    intArrayOf(10, 15)
                )
            ).contentDeepToString()
        )

        println(
            merge(
                arrayOf(
                    intArrayOf(1, 4),
                    intArrayOf(4, 5)
                )
            ).contentDeepToString()
        )

        println(
            merge(
                arrayOf(
                    intArrayOf(1, 4)
                )
            ).contentDeepToString()
        )
        println(
            merge(
                arrayOf(
                    intArrayOf(1, 4),
                    intArrayOf(0, 4)
                )
            ).contentDeepToString()
        )

        println(
            merge(
                arrayOf(
                    intArrayOf(1, 4),
                    intArrayOf(0, 2),
                    intArrayOf(3, 5)
                )
            ).contentDeepToString()
        )

        println(
            merge(
                arrayOf(
                    intArrayOf(1, 4),
                    intArrayOf(2, 3)
                )
            ).contentDeepToString()
        )
        println(
            merge(
                arrayOf(
                    intArrayOf(2, 3),
                    intArrayOf(4, 5),
                    intArrayOf(6, 7),
                    intArrayOf(1, 10)
                )
            ).contentDeepToString()
        )
        println(
            merge(
                arrayOf(
                    intArrayOf(0, 0),
                    intArrayOf(1, 2),
                    intArrayOf(5, 5),
                    intArrayOf(2, 4),
                    intArrayOf(3, 3),
                    intArrayOf(5, 6),
                    intArrayOf(5, 6),
                    intArrayOf(4, 6),
                    intArrayOf(0, 0),
                    intArrayOf(1, 2),
                    intArrayOf(0, 2),
                    intArrayOf(4, 5)
                )
            ).contentDeepToString()
        )

        println(
            merge(
                arrayOf(
                    intArrayOf(5, 6),
                    intArrayOf(1, 2),
                    intArrayOf(2, 4),
                    intArrayOf(5, 5),
                    intArrayOf(5, 5),
                    intArrayOf(3, 3)
                )
            ).contentDeepToString()
        )
    }
}