package basic;

/**
 * 斐波那契数列———— 多种实现
 */
public class Fibonacci {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(fibonacci_1(40));
        System.out.println((System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        System.out.println(fibonacci_2(40));
        System.out.println((System.currentTimeMillis() - startTime) + "ms");
    }

    /**
     * 递归
     */
    public static int fibonacci_1(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacci_1(n - 2) + fibonacci_1(n - 1);
    }

    /**
     * 动态规划
     * <p>
     * 数组保存法——————n个变量记录中间结果，避免重复计算
     * <p>
     * 时间复杂度： O(n)
     * 时间复杂度： O(n)
     */
    public static int fibonacci_2(int n) {
        int[] fib = new int[n];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 2] + fib[i - 1];
        }
        return fib[n - 1];
    }

    /**
     * 两个变量保存计算值，传递给下一次进行计算
     * <p>
     * 时间复杂度： O(n)
     * 空间复杂度： O(1)
     */
    public int fibonacci_3(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        int first = 1;
        int second = 1;
        int third = 2;
        for (int i = 3; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }

}
