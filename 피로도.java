import java.util.*;
class Solution {
    int answer;
    int[] visit;
    public void dfs(int cnt, int k, int[][] dungeons){
        for(int i=0; i<dungeons.length; i++){
            if(visit[i] == 0 && k >= dungeons[i][0]){
                visit[i] = 1;
                dfs(cnt+1, k - dungeons[i][1], dungeons);
                visit[i] = 0;
            }
        }
        answer = Math.max(answer, cnt);
    }
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        visit = new int[dungeons.length];
        dfs(0, k, dungeons);

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));
    }
}

/* 출력
3
*/
