package backtrack


/**
 * 二进制手表
 */
object P401BinaryWatch {
    val ans = mutableListOf<String>()
    fun readBinaryWatch(num: Int): List<String> {
        ans.clear()
        backtrack(num, 0, BooleanArray(10), Pair(0, 0), 0)
        return ans
    }

    private fun backtrack(num: Int, start: Int, visited: BooleanArray, time: Pair<Int, Int>, optime: Int) {
        if (optime == num) {
            ans.add("%d:%02d".format(time.first, time.second))
            return
        }

        for (i in start until 10) {
            if (visited[i]) {
                continue
            }
            var newHour = time.first
            var newMinute = time.second
            if (i <= 3) {
                if ((1 shl (3 - i)) or newHour > 11) {
                    continue
                }
                newHour = (1 shl (3 - i)) or newHour

            } else {
                if ((1 shl (9 - i)) or newMinute > 59) {
                    continue
                }
                newMinute = (1 shl (9 - i)) or newMinute
            }
            visited[i] = true

            backtrack(num, i + 1, visited, Pair(newHour, newMinute), optime + 1)
            visited[i] = false
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
//        ["0:03","0:05","0:06","0:09","0:10","0:12","0:17","0:18","0:20","0:24","0:33","0:34","0:36","0:40","0:48","1:01","1:02","1:04","1:08","1:16","1:32","2:01","2:02","2:04","2:08","2:16","2:32","3:00","4:01","4:02","4:04","4:08","4:16","4:32","5:00","6:00","8:01","8:02","8:04","8:08","8:16","8:32","9:00","10:00"]
        println(readBinaryWatch(4))
    }
}