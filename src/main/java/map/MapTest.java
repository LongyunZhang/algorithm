package map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by longyun on 2018/10/12.
 */
public class MapTest {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add("1");

        Map<String, Integer> map = new HashMap<>();
        map.put("s1", 1);
        System.out.println(map.containsKey("s2"));
        System.out.println(map.containsKey("s1"));

        System.out.println(map.containsValue(1));
        System.out.println(map.containsValue(2));

        HashMap map1 = new HashMap();

    }
}
