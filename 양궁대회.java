import java.util.*;
class Solution{
	int[] ryan;
	int[] res;
	int max = Integer.MAX_VALUE;
	public void dfs(int n, int cnt, int[] info){
		if(cnt == n){ //cnt는 발사한 화살 개수
			int apeachSum = 0; //어피치 점수 합
			int ryanSum = 0; //라이언 점수 합
			for(int i=0; i<=10; i++){
				if(info[i] != 0 || ryan[i] != 0){
					if(info[i] < ryan[i]) ryanSum += 10 - i;
					else apeachSum += 10 - i; //맞힌 개수가 같아도 어피치가 이김
				}
			}

			if(apeachSum < ryanSum){
				int dif = ryanSum - apeachSum;
				if(dif >= max){ //최대값보다 커야함.
					res = ryan.clone();
					max = dif;
				}
			}
			return;
		}

		else{
			for(int i=0; i<=10 && ryan[i] <= info[i]; i++){
				ryan[i]++;
				dfs(n, cnt+1, info);
				ryan[i]--;
			}
		}
		
	}
	public int[] solution(int n, int[] info) {
		ryan = new int[11];
		res = new int[]{-1};
		dfs(n, 0, info);
		return res;
	}
	
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(5, new int[]{2,1,1,1,0,0,0,0,0,0,0})));
		System.out.println(Arrays.toString(T.solution(1, new int[]{1,0,0,0,0,0,0,0,0,0,0})));
		System.out.println(Arrays.toString(T.solution(10, new int[]{0,0,0,0,0,0,0,0,3,4,3})));
	}
}


/* 출력
[0,2,2,0,1,0,0,0,0,0,0]
[-1]
[1,1,1,1,1,1,1,1,0,0,2]
*/
