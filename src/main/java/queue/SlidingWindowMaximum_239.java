package queue;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 * <p>
 * https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 *
 * 解题思路与 MinStack 155 类似
 */
public class SlidingWindowMaximum_239 {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0)
            return new int[0];

        //单调队列：记录当前窗口时，从大到小的窗口内的元素值（顺序与窗口元素的顺序一致）
        Deque<Integer> deque = new LinkedList<>();
        //共有 (n-k+1) 个窗口
        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < k; i++) { // 未形成窗口
            while (!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();


        // 形成窗口后
        //滑动窗口： 左边界范围   [1 - k, n + 1 - k] , 右边界范围 [0, n−1]
        //遍历nums数组，每轮保证单调队列queue
        for (int i = k; i < nums.length; i++) {
            if (deque.peekFirst() == nums[i - k])
                deque.removeFirst();

            while (!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();

            deque.addLast(nums[i]);

            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] res = maxSlidingWindow(nums, k);
        System.out.println(res);
    }
}
