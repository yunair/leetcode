package twopoint

/**
 * 四数之和
 */
object P18FourSum {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val ans = mutableListOf<List<Int>>()
        nums.sort()
        for (i in 0 until nums.size - 3) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            }
            /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏*/
            val min1 = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3]
            if (min1 > target) {
                break
            }

            /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
            val max1 = nums[i] + nums[nums.size - 3] + nums[nums.size - 2] + nums[nums.size - 1]
            if (max1 < target) {
                continue
            }
            for (j in i + 1 until nums.size - 2) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue
                }
                val sum2 = nums[i] + nums[j]
                var k = j + 1
                var l = nums.size - 1
                while (k < l) {
                    val sum34 = nums[k] + nums[l]
                    when {
                        sum34 + sum2 > target -> {
                            l--
                        }
                        sum34 + sum2 < target -> {
                            k++
                        }
                        else -> {
                            val list = mutableListOf<Int>()
                            list.add(nums[i])
                            list.add(nums[j])
                            list.add(nums[k])
                            list.add(nums[l])
                            ans.add(list)
                            k++
                            l--
                            while (k < nums.size && nums[k] == nums[k - 1]) {
                                k++
                            }
                            while (l > k && nums[l] == nums[l + 1]) {
                                l--
                            }
                        }
                    }
                }

            }
        }
        return ans
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(fourSum(intArrayOf(1, 0, -1, 0, -2, 2), 0))
        println(fourSum(intArrayOf(-3, -3, -2, -1, 0, 0, 1, 2, 3), 0))
        println(fourSum(intArrayOf(0, 0, 0, 0), 0))
        println(fourSum(intArrayOf(1, -2, -5, -4, -3, 3, 3, 5), -11))
        println(fourSum(intArrayOf(-1, 0, -5, -2, -2, -4, 0, 1, -2), -9))
    }
}