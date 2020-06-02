package math

/**
 * 水壶问题
 */
object P365WaterAndJugProblem {
    /**
     * 预备知识：贝祖定理(https://baike.baidu.com/item/%E8%A3%B4%E8%9C%80%E5%AE%9A%E7%90%86/5186593)
     * 目标: 找到一对整数 a, b，使得ax+by=z
     * 而只要满足 z <= x+y，且这样的 a, b 存在，那么我们的目标就是可以达成的。
     */
    fun canMeasureWater(x: Int, y: Int, z: Int): Boolean {
        if (x + y < z) {
            return false
        }
        if (x == 0 || y == 0) {
            return z == 0
        }
        val gcd = gcd(x, y)
        return z % gcd == 0
    }

    private fun gcd(a: Int, b: Int): Int {
        return when {
            a > b -> {
                gcd(a - b, b)
            }
            a < b -> {
                gcd(b - a, a)
            }
            else -> {
                b
            }
        }
    }

    /**
     * 辗转相除法
     */
    private fun gcd2(a: Int, b: Int): Int {
        if (b == 0) {
            return a
        }

        return gcd2(b, a % b)
    }
}