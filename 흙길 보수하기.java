import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();

        int[][] map = new int[N][2];
        for (int i = 0; i < N; i++) {
            map[i][0] = sc.nextInt();
            map[i][1] = sc.nextInt();
        }

        Arrays.sort(map, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int answer = 0;
        int dis = 0; //널빤지로 보수했을 때 끝점.
        for (int i = 0; i < N; i++) {
            int st = map[i][0];
            int ed = map[i][1];

            if (st > dis) { //dis를 st로 초기화하려면 dis가 st까지 보수를 하지 못했을 경우이다.
                dis = st;
            }

            if (ed > dis) { //dis가 ed까지 모두 덮을 때까지 반복해줘야 함.
                while (ed > dis) {
                    dis += L;
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}

/* 입력
3 3
1 6
13 17
8 12
*/

/* 출력
5
*/
