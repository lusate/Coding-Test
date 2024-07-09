package 프로그래머스;

import java.util.*;
public class 석유시추 {
    static int n, m;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[] oil;
    static boolean[][] visit;

    public int count(int x, int y, int[][] land){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visit[x][y] = true;

        int cnt = 1;
        Set<Integer> set = new HashSet<>();
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            set.add(tmp[1]);

            for(int k=0; k<4; k++){
                int nx = tmp[0] + dx[k];
                int ny = tmp[1] + dy[k];

                if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
                if(land[nx][ny] == 1 && !visit[nx][ny]){
                    visit[nx][ny] = true;
                    q.add(new int[]{nx,ny});
                    cnt++;
                }
            }
        }

        for(int idx : set){
            oil[idx] += cnt;
        }
        return cnt;
    }

    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        oil = new int[m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(land[i][j] == 1 && !visit[i][j]){
                    count(i, j, land);
                }
            }
        }

        answer = Arrays.stream(oil).max().getAsInt();
        return answer;
    }

    public static void main(String[] args) {
        석유시추 T = new 석유시추();
        System.out.println(T.solution(new int[][]{{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0},
                {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}}));
    }
}
