import java.util.*;
public class Main {
    static int N;
    static int[] building;
    static int[] answer;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        building = new int[N];
        answer = new int[N];

        for (int i = 0; i < N; i++) {
            building[i] = sc.nextInt();
        }

        for (int i = 0; i < N - 1; i++) {
            answer[i]++;  // 해당 index 오른쪽 건물은 무조건 보이므로 +1
            answer[i + 1]++;  // 해당 index 오른쪽 건물은 해당 index 건물이 보이므로 +1

            double slope = building[i + 1] - building[i];

            for (int j = i + 2; j < N; j++) {
                double nextSlope = (double) (building[j] - building[i]) / (j - i);
                // 해당 index+2부터 오른쪽으로만 탐색 시작
                // 다음 빌딩과의 기울기가 더 커야 그 빌딩을 볼 수가 있다.
                if(nextSlope > slope){
                    slope= nextSlope;
                    answer[i]++;
                    answer[j]++;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < answer.length; i++) {
            max = Math.max(max, answer[i]);
        }

        System.out.println(max);
    }
}


/* 입력
15
1 5 3 2 6 3 2 6 4 2 5 7 3 1 5

1
10
*/

/* 출력
7
0
*/
