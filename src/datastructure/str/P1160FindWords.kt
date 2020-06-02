package datastructure.str

import kotlin.test.assertEquals

/**
 * 拼写单词
 */
object P1160FindWords {
    fun countCharacters(words: Array<String>, chars: String): Int {
        val arr = IntArray(26)
        for (c in chars) {
            arr[c - 'a']++
        }

        var count = 0
        for (word in words) {
            val aim = arr.clone()
            var find = true
            for (c in word) {
                aim[c-'a']--
                val v = aim[c-'a']

                if (v < 0) {
                    find = false
                    break
                }
            }
            if (find) {
                count += word.length
            }
        }
        return count
    }

    @JvmStatic
    fun main(args: Array<String>) {
//        assertEquals(6, countCharacters(arrayOf("cat","bt","hat","tree"), "atach"))
//        assertEquals(10, countCharacters(arrayOf("hello","world","leetcode"), "welldonehoneyr"))
        assertEquals(
            0, countCharacters(
                arrayOf(
                    "dyiclysmffuhibgfvapygkorkqllqlvokosagyelotobicwcmebnpznjbirzrzsrtzjxhsfpiwyfhzyonmuabtlwin",
                    "ndqeyhhcquplmznwslewjzuyfgklssvkqxmqjpwhrshycmvrb",
                    "ulrrbpspyudncdlbkxkrqpivfftrggemkpyjl",
                    "boygirdlggnh",
                    "xmqohbyqwagkjzpyawsydmdaattthmuvjbzwpyopyafphx",
                    "nulvimegcsiwvhwuiyednoxpugfeimnnyeoczuzxgxbqjvegcxeqnjbwnbvowastqhojepisusvsidhqmszbrnynkyop",
                    "hiefuovybkpgzygprmndrkyspoiyapdwkxebgsmodhzpx",
                    "juldqdzeskpffaoqcyyxiqqowsalqumddcufhouhrskozhlmobiwzxnhdkidr",
                    "lnnvsdcrvzfmrvurucrzlfyigcycffpiuoo",
                    "oxgaskztzroxuntiwlfyufddl",
                    "tfspedteabxatkaypitjfkhkkigdwdkctqbczcugripkgcyfezpuklfqfcsccboarbfbjfrkxp",
                    "qnagrpfzlyrouolqquytwnwnsqnmuzphne",
                    "eeilfdaookieawrrbvtnqfzcricvhpiv",
                    "sisvsjzyrbdsjcwwygdnxcjhzhsxhpceqz",
                    "yhouqhjevqxtecomahbwoptzlkyvjexhzcbccusbjjdgcfzlkoqwiwue",
                    "hwxxighzvceaplsycajkhynkhzkwkouszwaiuzqcleyflqrxgjsvlegvupzqijbornbfwpefhxekgpuvgiyeudhncv",
                    "cpwcjwgbcquirnsazumgjjcltitmeyfaudbnbqhflvecjsupjmgwfbjo",
                    "teyygdmmyadppuopvqdodaczob",
                    "qaeowuwqsqffvibrtxnjnzvzuuonrkwpysyxvkijemmpdmtnqxwekbpfzs",
                    "qqxpxpmemkldghbmbyxpkwgkaykaerhmwwjonrhcsubchs"
                ), "usdruypficfbpfbivlrhutcgvyjenlxzeovdyjtgvvfdjzcmikjraspdfp"
            )
        )
    }
}