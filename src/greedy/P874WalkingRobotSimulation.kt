package greedy

import kotlin.test.assertEquals

/**
 * 模拟行走机器人
 */
object P874WalkingRobotSimulation {
    fun robotSim(commands: IntArray, obstacles: Array<IntArray>): Int {
        val dirsX = intArrayOf(0, 1, 0, -1)
        val dirsY = intArrayOf(1, 0, -1, 0)
        // 0是上 1是右 2是下 3是左
        var dir = 0
        var startX = 0
        var startY = 0
        var ans = 0
        val obsSet = mutableSetOf<Pair<Int, Int>>()
        for (obstacle in obstacles) {
            obsSet.add(Pair(obstacle[0], obstacle[1]))
        }
        for (command in commands) {
            when (command) {
                -1 -> {
                    dir = (dir + 1) % 4
                }
                -2 -> {
                    dir = (dir + 3) % 4
                }
                else -> {
                    for (i in 1..command) {
                        val nx = startX + dirsX[dir]
                        val ny = startY + dirsY[dir]
                        if (!obsSet.contains(Pair(nx, ny))) {
                            startX = nx
                            startY = ny
                            ans = maxOf(ans, startX * startX + startY * startY)
                        }
                    }
                }
            }
        }

        return ans
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(25, robotSim(intArrayOf(4, -1, 3), Array(1) { IntArray(2) }))
    }
}