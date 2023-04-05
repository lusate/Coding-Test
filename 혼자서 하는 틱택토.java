// 졌을 때 -1로 설정하고 해도 풀 수 있음.
import java.util.*;
import java.util.*;
class Solution {
    public boolean win(char ch, char[][] map) {
        for(int i = 0; i < 3; i++) {
            //가로 이기는 경우
            if (map[i][0] == ch && map[i][1] == ch && map[i][2] == ch) {
                return true;
            }
            //세로 이기는 경우
            if (map[0][i] == ch && map[1][i] == ch && map[2][i] == ch) {
                return true;
            }
        }
        
        //대각선 이기는 경우
        if (map[0][0] == ch && map[1][1] == ch && map[2][2] == ch) {
            return true;
        }
        if (map[0][2] == ch && map[1][1] == ch && map[2][0] == ch) {
            return true;
        }
        return false;
    }
    public int solution(String[] board) {
        int answer = 1;
        char[][] map = new char[3][3];
        int oCnt = 0; //O 개수
        int xCnt = 0; //X 개수
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                map[i][j] = board[i].charAt(j);
                if (map[i][j] == 'O') {
                    oCnt++;
                }
                if (map[i][j] == 'X') {
                    xCnt++;
                }
            }
        }
        if (xCnt > oCnt || oCnt - xCnt > 1) {
            return 0;
        }
        if (win('O', map) && win('X', map)) {
            return 0;
        }
        if(win('O', map)) {
            if (oCnt == xCnt) { //O가 이겼는데 O개수와 X개수가 같으면 0
                return 0;
            }
        }
        if(win('X', map)) {
            if (oCnt > xCnt) { //X가 이겼는데 O를 해서 게임 더 진행하면 return 0
                return 0;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new String[]{"O.X", ".O.", "..X"}));
        System.out.println(T.solution(new String[]{"OOO", "...", "XXX"}));
        System.out.println(T.solution(new String[]{"...", ".X.", "..."}));
        System.out.println(T.solution(new String[]{"...", "...", "..."}));
    }
}

/* 출력
1
0
0
1
*/
