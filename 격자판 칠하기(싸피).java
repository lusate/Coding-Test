import java.util.*;
class Solution {
	static char[][] board;
	static int[] arr;
	static int n, m = 0;
	private static void solution() {
		arr = new int[4];
        for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(board[i][j] == '.'){
					if((i + j) % 2 == 0) arr[0]++;
					else arr[1]++;
				}
				else if(board[i][j] == '#'){
					if((i + j) % 2 == 0) arr[2]++;
					else arr[3]++;
				}
			}
		}
		
    }

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case=1; test_case <= T; test_case++){
			n = sc.nextInt();
			m = sc.nextInt();
			board = new char[n][m];

			for(int i=0; i<n; i++){
				String s = sc.next();
				for(int j=0; j<m; j++){
					board[i][j] = s.charAt(j);
				}
			}

			solution();
			if((arr[0] > 0 && arr[1] > 0) || (arr[2] > 0 && arr[3] > 0) || (arr[0] > 0 && arr[2] > 0) || (arr[1] > 0 && arr[3] > 0)){
				System.out.println("#" + test_case + " impossible");
			}
			else {
				System.out.println("#" + test_case + " possible");
			}
		}
	}
}


/* 입력
3
3 6
#.????
?#????
???.??
1 6
##????
3 3
.#.
#?#
.#.
*/

/* 출력
#1 possible
#2 impossible
#3 possible
*/
