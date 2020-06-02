package design.self


class BST<E : Comparable<E>> {
    inner class Node(var e: E, var left: Node? = null, var right: Node? = null)

    var root: Node? = null
    var size: Int = 0

    fun contains(e: E): Boolean {
        return contains(root, e)
    }

    private fun contains(node: Node?, e: E): Boolean {
        if (node == null) {
            return false
        }

        return when {
            node.e == e -> {
                true
            }
            e < node.e -> {
                contains(node.left, e)
            }
            else -> {
                contains(node.right, e)
            }
        }
    }

    // 向二分搜索树中添加新的元素e
    fun add(e: E) {
        root = add(root, e)
    }

    // 向以node为根的二分搜索树中添加新的元素e
    // 返回插入新节点后二分搜索树的根
    private fun add(node: Node?, e: E): Node {
        if (node == null) {
            size++
            return Node(e)
        }
        if (e < node.e) {
            node.left = add(node.left, e)
        } else if (e > node.e) {
            node.right = add(node.right, e)
        }
        return node
    }

    fun preOrder() {
        preOrder(root)
    }

    private fun preOrder(node: Node?) {
        if (node == null) {
            return
        }

        println(node.e)
        preOrder(node.left)
        preOrder(node.right)
    }

    fun inOrder() {
        inOrder(root)
    }

    private fun inOrder(node: Node?) {
        if (node == null) {
            return
        }

        inOrder(node.left)
        println(node.e)
        inOrder(node.right)
    }

    fun postOrder() {
        postOrder(root)
    }

    private fun postOrder(node: Node?) {
        if (node == null) {
            return
        }

        postOrder(node.left)
        postOrder(node.right)
        println(node.e)
    }
}
