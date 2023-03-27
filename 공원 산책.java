import java.util.*;
class Solution{
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        Boolean found = false;
        int sx = 0, sy = 0;
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    found = true;
                    sx = i;
                    sy = j;
                    break;
                }
            }

            if (found) {
                break;
            }
        }

        int n = park.length;
        int m = park[0].length();

        for (String x : routes) {
            String a = x.split(" ")[0];
            Integer b = Integer.parseInt(x.split(" ")[1]);

            if (a.equals("N")) {
                if(sx - b < 0) continue; //범위 초과
                Boolean block = false;
                for (int i = 1; i <= b; i++) {
                    if (park[sx - i].charAt(sy) == 'X') {
                        block = true;
                        break;
                    }
                }
                
                if(block) continue;

                // 위치로 이동
                sx = sx - b;
            } else if (a.equals("W")) {
                if (sy - b < 0) {
                    continue;
                }

                Boolean block = false;
                for (int i = 1; i <= b; i++) {
                    if (park[sx].charAt(sy - i) == 'X') {
                        block = true;
                        break;
                    }
                }
                if(block) continue;
                sy = sy - b;

            } else if (a.equals("S")) {
                if(sx + b > n-1){
                    continue;
                }

                Boolean block = false;
                for (int i = 1; i <= b; i++) {
                    if (park[sx+i].charAt(sy) == 'X') {
                        block = true;
                        break;
                    }
                }
                if(block) continue;

                sx = sx + b;
            } else if (a.equals("E")) {
                if (sy + b > m-1) {
                    continue;
                }

                Boolean block = false;
                for (int i = 1; i <= b; i++) {
                    if (park[sx].charAt(sy + i) == 'X') {
                        block = true;
                        break;
                    }
                }
                if (block) {
                    continue;
                }
                sy = sy + b;
            }
        }

        answer[0] = sx;
        answer[1] = sy;

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new String[]{"SOO","OOO","OOO"}, new String[]{"E 2","S 2","W 1"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"SOO","OXX","OOO"}, new String[]{"E 2","S 2","W 1"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"OSO","OOO","OXO","OOO"}, new String[]{"E 2","S 3","W 1"})));
    }
}


/* 출력
[2, 1]
[0, 1]
[0, 0]
*/
