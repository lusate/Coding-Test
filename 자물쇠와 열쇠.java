import java.util.*;
class Main {
	//키가 자물쇠에 맞는지 확인
	public boolean check(int[][] map, int[][] key, int locklen){
		int keylen = key.length; //3
		int maplen = map.length; //5
		
		//키를 돌리면서 이동시킬 때 5번 이동시키면서 확인함
		for(int i=0; i<maplen-keylen+1; i++){ //7-3+1=5
			for(int j=0; j<maplen-keylen+1; j++){ //7-3+1=5
				//map에 key를 더함
				for(int k=0; k<keylen; k++){
					for(int l=0; l<keylen; l++){
						map[i+k][j+l] += key[k][l];
					}//map은 길이가 7, key는 길이가 3 / k,l은 key를 위한 범위
				}// 그래서 2중 for문으로 map에 key를 더함
				//자물쇠 부분이 전부 1이 됐는지 확인
				boolean flag = true;
				for(int k=keylen-1; k<keylen+locklen-1; k++){
					for(int l=keylen-1; l<keylen+locklen-1; l++){
						//keylen-1 = 2 , keylen+locklen-1 = 3+3-1=5
						if(map[k][l] != 1){
							flag = false;
							break;
						}
					}

					if(!flag) break;
				}
				if(flag) return true; //전부 1이되면 true

				//map을 원상 복귀 시킴, map에서 key를 뺌
				for(int k=0; k<keylen; k++){
                    for(int l=0; l<keylen; l++){
                        map[i+k][j+l] -= key[k][l];					
                    }
                }
			}
		}
		return false;
	}

	public void rotate(int[][] key){
		int len = key.length; //3
		int[][] temp = new int[len][len];

		//temp는 key를 90도로 한 번 돌린 상태
		for(int i=0; i<len; i++){
			for(int j=0; j<len; j++){
				temp[i][j] = key[len-j-1][i];
			}//temp[0][0] = key[2][0] 임
		}

		//돌린 temp를 key에 저장
		for(int i=0; i<len; i++){
			for(int j=0; j<len; j++){
				key[i][j] = temp[i][j];
			}
		}
	}
	public boolean solution(int[][] key, int[][] lock) {
		int m = key.length;
		int n = lock.length;

		int len = n*m-2; //3*3-2 = 7
		int[][] map = new int[len][len];

		//확장 시킨 배열에 Lock 표시
		for(int i=m-1; i<m+n-1; i++){
			for(int j=m-1; j<m+n-1; j++){
				map[i][j] = lock[i-(m-1)][j-(m-1)];
			}
		}

		//키를 90도 돌리면서 키가 맞는지 확인
		for(int i=0; i<4; i++){
			if(check(map, key, n)){
				return true;
			}
			rotate(key); //4번 돌리면서 check
		}

		return false;
	}
		
	public static void main(String[] args){
		Main T = new Main();
		int[][] key = new int[][]{{0,0,0},{1,0,0},{0,1,1}};
		int[][] lock = new int[][]{{1,1,1},{1,1,0},{1,0,1}};
		System.out.println(T.solution(key, lock));
	}
}
