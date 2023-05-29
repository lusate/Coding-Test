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
        Queue<Integer> q = new LinkedList<>();
        int time = 0;
        int sum = 0;

        int[] truck = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            truck[i] = Integer.parseInt(st.nextToken());

            while (true) {
                if (q.isEmpty()) {
                    q.add(truck[i]);
                    sum += truck[i];
                    time++;
                    break;
                }
                else if(q.size() < w) {
                    if (sum + truck[i] <= L) {
                        q.add(truck[i]);
                        sum += truck[i];
                        time++;
                        break;
                    }
                    else {
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
프로그래머스 다리를 지나는 트럭과 같은 
*/
