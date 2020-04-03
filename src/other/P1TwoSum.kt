package twopoint

/**
 *
 */
object P1TwoSum {


    fun twoSumWithMap(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        for (i in nums.indices) {
            if (map.containsKey(target - nums[i])) {
                return intArrayOf(i, map[target - nums[i]] ?: error(""))
            }
            map[nums[i]] = i
        }
        return intArrayOf()
    }
}