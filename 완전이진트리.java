import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int answer;
    static int K;
    static int[] arr;
    static List<ArrayList<Integer>> graph = new ArrayList<>();

    private static void dfs(int depth, int st, int ed) {
        if (depth == K) {
            return;
        }

        int mid = (st + ed) / 2;
        graph.get(depth).add(arr[mid]); // 루트

        dfs(depth+1, st, mid-1); // 왼쪽
        dfs(depth+1, mid+1, ed); // 오른쪽
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine()); // 깊이
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int length = (int) (Math.pow(2, K) - 1); // 입력 개수
        arr = new int[length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < K; i++) {
            graph.add(new ArrayList<>());
        }

        dfs(0, 0, arr.length - 1);

        for (int i = 0; i < K; i++) {
            for (int j : graph.get(i)) {
                sb.append(j).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
