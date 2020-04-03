package twopoint

/**
 * 三数之和
 */
object P15ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val ans = mutableListOf<List<Int>>()
        nums.sort()
        for (i in 0 until nums.size - 2) {
            // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(nums[i] > 0) {
                break
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            }
            val target = -nums[i]
            var j = i + 1
            var k = nums.size - 1
            while (j < k) {
                when {
                    nums[j] + nums[k] == target -> {
                        val list = mutableListOf<Int>()
                        list.add(nums[i])
                        list.add(nums[j])
                        list.add(nums[k])
                        ans.add(list)
                        j++
                        k--
                        while (j < nums.size && nums[j] == nums[j - 1]) {
                            j++
                        }
                        while (k > j && nums[k] == nums[k + 1]) {
                            k--
                        }
                    }
                    nums[j] + nums[k] > target -> {
                        k--
                    }
                    else -> {
                        j++
                    }
                }
            }
        }
        return ans
    }

    fun threeSumWithSet(nums: IntArray): List<List<Int>> {
        val ans = mutableListOf<List<Int>>()
        nums.sort()
        for (i in 0 until nums.size - 2) {
            val value = nums[i]
            val target = 0 - value
            val set = mutableSetOf<Int>()
            for (j in (i + 1) until nums.size) {
                if (set.contains(target - nums[j])) {
                    val list = mutableListOf<Int>()
                    list.add(value)
                    list.add(target - nums[j])
                    list.add(nums[j])

                    if (!ans.contains(list)) {
                        ans.add(list)
                    }
                }
                set.add(nums[j])
            }
        }
        return ans
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)))
        println(threeSum(intArrayOf(-2, 0, 1, 1, 2)))
    }
}