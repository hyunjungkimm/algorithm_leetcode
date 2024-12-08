package 김현정.stack;

import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == '(' || arr[i] == '[' || arr[i] == '{') {
                stack.push(arr[i]);
            }else {
                if(stack.size() == 0) {
                    return false;
                }
                char output = stack.pop();
                if(arr[i] == ')' && output == '(') continue;
                else if(arr[i] == '}' && output == '{') continue;
                else if(arr[i] == ']' && output == '[') continue;
                return false;
            }
        }
        if(stack.size() > 0) {
            return false;
        }

        return true;
    }
}
