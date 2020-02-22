package backtrack

import kotlin.test.assertEquals

/**
 * 活字印刷
 */
object P1079LetterTilePossibilities {
    var count = 0
    fun numTilePossibilities(tiles: String): Int {
        count = 0
        backtrack(tiles, "", BooleanArray(tiles.length))
        return count
    }

    private fun backtrack(tiles: String, str: String, visited: BooleanArray) {
        if (str.length == tiles.length) {
            return
        }
        val set = mutableSetOf<Char>()
        for (i in tiles.indices) {
            if (visited[i]) {
                continue
            }
            if (set.contains(tiles[i])) {
                continue
            }
            set.add(tiles[i])

            visited[i] = true
            count++
            backtrack(tiles, str + tiles[i], visited)
            visited[i] = false
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(8, numTilePossibilities("AAB"))
        assertEquals(188, numTilePossibilities("AAABBC"))
    }
}