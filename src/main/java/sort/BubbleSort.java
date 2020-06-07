package sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 1, 2, 4};
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 从小到大排序
     * @param arr
     */
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {//总共len-1轮比较（最后只剩1个数字的时候，无需比较）
            for (int j = 0; j < arr.length - 1 - i; j++) {//在第i轮比较完成之后，最后边的i个数字已经排好序了，所以只需比较前边的数字
                if (arr[j] > arr[j + 1]) {//将较大的值移到后边
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }
}
