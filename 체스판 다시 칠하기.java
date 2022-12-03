import java.util.*;
class Main {
    private static int solution(int m, int n, String[] map) {
        String[] str = { "WBWBWBWB", "BWBWBWBW" };
        int white = 0; //다시 칠해야할 흰색 개수.
        for (int i = 0; i < 8; i++) {
            int row = m + i;
            for (int j = 0; j < 8; j++) {
                int col = n + j;
				// map[row].charAt(col) 내가 자른 체스판과 진짜 정답지랑 같은지 다른지를 계산
                if (map[row].charAt(col) != str[row % 2].charAt(j)) white++;
            }
        }
		//64 - white 는 다시 칠해야할 검은색 수.
        return Math.min(white, 64 - white);
    }
    
    public static void main(String[] args) {
        // 0. input 받기
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        String[] board = new String[m];
        for (int i = 0; i < m; i++) {
			board[i] = sc.next();
		}

		//좌 상단이 B 이면 Black 체스판, W이면 White 체스판이라고 한다.
        // 1. 체스판 자르기
        int sol = Integer.MAX_VALUE;
        for (int i = 0; i <= m - 8; i++) {
            for (int j = 0; j <= n - 8; j++) {
                // 2. 현 체스판의 최소 비용 구하기
                int curSol = solution(i, j, board);
                // 3. 전체 최적의 값과 비교하여 갱신하기
                if (sol > curSol) sol = curSol;
            }
        }

        System.out.println(sol);
    }
}
/**
 * W W
 * W B
 * 라고 한다면 
 * Black 체스판으로 바꾼다고 한다면 
 * B W
 * W B  COUNT = 1
 * 
 * White 체스판으로 바꾼다고 한다면
 * W B
 * B W 해서 COUNT = 3
 * 
 * 그래서 답은 최소 개수인 1이 된다.
 * 결론 -> 내 현재 상태랑 블랙 체스판, 화이트 체스판 다 비교해보고 둘 중에 최솟값을 출력한다.
 */

/* 입력
10 13
BBBBBBBBWBWBW
BBBBBBBBBWBWB
BBBBBBBBWBWBW
BBBBBBBBBWBWB
BBBBBBBBWBWBW
BBBBBBBBBWBWB
BBBBBBBBWBWBW
BBBBBBBBBWBWB
WWWWWWWWWWBWB
WWWWWWWWWWBWB


8 8
BWBWBWBW
WBWBWBWB
BWBWBWBW
WBWBWBWB
BWBWBWBW
WBWBWBWB
BWBWBWBW
WBWBWBWB
*/


/* 출력
12

0
*/
