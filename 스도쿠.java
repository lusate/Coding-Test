import java.util.*;
public class Main {
	static int[][] map;
	private static boolean check(int row, int col, int num){ // 행, 열, 3x3 이 1~9까지가 맞는지 확인.
		for(int i=0; i<9; i++){
			//num은 행에 있는 번호
			if(map[row][i] == num){
				return false; //있는 번호인데 한 번 더 쓰면 false
			}
		}

		//열도 똑같이.
		for(int i=0; i<9; i++){
			if(map[i][col] == num){
				return false;
			}
		}

		//3x3에서
		int nrow = (row/3)*3; //row와 col은 0부터 시작이다.
		int ncol = (col/3)*3; //nrow와 ncol은 6까지 감.
		System.out.println("nrow = " + nrow);
		System.out.println("ncol = " + ncol);
		
		for(int i = nrow ; i < nrow+3 ; i ++) {
			for(int j = ncol ; j < ncol +3 ; j++) {
				if(map[i][j] == num)
					return false;
			}
		}

		return true;
	}
	private static void dfs(int row, int col) {
		//col이 9에 다다르면 col을 플러스해줌.
		if(col == 9){
			dfs(row+1, 0);
			return;
		}

		//답이 나오는 부분
		if(row == 9){ //마지막 9,9 까지 다 오면 출력.
			for(int i=0; i<9; i++){
				for(int j=0; j<9; j++){
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			System.exit(0);
		}
		// 0으로 비어있는 칸이라면 숫자 넣어줌. 1~9까지 체크해서 값을 넣어줌.
		if(map[row][col] == 0){
			for(int i=0; i<9; i++){ // 0~8
				if(check(row, col, i+1)){ //0~9로 해줌.
					map[row][col] = i+1;
					dfs(row, col+1);
				}
			}
			map[row][col]=0;
			return;
		}
		
		dfs(row, col+1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[9][9];
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				map[i][j] = sc.nextInt();
			}
		}

		dfs(0, 0);
	}
}


/* 입력
0 3 5 4 6 9 2 7 8
7 8 2 1 0 5 6 0 9
0 6 0 2 7 8 1 3 5
3 2 1 0 4 6 8 9 7
8 0 4 9 1 3 5 0 6
5 9 6 8 2 0 4 1 3
9 1 7 6 5 2 0 8 0
6 0 3 7 0 1 9 5 2
2 5 8 3 9 4 7 6 0
*/


/* 출력
1 3 5 4 6 9 2 7 8
7 8 2 1 3 5 6 4 9
4 6 9 2 7 8 1 3 5
3 2 1 5 4 6 8 9 7
8 7 4 9 1 3 5 2 6
5 9 6 8 2 7 4 1 3
9 1 7 6 5 2 3 8 4
6 4 3 7 8 1 9 5 2
2 5 8 3 9 4 7 6 1
*/
