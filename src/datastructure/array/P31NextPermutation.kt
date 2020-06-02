package datastructure.array

/**
 * 下一个排列
 */
object P31NextPermutation {
    /**
     * 1.我们希望下一个数比当前数大，这样才满足“下一个排列”的定义。
     *  因此只需要将后面的「大数」与前面的「小数」交换，就能得到一个更大的数。比如 123456，将 5 和 6 交换就能得到一个更大的数 123465
     *  2. 我们还希望下一个数增加的幅度尽可能的小，这样才满足“下一个排列与当前排列紧邻“的要求。为了满足这个要求，我们需要：
     *      - 在尽可能靠右的低位进行交换，需要从后向前查找
     *      - 将一个 尽可能小的「大数」 与前面的「小数」交换。比如 123465，下一个排列应该把 5 和 4 交换而不是把 6 和 4 交换
     *      - 将「大数」换到前面后，需要将「大数」后面的所有数重置为升序，升序排列就是最小的排列。
     *      以 123465 为例：首先按照上一步，交换 5 和 4，得到 123564；
     *      然后需要将 5 之后的数重置为升序，得到 123546。显然 123546 比 123564 更小，123546 就是 123465 的下一个排列
     */
    fun nextPermutation(nums: IntArray) {
        var i = nums.size - 1
        var j = i - 1
        var k = nums.size - 1
        while (j >= 0 && nums[i] <= nums[j]) {
            // 找到比前一个数大的数
            i--
            j--
        }
        // nums[i] > nums[j]

        if (j >= 0) {
            // find nums[k] > nums[j]
            // 这里nums[k]一定 < nums[i]，因为前面是逆序找的
            while (nums[k] <= nums[j]) {
                k--
            }
            swap(nums, j, k)
        }
        nums.sort(i, nums.size)
    }

    private fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val arr1 = intArrayOf(2, 3, 1)
        nextPermutation(arr1)
        println(arr1.contentEquals(intArrayOf(3, 1, 2)))
        val arr2 = intArrayOf(3, 2, 1)
        nextPermutation(arr2)
        println(arr2.contentEquals(intArrayOf(1, 2, 3)))
        val arr3 = intArrayOf(1, 1, 5)
        nextPermutation(arr3)
        println(arr3.contentEquals(intArrayOf(1, 5, 1)))
        val arr4 = intArrayOf(1, 3, 2)
        nextPermutation(arr4)
        println(arr4.contentEquals(intArrayOf(2, 1, 3)))
    }
}