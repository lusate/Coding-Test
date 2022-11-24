import java.util.*;
class Solution {
	static char[][] board;
	static int cnt, look;
	private static void solution(){
		int[] row = new int[8]; //O 일 때 저장할 row
		
		for(int i=0; i<8; i++){
			look = 0;
			for(int j=0; j<8; j++){
				if(board[i][j] == 'O'){
					look++;
					row[j]++; //O 발견할 때마다 row에 +1.
				}
				if(look == 2) return; //없으면 3번째 케이스가 yes가 되버린다.
				//하나의 행에 'O' 이 2개 이상 있기 때문이다. 그래서 빠져나온다. 
			}
		}
		for(int i=0; i<8; i++){
			if(row[i] == 1) cnt++;
		}
	}
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case=1; test_case <= T; test_case++){
			board = new char[8][8];
			look = 0;
			for(int i=0; i<8; i++){
				String s = sc.next();
				for(int j=0; j<8; j++){
					board[i][j] = s.charAt(j);
					if(board[i][j] == 'O'){
						look++; //룩 개수
					}
				}
			}
			
			cnt = 0;
			if(look == 8) solution();
			if(cnt == 8) System.out.println("#" + test_case + " yes");
			else System.out.println("#" + test_case + " no");
		}
	}
}


/* 입력
3
......O.
.......O
...O....
O.......
....O...
..O.....
.O......
.....O..
OOOOOOOO
OOOOOOOO
OOOOOOOO
OOOOOOOO
OOOOOOOO
OOOOOOOO
OOOOOOOO
OOOOOOOO
.O.O.O.O
O.O.O.O.
........
........
........
........
........
........
*/


/* 출력
yes
no
no
*/
