package stack;

import java.util.Stack;

public class MinStack_155 {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack_155() {
        stack = new Stack();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.peek() == minStack.peek()) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }


    public static void main(String[] args) {
        MinStack_155 minStack_155 = new MinStack_155();
        minStack_155.push(5);
        minStack_155.push(2);
        minStack_155.push(3);
        minStack_155.push(4);

        System.out.println("pop: " + minStack_155.top());
        minStack_155.pop();
        System.out.println("min: " + minStack_155.getMin());
    }





}
