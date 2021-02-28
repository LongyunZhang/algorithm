package string;

/**
 * 双指针
 */
public class ReverseString_344 {

    public static void main(String[] args) {
        String str = "abcdef";
        String res = reverse(str);
        System.out.println(res);
    }

    public static String reverse(String str) {
        char[] arr = str.toCharArray();
        int i = 0, j = arr.length - 1;
        for (; i < j; i++, j--) {
            char ch = arr[i];
            arr[i] = arr[j];
            arr[j] = ch;
        }
        return new String(arr);
    }
}
