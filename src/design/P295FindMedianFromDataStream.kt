package design

import java.util.*

/**
 * 使用两个堆，储存前半部分用大堆，储存后半部分用小堆
 */
class MedianFinder() {

    /** initialize your data structure here. */
    private val minPq = PriorityQueue<Int>()
    private val maxPq = PriorityQueue<Int> { o1, o2 ->
        o2.compareTo(o1)
    }


    /**
     * 假设如果是奇数，min会多存一个
     */
    fun addNum(num: Int) {
        minPq.add(num)
        maxPq.add(minPq.poll())

        if ((minPq.size + maxPq.size) and 1 == 1) {
            // 奇数个，要保证minPq多一个
            minPq.add(maxPq.poll())
        }
    }

    fun findMedian(): Double {
        return if ((minPq.size + maxPq.size) and 1 == 1) {
            // 奇数
            minPq.peek().toDouble()
        } else {
            (minPq.peek() + maxPq.peek()) / 2.0
        }
    }

}