package greedy

import java.util.*
import kotlin.math.max
import kotlin.test.assertEquals

/**
 * 用最少数量的箭引爆气球
 */
object P452MinNumberOfArrowsToBurstBallons {
    fun findMinArrowShots(points: Array<IntArray>): Int {
        Arrays.sort(points) { o1, o2 ->
            o1[1].compareTo(o2[1])
        }

        if (points.isEmpty()) {
            return 0
        }
        var count = 1
        var maxRight = points[0][1]
        for (i in 1 until points.size) {
            val point = points[i]
            if (point[0] > maxRight) {
                count++
                maxRight = point[1]
            }
        }
        return count
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(1, findMinArrowShots(arrayOf(intArrayOf(Int.MIN_VALUE, Int.MAX_VALUE))))
        assertEquals(
            2, findMinArrowShots(
                arrayOf(
                    intArrayOf(10, 16),
                    intArrayOf(2, 8),
                    intArrayOf(1, 6),
                    intArrayOf(7, 12)
                )
            )
        )
    }
}