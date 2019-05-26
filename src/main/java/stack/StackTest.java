package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by longyun on 2018/10/12.
 */
public class StackTest {

    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {};
        nextGreaterElement(nums1, nums2);

        int tmp=0;
        Stack<Integer> astack = new Stack<Integer>();
        astack.isEmpty();

        // 将10, 20, 30 依次推入栈中
        astack.push(10);
        astack.push(20);
        astack.push(30);
        astack.add(50);
        int size = astack.size();
        astack.pop();
        // 将“栈顶元素”赋值给tmp，并删除“栈顶元素”
        tmp = astack.pop();
        System.out.printf("tmp=%d\n", tmp);
        // 只将“栈顶”赋值给tmp，不删除该元素.
        tmp = (int)astack.peek();
        astack.push(40);
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Stack<Integer> stack = new Stack<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int num : nums2) {
            if (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]) != null ? map.get(nums1[i]) : -1;
        }
        return result;
    }
}
