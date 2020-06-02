package datastructure

import common.ListNode
import common.TreeNode
import java.lang.StringBuilder
import java.util.*
import kotlin.math.sqrt
import kotlin.test.assertEquals

object Temp {

    fun findContinuousSequence(target: Int): Array<IntArray> {
        if (target == 1 || target == 2) {
            return Array(0) {
                IntArray(0)
            }
        }
        // 等差数列求和公式:
        // n*a1 + n * (n-1) / 2 = Sn
        val list = mutableListOf<IntArray>()
        for (n in 2..(sqrt(2.0 * target).toInt())) {
            if (target * 2 % n != 0) {
                continue
            }
            val a1Multi = ((target * 2 / n) - (n - 1))
            if (a1Multi and 1 == 1) {
                // 奇数
                continue
            }
            val a1 = a1Multi / 2
            val arr = IntArray(n)
            for (i in 0 until n) {
                arr[i] = a1 + i
            }
            list.add(arr)
        }
        list.sortBy {
            it[0]
        }
        return list.toTypedArray()
    }

    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount + 1) {
            amount + 1
        }
        dp[0] = 0
        for (j in 1..amount) {
            for (i in coins.indices) {
                if (j < coins[i]) {
                    continue
                }
                dp[j] = minOf(dp[j], dp[j - coins[i]] + 1)
            }
        }
        return if (dp[amount] == amount + 1) -1 else dp[amount]
    }

    fun countElements(arr: IntArray): Int {
        val map = mutableMapOf<Int, Int>()
        for (i in arr) {
            map[i] = map.getOrDefault(i, 0) + 1
        }
        arr.sort()
        var count = 0
        for (i in arr) {
            if (map.containsKey(i + 1)) {
                count++
                val value = map.getOrDefault(i, 1) - 1
                if (value == 0) {
                    map.remove(i)
                } else {
                    map[i] = value
                }

            }
        }
        return count
    }

    private var max = 0
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        dfs(root)
        return max
    }

    private fun dfs(node: TreeNode?): Int {
        if (node == null) {
            return 0
        }

        val left = dfs(node.left)
        val right = dfs(node.right)
        max = maxOf(left + right, max)
        return maxOf(left, right) + 1
    }

    fun lastStoneWeight(stones: IntArray): Int {
        val pq = PriorityQueue<Int> { o1, o2 ->
            o2.compareTo(o1)
        }
        for (s in stones) {
            pq.add(s)
        }

        while (pq.size > 1) {
            val s1 = pq.poll()
            val s2 = pq.poll()
            if (s1 - s2 > 0) {
                pq.add(s1 - s2)
            }
        }

        if (pq.isEmpty()) {
            return 0
        }
        return pq.poll()
    }


    fun stringShift(s: String, shifts: Array<IntArray>): String {
        var shiftLeftCount = 0
        for (shift in shifts) {
            if (shift[0] == 0) {
                shiftLeftCount += shift[1]
            } else {
                shiftLeftCount -= shift[1]
            }
        }
        shiftLeftCount %= s.length
        return if (shiftLeftCount < 0) {
            // 向右移动
            val right = s.substring(s.length + shiftLeftCount, s.length)
            val left = s.subSequence(0, s.length + shiftLeftCount)
            right + left
        } else {
            val left = s.substring(0, shiftLeftCount)
            val right = s.substring(shiftLeftCount, s.length)
            right + left
        }
    }

    fun productExceptSelf(nums: IntArray): IntArray {
        val n = nums.size
        val ans = IntArray(n)
        val l = IntArray(n) {
            1
        }

        val r = IntArray(n) {
            1
        }
        for (i in 0 until n - 1) {
            l[i + 1] = l[i] * nums[i]
        }

        for (i in n - 1 downTo 1) {
            r[i - 1] = r[i] * nums[i]
        }

        for (i in 0 until n) {
            ans[i] = l[i] * r[i]
        }
        return ans
    }

    fun checkValidString(s: String): Boolean {
        var id = 1
        val stackLeft = LinkedList<Int>()
        val stackAsterisk = LinkedList<Int>()
        for (c in s) {
            if (c == '(') {
                stackLeft.push(id)
                id++
            } else if (c == '*') {
                stackAsterisk.push(id)
                id++
            } else {
                if (stackLeft.isEmpty() && stackAsterisk.isEmpty()) {
                    return false
                }
                if (stackLeft.isNotEmpty()) {
                    stackLeft.pop()
                } else {
                    stackAsterisk.pop()
                }
            }
        }

        // 两者都不空
        while (stackAsterisk.isNotEmpty() && stackLeft.isNotEmpty()) {
            val leftId = stackLeft.pop()
            val asteriskId = stackAsterisk.pop()
            if (leftId > asteriskId) {
                return false
            }
        }

        return if (stackAsterisk.isEmpty() && stackLeft.isNotEmpty()) {
            false
        } else if (stackLeft.isEmpty() && stackAsterisk.isNotEmpty()) {
            true
        } else {
            true
        }
    }

    fun numIslands(grid: Array<CharArray>): Int {
        var count = 0
        if (grid.isEmpty() || grid[0].isEmpty()) {
            return 0
        }

        val visited = Array(grid.size) {
            BooleanArray(grid[0].size)
        }
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (visited[i][j]) {
                    continue
                }
                visited[i][j] = true
                if (grid[i][j] != '0') {
                    count++
                    bfs(grid, i, j, visited)
                }
            }
        }
        return count
    }

    val dirsX = intArrayOf(-1, 1, 0, 0)
    val dirsY = intArrayOf(0, 0, -1, 1)
    private fun bfs(grid: Array<CharArray>, i: Int, j: Int, visited: Array<BooleanArray>) {
        val queue = LinkedList<Pair<Int, Int>>()
        queue.push(Pair(i, j))
        while (queue.isNotEmpty()) {
            val loc = queue.poll()
            for (k in 0..3) {
                val newX = loc.first + dirsX[k]
                val newY = loc.second + dirsY[k]
                if (newX < 0 || newX == grid.size || newY < 0 || newY == grid[0].size || visited[newX][newY]) {
                    continue
                }

                if (grid[newX][newY] == '1') {
                    queue.add(Pair(newX, newY))
                }
                visited[newX][newY] = true
            }
        }
    }

    fun search(nums: IntArray, target: Int): Int {
        var lo = 0
        var high = nums.size - 1
        while (lo <= high) {
            if (nums[lo] == target) {
                return lo
            }
            if (nums[high] == target) {
                return high
            }
            val mid = (high - lo) / 2 + lo
            val v = nums[mid]
            when {
                v == target -> {
                    return mid
                }
                v > target -> {
                    // 从mid到high先减后加
                    if (v > nums[high] && nums[lo] > target) {
                        lo = mid + 1
                    } else {
                        high = mid - 1
                    }
                }
                else -> {
                    // v < target
                    // 从lo到mid先减后加
                    if (v < nums[lo] && nums[high] < target) {
                        high = mid - 1
                    } else {
                        lo = mid + 1
                    }
                }
            }
        }
        return -1
    }

    fun bstFromPreorder(preorder: IntArray): TreeNode? {
        if (preorder.isEmpty()) {
            return null
        }
        return buildTree(preorder, 0, preorder.size - 1)

    }

    private fun buildTree(preorder: IntArray, start: Int, end: Int): TreeNode? {
        if (start > end) {
            return null
        }
        val curV = preorder[start]
        val node = TreeNode(curV)

        if (start == end) {
            return node
        }
        var i = start
        // 找到右侧的点起始索引
        while (i <= end) {
            if (preorder[i] > curV) {
                break
            }
            i++
        }
        val left = buildTree(preorder, start + 1, i - 1)
        val right = buildTree(preorder, i, end)
        node.left = left
        node.right = right
        return node
    }

    class BinaryMatrix {
        fun get(x: Int, y: Int): Int {
            TODO()
        }

        fun dimensions(): List<Int> {
            TODO()
        }
    }

    /**
     * 每行是排序好的
     * 每列不一定排序
     */
    fun leftMostColumnWithOne(binaryMatrix: BinaryMatrix): Int {
        val dimen = binaryMatrix.dimensions()
        var column = -1
        var i = 0
        var j = dimen[1] - 1
        while (i < dimen[0]) {
            while (j >= 0) {
                if (binaryMatrix.get(i, j) == 1) {
                    // 为1向左找
                    column = j
                    j--
                } else {
                    // 为0向下找
                    i++
                    break
                }
            }
            i++
        }
        return column
    }

    fun subarraySum(nums: IntArray, k: Int): Int {
        // brute force
        val map = mutableMapOf<Int/*key*/, Int/*count*/>()
        map[0] = 1
        var count = 0

        var sum = 0 // sum(0, i)
        for (i in nums.indices) {
            sum += nums[i]
            count += map.getOrDefault(sum - k, 0)
            map[sum] = map.getOrDefault(sum, 0) + 1
        }
        return count
    }

    fun rangeBitwiseAnd(m: Int, n: Int): Int {
        var ans = -1
        for (i in m..n) {
            ans = ans and i
        }
        return ans
    }

    fun canJump(nums: IntArray): Boolean {
        if (nums.isEmpty()) {
            return true
        }
        var nextPos = nums[0]
        for (i in 1 until nums.size) {
            if (i >= nextPos) {
                return false
            }
            nextPos = maxOf(nextPos, i + nums[i])
        }
        return true
    }

    fun isValidSequence(root: TreeNode?, arr: IntArray): Boolean {
        if (root == null) {
            return arr.isEmpty()
        }

        if (arr.isEmpty()) {
            return true
        }


        val queue = LinkedList<TreeNode>()
        queue.add(root)
        var index = 0
        var level = 0
        while (queue.isEmpty()) {
            if (index == arr.size) {
                return true
            }
            if (level != index) {
                return false
            }
            val size = queue.size
            for (i in 1..size) {
                val value = queue.pop()
                if (value.`val` == arr[index]) {
                    index++
                    value.left?.let {
                        queue.push(it)
                    }
                    value.right?.let {
                        queue.push(it)
                    }
                }
                level++
            }
        }

        return true
    }

    fun isPerfectSquare(num: Int): Boolean {
        if (num == 1) {
            return true
        }
        val max = num / 2
        for (i in 2..max) {
            if (i * i == num) {
                return true
            }
        }
        return false
    }

    fun oddEvenList(head: ListNode?): ListNode? {
        if (head == null) {
            return head
        }

        var odd = head
        var even = head.next
        val evenHead = even
        while (odd != null && even != null) {
            odd.next = odd.next!!.next
            odd = odd.next
            even.next = even.next!!.next
            even = even.next
        }

        odd!!.next = evenHead
        return head
    }

    fun frequencySort(s: String): String {
        val map = mutableMapOf<Char, Int>()
        for (c in s) {
            map[c] = map.getOrDefault(c, 0) + 1
        }

        val pq = PriorityQueue<Pair<Char, Int>> { a, b ->
            a.second.compareTo(b.second)
        }

        for (entry in map) {
            pq.add(Pair(entry.key, entry.value))
        }

        val sb = StringBuilder()
        while (pq.isNotEmpty()) {
            val v = pq.poll()
            for (i in 0 until v.second) {
                sb.append(v.first)
            }
        }
        return sb.toString()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val arr = Array(3) {
            IntArray(3)
        }.apply {
            this[0] = intArrayOf(1, 1, 1)
            this[1] = intArrayOf(1, 1, 0)
            this[2] = intArrayOf(1, 0, 1)
        }


//        assertEquals(1, lastStoneWeight(intArrayOf(2, 7, 4, 1, 8, 1)))
//        assertTrue { checkValidString("()") }
//        assertTrue { checkValidString("(*)") }
//        assertTrue { checkValidString("(*))") }

//        assertEquals(4, search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0))
//        assertEquals(-1, search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 3))
//        TreeUtil.printTreeNode(bstFromPreorder(intArrayOf(8, 5, 1, 7, 10, 12)))
        assertEquals(2, subarraySum(intArrayOf(1, 1, 1), 2))
    }
}