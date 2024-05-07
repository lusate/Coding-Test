import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node{
    int end, score;

    Node(int end, int score) {
        this.end = end;
        this.score = score;
    }
}
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 도시
        int M = Integer.parseInt(st.nextToken()); // M개 이하의 도시를 지나는 여행
        int K = Integer.parseInt(st.nextToken());

        int answer = Integer.MIN_VALUE;

        ArrayList<Node>[] arr = new ArrayList[N + 1];
        // M번 도시를 방문한 경우를 모두 살펴보고 dp[N][1] ~ dp[N][M] 값 중 가장 큰 값을 리턴
        int[][] dp = new int[N + 1][M + 1]; // 즉 N으로 이동하는데 M번 이동을 했을 때의 점수를 넣는 배열

        for (int i = 0; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a > b) { // 동에서 서로만 가능하기 때문에
                continue;
            }

            // 단방향으로만 가능
            arr[a].add(new Node(b, c));
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1); // 시작 도시는 1이기 때문에

        int cnt = 1; // 몇 번 도시를 방문하는지 카운트 (한 번은 무조건 방문을 해야 함.)
        while (!q.isEmpty() && cnt < M) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int now = q.poll();
                for(Node nextNode : arr[now]){
                    int nextIndex = nextNode.end; // 다음 도착 도시
                    int nextScore = dp[now][cnt]+nextNode.score;

                    if(dp[nextIndex][cnt+1] >= nextScore){
                        continue;
                    }

                    dp[nextIndex][cnt+1] = nextScore;

                    q.add(nextIndex);

                }
            }
            cnt++;
        }

        for (int i = 2; i <= M; i++) {
            answer = Integer.max(answer, dp[N][i]);
        }
        System.out.println(answer);
    }
}
