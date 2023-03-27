import java.util.*;
class Solution {
    int[] visit;
    int count;
    public int dfs(int cnt, int k, int[][] dungeons){
        for(int i=0; i<dungeons.length; i++){
            if(visit[i] == 0 && k >= dungeons[i][0]){
                visit[i] = 1;
                dfs(cnt+1, k - dungeons[i][1], dungeons);
                visit[i] = 0;
            }
        }
        count = Math.max(a, count);
        return count;
    }
    public int solution(int k, int[][] dungeons) {
        int answer = 0;
        visit = new int[dungeons.length];
        answer = dfs(0, k, dungeons);
        
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
