package twopoint.slidingwindow

import kotlin.collections.ArrayDeque

/**
 * 滑动窗口最大值
 */
@ExperimentalStdlibApi
object P239MaxSlidingWindow {
    /**
     * 线性时间复杂度
     * 单调队列处理
     */
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        if (nums.isEmpty()) {
            return intArrayOf()
        }

        val arr = IntArray(nums.size - k + 1)
        val deque = ArrayDeque<Int>()
        var index = 0
        for (i in nums.indices) {
            val num = nums[i]
            if (i < k - 1) {
                deque.removeIf {
                    it < num
                }
                deque.add(num)
            } else {
                deque.removeIf {
                    it < num
                }
                // 满足窗口最大值
                deque.add(num)
                arr[index] = deque.first()
                index++
                // 窗口向右移动
                // 尝试移除最早加入的那个数字
                // 最早的数字最大，就移除，否则忽视
                if(deque.first() == nums[i - k + 1]){
                    deque.removeFirst()
                }
            }
        }

        return arr
    }

    fun maxSlidingWindowEasy(nums: IntArray, k: Int): IntArray {
        if (nums.isEmpty()) {
            return intArrayOf()
        }

        val arr = IntArray(nums.size - k + 1)
        var left = 0
        var right = 0
        var max = Int.MIN_VALUE
        var i = 0
        while (right < nums.size) {
            val c1 = nums[right]
            max = maxOf(max, c1)
            right++
            if (right - left == k) {
                arr[i] = max
                max = Int.MIN_VALUE
                i++
                left++
                right = left
            }
        }
        return arr
    }

    @JvmStatic
    fun main(args: Array<String>) {
//        println(maxSlidingWindow(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 3).contentToString())
//        println(maxSlidingWindow(intArrayOf(1, -1), 1).contentToString())
        println(maxSlidingWindow(intArrayOf(9,10,9,-7,-4,-8,2,-6), 5).contentToString())
    }
}