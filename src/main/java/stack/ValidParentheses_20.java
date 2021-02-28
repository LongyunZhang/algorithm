package stack;


import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 */
public class ValidParentheses_20 {

    public static void main(String[] args) {
        String str = "{}()[]";
        System.out.println(isValid(str));

        str = "{)()[]";
        System.out.println(isValid(str));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(' || arr[i] == '{' || arr[i] == '[') {
                stack.push(arr[i]);
            } else if (stack.isEmpty() || stack.pop() != arr[i]) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
