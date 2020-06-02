package tree.traversal

import common.TreeNode
import util.TreeUtil
import java.util.*

/**
 * 从先序遍历还原二叉树
 */
object P1028ConstructFromPreOrder {
    /**
     * 用栈保存父节点列表
     */
    fun recoverFromPreorder(s: String): TreeNode? {
        val stack = Stack<TreeNode>()
        val list = mutableListOf<String>()
        // 将传入的string转变为容易解析的格式
        parseStringToFormatList(s, list)

        val root = TreeNode(Integer.parseInt(list.removeAt(0)))
        stack.push(root)
        var level = 0
        var lastLevel = -1
        for (item in list) {
            if (item == "-") {
                level++
            } else {
                val hisStack = Stack<TreeNode>()
                val offset = if (level > lastLevel) {
                    // 新一层，所以只要找前一个元素即是父元素
                    0
                } else {
                    // 非新层，找到父元素
                    stack.size - level
                }
                for (i in 0..offset) {
                    hisStack.push(stack.pop())
                }
                // 找上一级最近入stack的值
                val current = hisStack[hisStack.size - 1]
                when {
                    lastLevel >= level -> {
                        stack.push(current)
                    }
                    else -> {
                        while (hisStack.isNotEmpty()) {
                            stack.push(hisStack.pop())
                        }
                    }
                }

                val v = Integer.parseInt(item)
                if (current.left == null) {
                    current.left = TreeNode(v)
                    stack.push(current.left)
                } else {
                    current.right = TreeNode(v)
                    stack.push(current.right)
                }
                lastLevel = level
                level = 0
            }
        }

        return root
    }

    private fun parseStringToFormatList(s: String, list: MutableList<String>) {
        var num = 0
        for (i in s.indices) {
            val c = s[i]
            if (c == '-') {
                if (num != 0) {
                    list.add(num.toString())
                }
                num = 0
                list.add(c.toString())
            } else {
                num = num * 10 + Integer.valueOf(c.toString())
            }
            if (i + 1 == s.length) {
                list.add(num.toString())
            }
        }
    }
}

fun main() {
//    TreeUtil.printTreeNode(P1028ConstructFromPreOrder.recoverFromPreorder("6-4--2--9---7----4----5"))
//    TreeUtil.printTreeNode(P1028ConstructFromPreOrder.recoverFromPreorder("1-2--3--4-5--6--7"))
    TreeUtil.printTreeNode(P1028ConstructFromPreOrder.recoverFromPreorder("67-58--35---22----28--10---21----7----67-62"))
}