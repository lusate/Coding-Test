문제) 엘리베이터를 이용하려고 한다. 엘리베이터는 1층부터 시작해서 각 공사 비용이 0, 900, 0, 200, 150, 0, 30, 50원 이다.
1,3,6층은 공사를 완료해서 0원으로 비용이 들지 않는다.
예산이 420원으로 이용할 수 있는 최대연속길이를 구해라. (몇 층부터 몇 층까지의 길이를 구함)

import java.util.*;
class Main {
	public int solution(int money, int[] cost){
		int answer=0;
		int sum=0;
		int left = 0;

		for(int right = 0; right < cost.length; right++){
			sum+=cost[right];
			while(sum > money){
				sum-=cost[left];
				left++;
			}

			//부분수열 개수를 구함
			answer = Math.max(answer, right-left+1);
		}
		
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		int[] cost = new int[]{0,900,0,200,150,0,30,50};
		System.out.println(T.solution(420, cost));
	}
}
