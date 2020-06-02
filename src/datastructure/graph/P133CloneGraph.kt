package datastructure.graph

import java.util.*
import kotlin.collections.ArrayList

/**
 * 克隆图
 */
object P133CloneGraph {
    class Node(var `val`: Int) {
        var neighbors: ArrayList<Node?> = ArrayList()
    }

    fun cloneGraph(node: Node?): Node? {
        if (node == null) {
            return null
        }
        val visited = mutableMapOf<Node, Node>()
        visited[node] = Node(node.`val`)
        val queue = LinkedList<Node>()
        queue.addLast(node)
        while (queue.isNotEmpty()) {
            val cur = queue.poll()

            for (n in cur.neighbors) {
                if (!visited.containsKey(n)) {
                    // Clone the neighbor and put in the visited, if not present already
                    visited[n!!] = Node(n.`val`)
                    // Add the newly encountered node to the queue.
                    queue.addLast(n)
                }
                visited[cur]!!.neighbors.add(visited[n])
            }
        }
        return visited[node]
    }
}