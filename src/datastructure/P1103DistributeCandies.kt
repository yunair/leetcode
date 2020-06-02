package datastructure

/**
 * 分糖果 II
 */
object P1103DistributeCandies {
    fun distributeCandies(candies: Int, peopleNum: Int): IntArray {
        val arr = IntArray(peopleNum)
        var remain = candies
        var i = 1
        while (remain > 0) {
            val position = i % peopleNum
            val index = if (position == 0) {
                peopleNum - 1
            } else {
                position - 1
            }

            if (remain - i <= 0) {
                arr[index] += remain
            } else {
                arr[index] += i
            }
            remain -= i
            i++
        }

        return arr
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(distributeCandies(7, 4).contentToString())
        println(distributeCandies(10, 3).contentToString())
        println(distributeCandies(60, 4).contentToString())
    }
}