@file:JvmName("TreeNode")
package common

class TreeNode(@JvmField var `val`: Int) {
    @JvmField
    var left: TreeNode? = null
    @JvmField
    var right: TreeNode? = null
}