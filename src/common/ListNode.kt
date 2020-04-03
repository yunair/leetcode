@file:JvmName("ListNode")

package common

class ListNode(@JvmField var `val`: Int) {
    @JvmField
    var next: ListNode? = null
    override fun toString(): String {
        return "ListNode(`val`=$`val`)"
    }
}