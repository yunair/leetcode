package interview

object TwoSingleNumberInArray {
    /**
    相同的数异或为0，不同的异或为1。0和任何数异或等于这个数本身。

    所以，数组里面所有数异或 = 目标两个数异或 。 由于这两个数不同，所以异或结果必然不为0。

    假设数组异或的二进制结果为10010，那么说明这两个数从右向左数第2位是不同的

    那么可以根据数组里面所有数的第二位为0或者1将数组划分为2个。

    这样做可以将目标数必然分散在不同的数组中，而且相同的数必然落在同一个数组中。
     */
    fun singleNumbers(nums: IntArray): IntArray {
        //
        var ret = 0
        for (num in nums) {
            ret = num xor ret
        }

        var a = 0
        var b = 0
        var h = 1
        while (ret and h == 0) {
            h = h shl 1
        }

        for (num in nums) {
            if (h and num == 0) {
                a = a xor num
            } else {
                b = b xor num
            }
        }
        return intArrayOf(a, b)
    }
}