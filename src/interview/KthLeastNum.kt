package interview

import java.util.*

/**
 * 最小的k个数
 */
object KthLeastNum {
    fun getLeastNumbers(arr: IntArray, k: Int): IntArray {
        val res = IntArray(k)
        if (k == 0) {
            return res
        }
        val pq = PriorityQueue<Int>(k, Comparator { o1, o2 -> o1 - o2 })
        for (item in arr) {
            pq.add(item)
        }
        for (i in 0 until k) {
            res[i] = pq.remove()
        }
        return res
    }

    fun getLeastNumbersSort(arr: IntArray, k: Int): IntArray {
        val res = IntArray(k)
        if (k == 0) {
            return res
        }
        Arrays.sort(arr)
        for (i in 0 until k) {
            res[i] = arr[i]
        }
        return res
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(getLeastNumbersSort(intArrayOf(3,2,1), 2).contentToString())
        println(getLeastNumbersSort(intArrayOf(0,1,2,1), 1).contentToString())
        println(getLeastNumbersSort(intArrayOf(0,1,2,1), 0).contentToString())
    }
}