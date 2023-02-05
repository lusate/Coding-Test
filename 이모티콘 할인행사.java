import java.util.*;
class Solution {
    int[] answer;
    int[] sale; //시도해볼 할인율.
    int[] data;
    public void dfs(int L, int[][] users, int[] emoticons){
        if(L == emoticons.length){
			int[] result = new int[2];
			for(int i=0; i<users.length; i++){
				int sum = 0;
				for(int j=0; j<emoticons.length; j++){
					//할인률이 더 크면 모두 구매.
					if(users[i][0] <= sale[j]){
						sum += emoticons[j] * (100 - sale[j]) / 100;
					}
				}
				if(sum >= users[i][1]){
					result[0]++; //가입자 수 추가
				}
				else result[1] += sum; //매출액.
			}

			//answer 배열을 비교해 가입자가 더 크고, 판매액이 많은 것을 answer 배열에 담음.
			if(answer[0] < result[0]){ //가입자수가 우선
				answer[0] = result[0];
				answer[1] = result[1];
			}
			//가입자 수가 같으면 매출액이 더 큰게 answer.
			else if(answer[0] == result[0] && answer[1] < result[1]){
				answer[1] = result[1];
			}
		}

		else{
			//이모티콘 할인은 10, 20, 30, 40 이 있기 때문에 i를 4가지로 함.
			for(int i=0; i<4; i++){
				sale[L] = data[i]; //이모티콘 개수에 따라 할인율 4가지 적용.
				dfs(L+1, users, emoticons);
			}
		}
    }
    public int[] solution(int[][] users, int[] emoticons) {
		answer = new int[2];
		sale = new int[emoticons.length];
		data = new int[]{10, 20, 30, 40};
		dfs(0, users, emoticons);

		return answer;
    }

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(new int[][]{{40, 10000}, {25, 10000}}, 
		new int[]{7000, 9000})));
		System.out.println(Arrays.toString(T.solution(new int[][]{{40, 2900}, {23, 10000}, {11, 5200}, 
		{5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}}, new int[]{1300, 1500, 1600, 4900})));
	}
}



/* 출력
[1, 5400]
[4, 13860]
*/
