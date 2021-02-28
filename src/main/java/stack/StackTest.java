package stack;

import java.util.*;

/**
 * Created by longyun on 2018/10/12.
 */
public class StackTest {

    public static void main(String[] args) {

        stackMethods();

        linkedListMethods();

        arrayDequeMethods();
    }

    public static void stackMethods() {
        System.out.println("--------- stack methods ---------");
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.add(40);
        stack.add(50);
        stack.add(60);

        System.out.println("isEmpty: " + stack.isEmpty() + ", size: " + stack.size());
        System.out.println("peek(): " + stack.peek() + ", size: " + stack.size());
        System.out.println("pop(): " + stack.pop() + ", size: " + stack.size());
    }

    public static void linkedListMethods() {
        System.out.println("--------- list methods ---------");
        LinkedList<Integer> list = new LinkedList<>();

        //add() = offer(): 加到尾
        list.add(1);list.add(2);list.add(3);list.add(4);list.add(5);
        //offer(): 加到尾
        list.offer(7);

        //push(): 加到头
        list.push(6);
        System.out.println("isEmpty: " + list.isEmpty() + ", size: " + list.size());

        System.out.println("peek(头): " + list.peek() + ", size: " + list.size());
        System.out.println("peekFirst(头): " + list.peekFirst() + ", size: " + list.size());
        System.out.println("peekLast(尾): " + list.peekLast() + ", size: " + list.size());
        System.out.println("pop(头): " + list.pop() + ", size: " + list.size());
        System.out.println("poll(头): " + list.poll() + ", size: " + list.size());
        System.out.println("pollFirst(头): " + list.pollFirst() + ", size: " + list.size());
        System.out.println("pollLast(尾): " + list.pollLast() + ", size: " + list.size());
    }

    public static void arrayDequeMethods() {
        System.out.println("--------- ArrayDeque methods ---------");
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(1);arrayDeque.add(2);arrayDeque.add(3);
        arrayDeque.add(4);arrayDeque.add(5);arrayDeque.add(6);

        System.out.println("isEmpty: " + arrayDeque.isEmpty() + ", size: " + arrayDeque.size());
        System.out.println("peek(头): " + arrayDeque.peek() + ", size: " + arrayDeque.size());
        System.out.println("peekLast(尾): " + arrayDeque.peekLast() + ", size: " + arrayDeque.size());
        System.out.println("poll(头): " + arrayDeque.poll() + ", size: " + arrayDeque.size());
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
