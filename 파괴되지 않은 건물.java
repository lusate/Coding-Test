import java.util.*;
class Solution {
	public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int[][] map = new int[n+1][m+1];
        
        for(int i=0; i<skill.length; i++){
            int x1 = skill[i][1];
            int y1 = skill[i][2];
            int x2 = skill[i][3];
            int y2 = skill[i][4];
            int power = skill[i][5];
            
            if(skill[i][0] == 1){ //공격
                map[x1][y1] += -power;
                map[x2+1][y1] += power;
                map[x1][y2+1] += power;
                map[x2+1][y2+1] += -power;
            }
            
            else if(skill[i][0] == 2){ //회복
                map[x1][y1] += power;
                map[x2+1][y1] += -power;
                map[x1][y2+1] += -power;
                map[x2+1][y2+1] += power;
            }
        }
        
        for(int i=0; i<n+1; i++){
            int sum = 0;
            for(int j=0; j<m+1; j++){
                sum += map[i][j];
                map[i][j] = sum;
            }
        }
        
        for(int i=0; i<m; i++){
            int sum = 0;
            for(int j=0; j<n; j++){
                sum += map[j][i];
                map[j][i] = sum;
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] + board[i][j] > 0) answer++;
            }
        }
        
        return answer;
    }

	public static void main(String args[]){
		Solution T = new Solution();
		System.out.println(T.solution(new int[][]{{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}}, 
		new int[][]{{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}}));
		
		System.out.println(T.solution(new int[][]{{1,2,3},{4,5,6},{7,8,9}}, 
		new int[][]{{1,1,1,2,2,4},{1,0,0,1,1,2},{2,2,0,2,0,100}}));
	}
}


/* 출력
10
6
*/


/* 누적합으로 풀이
map[n+1][m+1], (0, 0) ~ (3, 4)까지 4뺌.
[-4,0,0,0,0,4]
[0,0,0,0,0,0]
[0,0,0,0,0,0]
[0,0,0,0,0,0]
[4,0,0,0,0,-4]    이렇게 p를 배치하고 가로, 세로 누적합 구함.


가로 누적합
[-4,-4,-4,-4,-4,0]
[0,0,0,0,0,0]
[0,0,0,0,0,0]
[0,0,0,0,0,0]
[4,4,4,4,4,0]

세로 누적합
[-4,-4,-4,-4,-4,0]
[-4,-4,-4,-4,-4,0]
[-4,-4,-4,-4,-4,0]
[-4,-4,-4,-4,-4,0]
[0,0,0,0,0,0]

그러면 (0, 0) ~ (3, 4) 까지 -4를 빼게 됨.
*/
