import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken()); // 학생 명 수
        int M = Integer.parseInt(st.nextToken()); // 질문 M번
        int X = Integer.parseInt(st.nextToken()); // 선택 학생 번호

        List<Integer>[] lose = new List[N+1];
        List<Integer>[] win = new List[N+1];
        for(int i = 1; i <= N ; i++){
            win[i] = new LinkedList<>();
            lose[i] = new LinkedList<>();
        }
        for(int i = 0 ;  i < M ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int winner = Integer.parseInt(st.nextToken());
            int loser = Integer.parseInt(st.nextToken());

            win[loser].add(winner);
            lose[winner].add(loser);
        }
        int winnerCnt = countPeople(X,win,N);
        int loserCnt = countPeople(X,lose,N);



        System.out.println( winnerCnt +" "+ (N - loserCnt + 1) );
    }

    // X에게 이긴 사람의 수와 진 사람의 수를 찾는다.
    private static int countPeople(int num, List<Integer>[] map,int n){
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        q.offer(num);
        visited[num] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            cnt++;

            for(int next : map[now]){
                if(visited[next]){
                    continue;
                }
                visited[next] = true;
                q.offer(next);
            }
        }
        return cnt;
    }
}
