package backtrack

/**
 * 子集
 */
object P78Subsets {
    val ans = mutableListOf<List<Int>>()
    fun subsets(nums: IntArray): List<List<Int>> {
        backtrack(nums, 0, mutableListOf())
        return ans
    }

    private fun backtrack(nums: IntArray, start: Int, tracker: MutableList<Int>) {
        ans.add(ArrayList(tracker))

        for (i in start until nums.size) {
            if (tracker.contains(nums[i])) {
                continue
            }
            tracker.add(nums[i])
            backtrack(nums, i + 1, tracker)
            tracker.remove(nums[i])
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(subsets(intArrayOf(1, 2, 3)))
    }
}