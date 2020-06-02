package search

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 */
object P34SearchRangeInSortedArray {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val left = searchLeft(nums, target)
        val right = searchRight(nums, target)
        return intArrayOf(left, right)
    }

    /**
     * 二分法查当前值
     */
    private fun search(nums: IntArray, target: Int): Int {
        var low = 0
        var high = nums.size - 1
        while (low <= high) {
            val mid = low + (high - low) / 2
            when {
                nums[mid] < target -> {
                    low = mid + 1
                }
                nums[mid] > target -> {
                    high = mid - 1
                }
                else -> {
                    return mid
                }
            }
        }
        return -1
    }

    /**
     * 二分法查最左值
     */
    private fun searchLeft(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        // 边界为[a+1, a]
        while (left <= right) {
            val mid = left + (right - left) / 2
            when {
                nums[mid] < target -> {
                    left = mid + 1
                }
                nums[mid] > target -> {
                    right = mid - 1
                }
                else -> {
                    right = mid - 1
                }
            }
        }
        if (left >= nums.size || nums[left] != target) {
            return -1
        }
        return left
    }

    /**
     * 二分法查最右值
     */
    private fun searchRight(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        // 边界为[a+1, a]
        while (left <= right) {
            val mid = left + (right - left) / 2
            when {
                nums[mid] < target -> {
                    left = mid + 1
                }
                nums[mid] > target -> {
                    right = mid - 1
                }
                else -> {
                    left = mid+1
                }
            }
        }
        if (right < 0 || nums[right] != target) {
            return -1
        }
        return right
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 8).contentToString())
        println(searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 6).contentToString())
        println(searchRange(intArrayOf(1, 2), 1).contentToString())
    }
}