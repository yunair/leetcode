package bitoperator;

/**
 * 位1的个数
 */
class P191NumberOf1Bit {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        P191NumberOf1Bit solve = new P191NumberOf1Bit();
        System.out.println(solve.hammingWeight(11));
        System.out.println(solve.hammingWeight(-3));
    }
}
