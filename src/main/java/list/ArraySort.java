package list;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by longyun on 2018/11/12.
 */
public class ArraySort {
    public static void main(String[] args) {
        String[] arr = new String[]{"b2", "a1", "d4", "c3"};

        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String s1, String s2) {
                if (s1.charAt(0) > s2.charAt(0)) {
                    return 1;
                }
                if (s1.charAt(0) < s2.charAt(0)) {
                    return -1;
                }
                return 0;
            }
        });

        System.out.println(Arrays.toString(arr));
    }


}
