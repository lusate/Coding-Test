import java.util.*;
class Info implements Comparable<Info>{
    int from;
    int to;
    int cnt;

    Info(int from, int to, int cnt) {
        this.from = from;
        this.to = to;
        this.cnt = cnt;
    }

    public int compareTo(Info ob) {
        if(this.to == ob.to) return this.from - ob.from;
        return this.to - ob.to;
    }
}
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //마을 수
        int C = sc.nextInt(); //용량
        int M = sc.nextInt(); //박스 정보 개수

        int[] truck = new int[N + 1];
        Info[] delivery = new Info[M];

        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cnt = sc.nextInt();
            delivery[i] = new Info(from, to, cnt);
        }
        Arrays.sort(delivery);
        //처음엔 택배가 아무 박스도 실은 게 없으므로 마을들을 택배 용량 C로 초기화.
        Arrays.fill(truck, C);

        int answer = 0;
        for (Info cur : delivery) {
            int s = cur.from;
            int e = cur.to;
            int cnt = cur.cnt;

            int min = Integer.MAX_VALUE;
            for (int i = s; i < e; i++) {
                min = Math.min(min, truck[i]);
            }

            int load = cnt;
            load = Math.min(load, min);

            answer += load;
            for (int i = s; i < e; i++) {
                truck[i] -= load;
            }
            // 즉 보내는 마을이 1, 받는 마을이 2면 1번 마을의 최대 용량 40에서 10을 뺀다.
            // answer = 10, 1번 마을에서 남은 용량은 30;
            // 보내는 마을이 2, 받는 마을이 3이면 1번 마을의 남은 용량 30에서 20을 뺀다.
            // answer = 30, 1번 마을에서 남은 용량 10, 2번 마을 남은 용량 20
            // 보내는 마을 1, 받는 마을이 4일 때 마을의 남은 용량에서 30을 빼려고 하는데 음수가 되므로
            // 남은 용량 최솟값인 10을 빼준다. -> 3번 마을은 30, 남은 마을은 0.
            // 2, 3일 때 20 빼려고 하니 음수가 나오므로 또 최솟값 0을 뺌.
            // 마지막 3, 받는 마을 4일 때 최대 용량 30에서 20을 뺌.
            // answer = 70
        }
        System.out.println(answer);
    }
}

/* 입력
4 40
6
3 4 20
1 2 10
1 3 20
1 4 30
2 3 10
2 4 20


6 60
5
1 2 30
2 5 70
5 6 60
3 4 40
1 6 40
*/


/* 출력
70
150
*/
