package backtrack

/**
 * 全排列
 */
object P46Permutations {
    val ans = mutableListOf<List<Int>>()
    fun permute(nums: IntArray): List<List<Int>> {
        ans.clear()
        backtrack(nums, mutableListOf(), BooleanArray(nums.size))
        return ans
    }

    private fun backtrack(nums: IntArray, tracker: MutableList<Int>, visited: BooleanArray) {
        if (tracker.size == nums.size) {
            ans.add(ArrayList(tracker))
            return
        }

        for (i in nums.indices) {
            if (visited[i]) {
                continue
            }
            val num = nums[i]

            visited[i]  = true
            tracker.add(num)

            backtrack(nums, tracker, visited)

            visited[i]  = false
            tracker.remove(num)
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(permute(intArrayOf(1, 2, 3, 4)))
    }
}