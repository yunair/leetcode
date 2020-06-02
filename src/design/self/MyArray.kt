package design.self

import java.lang.StringBuilder

class MyArray<E>(capacity: Int) {
    @Suppress("UNCHECKED_CAST")
    private var values: Array<E?> = arrayOfNulls<Any?>(capacity) as Array<E?>
    private var size = 0

    constructor() : this(10)

    fun contains(e: E): Boolean {
        for (i in 0 until size) {
            if (values[i] == e) {
                return true
            }
        }
        return false
    }

    fun indexOf(e: E): Int {
        for (i in 0 until size) {
            if (values[i] == e) {
                return i
            }
        }
        return -1
    }

    fun removeAt(index: Int): E {
        checkIndexValid(index, "RemoveAt")
        val ret = values[index]!!
        for (i in index until size - 1) {
            values[i] = values[i + 1]
        }
        size--
        values[size] = null
        if (size == values.size / 4 && values.size >= 2) {
            resize(values.size / 2)
        }
        return ret
    }

    fun remove(e: E): Boolean {
        val index = indexOf(e)
        if (index != -1) {
            removeAt(index)
            return true
        }
        return false
    }

    fun removeLast(): E {
        return removeAt(size - 1)
    }

    fun removeFirst(): E {
        return removeAt(0)
    }

    fun removeAll(e: E): Boolean {
        var index = indexOf(e)
        if (index == -1) {
            return false
        }
        while (index != -1) {
            removeAt(index)
            index = indexOf(e)
        }
        return true
    }

    fun get(index: Int): E {
        checkIndexValid(index, "Get")
        return values[index]!!
    }

    fun getLast(): E {
        return get(size - 1)
    }

    fun getFirst(): E {
        return get(0)
    }

    fun set(index: Int, e: E) {
        checkIndexValid(index, "Set")
        values[index] = e
    }


    fun getSize(): Int {
        return size
    }

    fun getCapacity(): Int {
        return values.size
    }

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun addLast(e: E) {
        add(size, e)
    }

    fun addFirst(e: E) {
        add(0, e)
    }

    // 第index位置插入元素e
    fun add(index: Int, e: E) {
        checkIndexValid(index, "Add")
        if (size == values.size) {
            // 数组满了
            // 扩容
            resize(size * 2)
        }

        for (i in size downTo index + 1) {
            values[i] = values[i - 1]
        }
        values[index] = e
        size++
    }

    private fun resize(newCapacity: Int) {
        @Suppress("UNCHECKED_CAST")
        val newArr = arrayOfNulls<Any?>(newCapacity) as Array<E?>
        for (i in 0 until size) {
            newArr[i] = values[i]
        }
        values = newArr
    }

    private fun checkIndexValid(index: Int, method: String) {
        if (index < 0 || index > size) {
            throw IllegalArgumentException("$method failed, index require >= 0 and <= size")
        }
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("Array size = ${size}, capacity = ${values.size}\n")
        sb.append("[")
        for (i in 0 until size) {
            sb.append(values[i])
            if (i != size - 1) {
                sb.append(", ")
            }
        }
        sb.append("]")
        return sb.toString()
    }
}

fun main() {
    val arr = MyArray<Int>(2)
    for (i in 1..2) {
        arr.addLast(i)
    }
    println(arr)

    arr.add(1, 100)
    println(arr)

    arr.removeAt(2)
    println(arr)

    arr.remove(4)
    println(arr)

    arr.removeAt(0)
    println(arr)
}