package dp

import kotlin.test.assertEquals

/**
 * 打家劫舍III
 */
object P337HouseRobber3 {
    /**
     * 因为房子是一个树
     * 所以有三种情况：
     * 1。 第一家和最后一家都不偷
     * 2。 偷第一家不偷最后一家
     * 3。 偷最后一家不偷第一家
     *
     * 因为偷一定比不偷最终结果大，所以第一种情况不用考虑，只要考虑下面两种情况即可
     *
     */
    fun rob(cost: IntArray): Int {
        TODO()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(3, rob(intArrayOf(2, 3, 2)))
        assertEquals(4, rob(intArrayOf(1, 2, 3, 1)))
        assertEquals(0, rob(intArrayOf()))
        assertEquals(16, rob(intArrayOf(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)))
    }
}