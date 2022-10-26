import java.util.*;
import java.io.*;

class Solution{
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 }; // 우하좌상 순서
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int arr[][] = new int[n][n];
			
			int x = 0, y = 0;
			int d = 1; //첫 번째로 입력하는 숫자.
			arr[x][y] = d; //해당하는 위치에 숫자 입력
			d++; //입력 후 숫자 올려주기

			for(int i=1; i<=2*n-1; i++) { // 2n-1 로 방향이 바뀌는 횟수
				while(x <= n){
					int nx = x + dx[i%4]; // 처음은 +(0,1) -> 우측으로 진행
                    int ny = y + dy[i%4]; // 두번째 +(1,0) v 아래로 방향 진행
                                           // 세번째 +(0,-1) <- 왼쪽으로 진행
                                           // 네번째 +(-1,0) ^ 위로 방향 진행
                    
                    if(nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] == 0) {
                        // arr[][]==0 -> 이미 뭔가 들어 있으면 안된다.

                        arr[nx][ny] = d++;
                    } 
					else { //조건이 안되면 방향을 바꿔줘야하므로 break
                        break;
                    }
                    x = nx; //위치 업데이트
                    y = ny;
				}
			}
			System.out.println("#" + test_case);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++)
					System.out.print(arr[i][j] + " ");
				System.out.println();
			}
		}
	}
}


/* 입력
2    
3   
4
*/

/* 출력
#1
1 2 3
8 9 4
7 6 5
#2
1 2 3 4
12 13 14 5
11 16 15 6
10 9 8 7
*/
