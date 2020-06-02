package design.self

import kotlin.random.Random
import kotlin.text.StringBuilder

interface Stack<E> {
    fun getSize(): Int
    fun isEmpty(): Boolean
    fun push(e: E)
    fun pop(): E
    fun peek(): E
}

class LinkedListStack<E> : Stack<E> {
    val list = MyLinkedList<E>()
    override fun getSize(): Int {
        return list.getSize()
    }

    override fun isEmpty(): Boolean {
        return list.isEmpty()
    }

    override fun push(e: E) {
        return list.addFirst(e)
    }

    override fun pop(): E {
        return list.removeFirst()!!
    }

    override fun peek(): E {
        return list.getFirst()!!
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("Stack: top ")
        sb.append(list)
        return sb.toString()
    }


}

class ArrayStack<E>(capacity: Int? = null) : Stack<E> {
    val arr: MyArray<E> = if (capacity == null) {
        MyArray()
    } else {
        MyArray(capacity)
    }

    override fun getSize(): Int {
        return arr.getSize()
    }

    override fun isEmpty(): Boolean {
        return arr.isEmpty()
    }

    override fun push(e: E) {
        arr.addLast(e)
    }

    override fun pop(): E {
        return arr.removeLast()
    }

    override fun peek(): E {
        return arr.getLast()
    }

    fun getCapacity(): Int {
        return arr.getCapacity()
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("Stack: ")
        sb.append("$arr")
        sb.append(" top")
        return sb.toString()
    }
}

fun main() {
//    val datastructure.stack = ArrayStack<Int>()
   /* val datastructure.stack = LinkedListStack<Int>()
    for (i in 0..5) {
        datastructure.stack.push(i)
        println(datastructure.stack)
    }
    datastructure.stack.pop()
    println(datastructure.stack)*/
    val opCount = 100000
    val time1 = testStack(ArrayStack(), opCount)
    println("ArrayStack, time: $time1 s")
    val time2 = testStack(LinkedListStack(), opCount)
    println("LinkedStack, time: $time2 s")
}

// 测试使用q运行opCount个enqueue和dequeue操作所需要的时间，单位:秒
fun testStack(stack: Stack<Int>, opCount: Int): Double {
    val startTime = System.nanoTime()

    for (i in 0 until opCount) {
        stack.push(Random.nextInt())
    }
    for (i in 0 until opCount) {
        stack.pop()
    }
    val endTime = System.nanoTime()
    return (endTime - startTime) / 1000000000.0

}