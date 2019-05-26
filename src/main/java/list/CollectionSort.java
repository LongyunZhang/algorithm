package list;

import java.util.*;

/**
 * Created by longyun on 2018/11/11.
 */
public class CollectionSort {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("b2");
        list.add("a1");
        list.add("q5");
        list.add("d3");

        Collections.sort(list, new Comparator<String>(){
            public int compare(String s1, String s2) {
                if (s1.charAt(0) > s2.charAt(0)) {
                    return 1;
                }
                if (s1.charAt(0) < s2.charAt(0)) {
                    return -1;
                }
                return 0;
            }});

        System.out.println(Arrays.toString(list.toArray(new String[list.size()])));
    }
}
