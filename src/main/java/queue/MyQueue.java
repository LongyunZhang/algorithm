package queue;

import java.util.Stack;

/**
 * Created by longyun on 2018/10/14.
 */
//用栈实现队列
public class MyQueue {
    Stack<Integer> input = new Stack();
    Stack<Integer> output = new Stack();

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        peek();
        return output.pop();
    }

    public int peek() {
        if (output.empty())
            while (!input.empty())
                output.push(input.pop());
        return output.peek();
    }

    public boolean empty() {
        return input.empty() && output.empty();
    }

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
         obj.push(1);
         obj.push(2);
         obj.push(3);

         int param_2 = obj.pop();
         int param_3 = obj.peek();
         boolean param_4 = obj.empty();
        System.out.println();
    }
}
