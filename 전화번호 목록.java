import java.util.*;

class Solution{
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Set<String> set = new HashSet<>();

        for (String x : phone_book) {
            set.add(x);
        }

        for (String x : phone_book) {
            for (int i = 0; i < x.length(); i++) {
                if (set.contains(x.substring(0, i))) {
                    answer = false;
                }
            }
        }

        return answer;
    }


    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(T.solution(new String[]{"123","456","789"}));
        System.out.println(T.solution(new String[]{"12","123","1235","567","88"}));
    }
}

/* 출력
false
true
false
*/
