package 프로그래머스;

import java.util.*;

public class 짝지어_제거하기 {
    public int solution(String s){
        int answer = -1;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(stack.isEmpty()) stack.push(ch);
            else {
                if (ch == stack.peek()) stack.pop();
                else stack.push(ch);
            }
        }
        System.out.println(stack);
        if (stack.isEmpty()) {
            answer = 1;
        }else{
            answer = 0;
        }

        return answer;
    }

    public static void main(String[] args) {
        짝지어_제거하기 T = new 짝지어_제거하기();
        System.out.println(T.solution("baabaa"));
        System.out.println(T.solution("cdcd"));
    }
}
