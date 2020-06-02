package datastructure.array

/**
 * 求众数 II
 */
object P229MajorityElement2 {
    /**
     * 投票算法
     */
    fun majorityElement(nums: IntArray): List<Int> {
        val ans = mutableListOf<Int>()
        var x = 0
        var c0 = 0
        var y = 0
        var c1 = 0
        for (num in nums) {
            if (num == x) {
                c0++
                continue
            }

            if (num == y) {
                c1++
                continue
            }

            if (c0 == 0) {
                x = num
                c0++
                continue
            }

            if (c1 == 0) {
                y = num
                c1++
                continue
            }
            c0--
            c1--
        }
        c0 = 0
        c1 = 0
        for (num in nums) {
            if (num == x) {
                c0++
            } else if(num == y){
                c1++
            }
        }
        if (c0 > nums.size / 3) {
            ans.add(x)
        }

        if (c1 > nums.size / 3) {
            ans.add(y)
        }

        return ans
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(majorityElement(intArrayOf(1, 2)))
        println(majorityElement(intArrayOf()))
        println(majorityElement(intArrayOf(2, 3, 1, 1, 1, 2, 2)))
    }
}