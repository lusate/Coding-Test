// 졌을 때 -1로 설정하고 해도 풀 수 있음.
import java.util.*;
class Solution{
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] graph = new int[n + 1][n + 1];

        for(int i=0; i<results.length; i++){
            graph[results[i][0]][results[i][1]] = 1; // 이기면 1롤 체크
        }

        for(int k=0; k<=n; k++){
            for(int i=0; i<=n; i++){
                for(int j=0; j<=n; j++){
                    if(graph[i][k] == 1 && graph[k][j] == 1){
                        graph[i][j] = 1;
                        //ex) [4,2] 이고 [2,5]라면 [4,5]가 성립된다.
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++){
                if(graph[i][j] == 1 || graph[j][i] == 1){
                    cnt++;
                }
            }
            if(cnt == n-1){
                answer++; // n명의 선수가 있을 때 각 선수의 순위를 확정지으려면
                // 각 선수 별로 n-1 의 승패 수를 알아야 한다.
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(8, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));

    }
}


/* 출력
2
*/
