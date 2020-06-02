package design.self

import java.lang.StringBuilder
import kotlin.random.Random

interface Queue<E> {
    fun enqueue(e: E)

    fun dequeue(): E

    fun getFront(): E

    fun getSize(): Int

    fun isEmpty(): Boolean
}

/**
 * 循环队列
 * 循环队列空间会浪费一个元素空间
 * front = tail 代表队列为空
 * (tail + 1) % length == front 代表队列满
 */
class LoopQueue<E>(capacity: Int? = null) : Queue<E> {
    //
    @Suppress("UNCHECKED_CAST")
    private var values: Array<E?> = if (capacity == null) {
        arrayOfNulls<Any?>(11) as Array<E?>
    } else {
        arrayOfNulls<Any?>(capacity + 1) as Array<E?>
    }

    private var front = 0
    private var tail = 0
    private var size = 0


    override fun enqueue(e: E) {
        if (isFull()) {
            resize(getCapacity() * 2)
        }
        values[tail] = e
        tail = (tail + 1) % values.size
        size++
    }

    private fun resize(newCapacity: Int) {
        @Suppress("UNCHECKED_CAST")
        val newValues: Array<E?> = arrayOfNulls<Any?>(newCapacity + 1) as Array<E?>
        for (i in 0 until size) {
            newValues[i] = values[(front + i) % values.size]
        }
        values = newValues
        front = 0
        tail = size
    }

    override fun dequeue(): E {
        val value = values[front]
        values[front] = null
        front = (front + 1) % values.size
        size--

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2)
        }
        return value!!
    }

    override fun getFront(): E {
        if (isEmpty()) {
            throw IllegalArgumentException("Queue is Empty")
        }
        return values[front]!!
    }

    override fun getSize(): Int {
        return values.size
    }

    fun getCapacity(): Int {
        return getSize() - 1
    }

    private fun isFull(): Boolean {
        return (tail + 1) % values.size == front
    }

    override fun isEmpty(): Boolean {
        return front == tail
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("Queue: size = $size, capacity = ${getCapacity()}\n")
        sb.append("front [")
        var i = front
        while (i != tail) {
            sb.append(values[i])
            i = (i + 1) % values.size
            if (i != tail) {
                sb.append(", ")
            }
        }
        sb.append("]")
        return sb.toString()
    }


}

class ArrayQueue<E>(capacity: Int? = null) : Queue<E> {
    private val arr = if (capacity == null) {
        MyArray<E>()
    } else {
        MyArray(capacity)
    }

    override fun enqueue(e: E) {
        arr.addLast(e)
    }

    override fun dequeue(): E {
        return arr.removeFirst()
    }

    override fun getFront(): E {
        return arr.getFirst()
    }

    override fun getSize(): Int {
        return arr.getSize()
    }

    override fun isEmpty(): Boolean {
        return arr.isEmpty()
    }

    fun getCapacity(): Int {
        return arr.getCapacity()
    }

    override fun toString(): String {
        return "Queue: front $arr tail"
    }
}

class LinkedListQueue<E> : Queue<E> {
    private val list = MyLinkedList<E>()
    override fun enqueue(e: E) {
        list.addLast(e)
    }

    override fun dequeue(): E {
        return list.removeFirst()!!
    }

    override fun getFront(): E {
        return list.getFirst()!!
    }

    override fun getSize(): Int {
        return list.getSize()
    }

    override fun isEmpty(): Boolean {
        return list.isEmpty()
    }

    override fun toString(): String {
        return "Queue: front $list tail"
    }


}

// 测试使用q运行opCount个enqueue和dequeue操作所需要的时间，单位:秒
fun testQueue(q: Queue<Int>, opCount: Int): Double {
    val startTime = System.nanoTime()

    for (i in 0 until opCount) {
        q.enqueue(Random.nextInt())
    }
    for (i in 0 until opCount) {
        q.dequeue()
    }
    val endTime = System.nanoTime()
    return (endTime - startTime) / 1000000000.0

}

fun main() {
    val opCount = 100000
    val time1 = testQueue(ArrayQueue(), opCount)
    println("array queue: $time1 s")
    val time2 = testQueue(LoopQueue(), opCount)
    println("loop queue: $time2 s")

    val time3 = testQueue(LinkedListQueue(), opCount)
    println("linked list queue: $time3 s")
}