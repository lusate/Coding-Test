import java.util.*;
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            String s = sc.next();
			
			System.out.println("#" + test_case + " " + solution(s));
        }
    }
 
    private static int solution(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int cnt = 0;
 
        boolean flag = false;
        for (char ch : chars) {
            if (flag) {
                if (ch == ')' || ch == '|') cnt++;
                flag = false;
            } 
			else if (ch == '(') flag = true;
            
			else if (ch == ')' && (stack.peek() == '|' || stack.peek() == '(')) {
                cnt++;
            }
            
			stack.push(ch);
        }

		return cnt;
    }
}


/* 입력
3
||||||
(|..|)
.|.(|...||)|...()..
*/

/* 출력
#1 0
#2 2
#3 3
*/
