package other.array

/**
 *  合并两个有序数组
 */
object P88MergeSortedArray {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var index = nums1.size - 1
        var n1Index = m - 1
        var n2Index = n - 1
        while (n2Index >= 0 && n1Index >= 0) {
            if (nums1[n1Index] > nums2[n2Index]) {
                nums1[index] = nums1[n1Index]
                n1Index--
            } else {
                nums1[index] = nums2[n2Index]
                n2Index--
            }
            index--
        }

        while (n2Index >= 0) {
            nums1[index] = nums2[n2Index]
            n2Index--
            index--
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val nums1 = intArrayOf(1, 2, 3, 0, 0, 0)
        val nums2 = intArrayOf(2, 5, 6)
        merge(nums1, 3, nums2, 3)
        println(nums1.contentToString())
    }
}