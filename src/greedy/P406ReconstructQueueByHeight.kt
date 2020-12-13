package greedy

import java.util.*

/**
 * 根据身高重建队列
 */
object P406ReconstructQueueByHeight {
    /**
     * 先对输入数组排序，h升序，k降序
     * 从头循环遍历
     * 当前这个人就是剩下未安排的人中最矮的人，他的k值就代表他在剩余空位的索引值
     * 如果有多个人高度相同，要按照k值从大到小领取索引值 示例：
     *
     * [ 0, 1, 2, 3, 4, 5 ] [ 4, 4 ] 4
     * [ 0, 1, 2, 3, 5 ]    [ 5, 2 ] 2
     * [ 0, 1, 3, 5 ]       [ 5, 0 ] 0
     * [ 1, 3, 5 ]          [ 6, 1 ] 3
     * [ 1, 5 ]             [ 7, 1 ] 5
     * [ 1 ]                [ 7, 0 ] 1
     * [ [ 5, 0 ], [ 7, 0 ], [ 5, 2 ], [ 6, 1 ], [ 4, 4 ], [ 7, 1 ] ]
     */
    fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
        val ans = Array(people.size) {
            IntArray(2)
        }
        val pq = PriorityQueue<IntArray> { o1, o2 ->
            if (o1[0] == o2[0]) {
                o2[1].compareTo(o1[1])
            } else {
                o1[0].compareTo(o2[0])
            }
        }

        val indexs = mutableListOf<Int>()
        for ((i, p) in people.withIndex()) {
            indexs.add(i)
            pq.add(p)
        }

        while (pq.isNotEmpty()) {
            val arr = pq.remove()
            val pos = arr[1]
            val index = indexs[pos]
            ans[index] = arr
            indexs.removeAt(pos)
        }

        return ans
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val arr = Array(6) {
            IntArray(2)
        }.apply {
            this[0] = intArrayOf(7, 0)
            this[1] = intArrayOf(4, 4)
            this[2] = intArrayOf(7, 1)
            this[3] = intArrayOf(5, 0)
            this[4] = intArrayOf(6, 1)
            this[5] = intArrayOf(5, 2)
        }

        println(reconstructQueue(arr).contentDeepToString())
    }
}