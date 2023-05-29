import java.util.*;
import java.io.*;
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 트럭 개수
        int w = Integer.parseInt(st.nextToken()); // 다리 길이
        int L = Integer.parseInt(st.nextToken()); // 가능한 취대 무게

        int answer = 0;
        int sum = 0;
        int time = 0;
        Queue<Integer> q = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int truck = Integer.parseInt(st.nextToken());
            while (true) {
                if (q.isEmpty()) {
                    q.add(truck);
                    sum += truck;
                    time++;
                    break;
                }

                else if (q.size() < w) {
                    if (sum + truck <= L) {
                        q.add(truck);
                        sum += truck;
                        time++;
                        break;
                    }
                    else{
                        q.add(0);
                        time++;
                    }
                }

                else if(q.size() == w){
                    sum -= q.poll();
                }
            }
        }

        answer = time + w;
        System.out.println(answer);
    }
}

/* 입력
4 2 10
7 4 5 6
*/


/* 출력
8
*/
