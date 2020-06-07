package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by longyun on 2018/10/16.
 */
public class ArrayTest {
    public static void main(String[] args) {
        int a = Integer.MAX_VALUE;

        //array init 初始化  new int[]{x,y,z}
        int[] arr = new int[]{5, 4, 2, 2, 1, 3};

        //array sort
        Arrays.sort(arr);
        //Arrays.asList();
        System.out.println(Arrays.toString(arr));

        //binary search
        int index = Arrays.binarySearch(arr, 2);
        System.out.println(index);

        //set --> array
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(6);
        Integer[] arrSet = set.toArray(new Integer[set.size()]);
        System.out.println(Arrays.toString(arrSet));
    }
}
