import java.util.*;
class Solution {
    public void match(int[][] map, int[][] key, int r, int x, int y){
		int len = key.length;
		for(int i=0; i<len; i++){
			for(int j=0; j<len; j++){
				if(r == 0){ //회전 안함.
					map[x+i][y+j] += key[i][j];
				}
				else if(r == 1){
					map[x+i][y+j] += key[j][len-i-1];
				}
				else if(r == 2){
					map[x+i][y+j] += key[len-i-1][len-j-1];
				}
				else{
					map[x+i][y+j] += key[len-j-1][i];
				}
			}
		}
	}
    
    public boolean check(int[][] map, int point, int len){
		for(int i=0; i<len; i++){
			for(int j=0; j<len; j++){
				//lock이 있는 정사각형에 0이 있으면 false
				if(map[point + i][point + j] != 1) return false;
			}
		}

		return true;
	}
    
    public boolean solution(int[][] key, int[][] lock) {
		int point = key.length - 1; //키의 위치

		for(int i=0; i<point + lock.length; i++){ //이동 가능한 위치까지
			for(int j=0; j<point + lock.length; j++){
				//회전
				for(int r = 0; r<4; r++){
					int[][] map = new int[key.length+lock.length*2][key.length+lock.length*2];

					//가운데에 lock 위치시킴
					for(int k=0; k<lock.length; k++){
						for(int t=0; t<lock.length; t++){
							map[k+point][t+point] = lock[k][t];
						}
					}

					match(map, key, r, i, j);
					if(check(map, point, lock.length)){
						return true;
					}
					
				}
			}
		}

		return false;
    }

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[][]{{0,0,0}, {1,0,0}, {0,1,1}}, 
		new int[][]{{1,1,1}, {1,1,0}, {1,0,1}}));
	}
}



/* 출력
true
*/
