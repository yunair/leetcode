package interview

/**
 * 搜索旋转数组
 */
object SearchRotatedArray {
    fun search(arr: IntArray, target: Int): Int {
        for ((i, item) in arr.withIndex()) {
            if (item == target) {
                return i
            }
        }
        return -1
    }
}