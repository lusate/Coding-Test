import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        int[] mapX = new int[10];
        int[] mapY = new int[10];

        for (char c : X.toCharArray()) {
            mapX[c - 48]++; //mapX에 int형으로 저장.
        }
        for (char c : Y.toCharArray()) {
            mapY[c - 48]++;
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            for (int j=0; j<Math.min(mapX[i], mapY[i]); j++) {
                answer.append(i);
            }
        }


        if ("".equals(answer.toString())) {
            return "-1";
        } else if (answer.toString().charAt(0) == 48) {
            return "0";
        } else{
            return answer.toString();
        }

    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution("100", "2345"));
        System.out.println(T.solution("100", "203045"));
        System.out.println(T.solution("100", "123450"));
        System.out.println(T.solution("12321", "42531"));
        System.out.println(T.solution("5525", "1255"));
    }
}


/* 출력
"-1"
"0"
"10"
"321"
*/
