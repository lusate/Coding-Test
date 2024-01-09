import java.util.*;
public class 크레인_인형뽑기 {
    public int solution(int[][] board, int[] moves){
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int pos: moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][pos - 1] != 0) {
                    int num = board[i][pos - 1];
                    board[i][pos - 1] = 0;

                    if (!stack.isEmpty() && num == stack.peek()) {
                        answer += 2;
                        stack.pop();
                    }else{
                        stack.push(num);
                    }

                    break; // stack에 넣었거나 뺏으면 다음 moves로 가야 하는데 break를 하지 않으면 각 열마다 바닥이 보일 때까지 계속 뺌
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        크레인_인형뽑기 T = new 크레인_인형뽑기();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int[][] board=new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j]=kb.nextInt();
            }
        }
        int m=kb.nextInt();
        int[] moves=new int[m];
        for(int i=0; i<m; i++) moves[i]=kb.nextInt();
        System.out.println(T.solution(board, moves));
    }
}
