import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //사람 수

        ArrayList<int[]> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            res.add(new int[]{x, y}); // 몸무게, 키, 등수
        }

        for (int i = 0; i < n; i++) {
            int rank = 1;

            for (int j = 0; j < n; j++) {
                if(i == j) continue;
                if (res.get(i)[0] < res.get(j)[0] && res.get(i)[1] < res.get(j)[1]) {
                    rank++;
                }
            }

            System.out.print(rank + " ");
        }
    }
}


/* 입력
5
55 185
58 183
88 186
60 175
46 155
*/


/* 출력
2 2 1 2 5
*/
