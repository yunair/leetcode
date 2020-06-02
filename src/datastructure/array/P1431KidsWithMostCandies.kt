package datastructure.array

/**
 * 拥有最多糖果的孩子
 */
object P1431KidsWithMostCandies {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): BooleanArray {
        val max = candies.max() ?: return BooleanArray(0)
        val ans = BooleanArray(candies.size)
        val aim = max - extraCandies
        for ((i, candy) in candies.withIndex()) {
            if (candy >= aim) {
                ans[i] = true
            }
        }
        return ans
    }
}