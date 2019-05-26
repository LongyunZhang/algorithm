package recursion;

/**
 * Created by longyun on 2018/10/11.
 */
public class Fibonacci {
    //斐波那契额数列
    public static void main(String[] args) {
        for (int i = 1; i < 10 ; i++) {
            System.out.println(i + " --> " + fibonacci(i));
        }
    }

    public static int fibonacci(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n >= 3) {
            return fibonacci(n - 2) + fibonacci(n - 1);
        }
        return 0;
    }

}
