//2차원을 1차원으로 압축해서 푸는 것이 더 좋다.
import java.util.*;
class Solution{
    //1차원으로 압축했기 때문에 가로, 대각선 규칙만 보고 세로 규칙을 보지 않아도 된다.
    // 가로를 보면 Q의 위치 열값이 앞으로 놓일 열값과 동일하면 안된다.
    // 대각선을 보면 Q의 위치 행,열의 기울기가 동등하면 안된다.
    int[] board;
    int answer;
    public boolean possible(int row) {
        for (int i = 0; i < row; i++) {
            if (board[i] == board[row]) {
                return false;
            }
            if (Math.abs(row - i) == Math.abs(board[row] - board[i])) {
                return false;
            }
        }
        return true;
    }
    public void dfs(int n, int row) {
        if (row == n) {
            answer++;
            return;
        }
        for (int i = 0; i < n; i++) {
            // row는 열이고 i는 Q의 위치라 생각.
            board[row] = i; 
            if (possible(row)) {
                dfs(n, row + 1);
            }
        }

    }
    public int solution(int n) {
        //배열의 index를 행, 배열의 값을 열로 본다.
        //그러면 Q의 위치는 [1, 3, 0, 2]가 된다.
        answer = 0;
        board = new int[n];
        dfs(n, 0);
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(4));
    }
}
