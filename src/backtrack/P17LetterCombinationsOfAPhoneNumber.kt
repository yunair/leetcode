package backtrack

/**
 * 电话号码的字母组合
 */
object P17LetterCombinationsOfAPhoneNumber {
    private val map = mutableMapOf<String, MutableList<String>>()

    val ans = mutableListOf<String>()
    fun letterCombinations(digits: String): List<String> {
        if(digits.isEmpty()){
            return ans
        }
        map["2"] = arrayListOf("a", "b", "c")
        map["3"] = arrayListOf("d", "e", "f")
        map["4"] = arrayListOf("g", "h", "i")
        map["5"] = arrayListOf("j", "k", "l")
        map["6"] = arrayListOf("m", "n", "o")
        map["7"] = arrayListOf("p", "q", "r", "s")
        map["8"] = arrayListOf("t", "u", "v")
        map["9"] = arrayListOf("w", "x", "y", "z")
        val list = mutableListOf<List<String>>()
        for (c in digits) {
            list.add(map[c.toString()]!!)
        }
        backtrack(list, 0, "")
        return ans
    }

    private fun backtrack(characters: List<List<String>>, index: Int, content: String) {
        if (content.length == characters.size) {
            ans.add(content)
            return
        }
        val items = characters[index]
        for (s in items) {
            backtrack(characters, index + 1, content + s)
        }

    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(letterCombinations("23"))
    }
}