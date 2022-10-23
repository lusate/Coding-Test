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
			int d = 0;
			for(int i=1; i<=n*n; i++) {
				arr[x][y] = i;
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx < 0 || nx >= n || ny < 0 || ny >= n || arr[nx][ny] != 0) {  //경계 벗어나거나, 숫자가 이미 존재하면
					d = (d + 1) % 4;  //방향바꿈  
					nx = x + dx[d];
					ny = y + dy[d];
				}
				x = nx;
				y = ny;
			}
			System.out.println("#" + test_case);
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++)
					System.out.print(arr[r][c] + " ");
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
