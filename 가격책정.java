(꼭 기억) 네이버 문제
import java.util.*;
class Main{
	public int getAverage(int[] prices, int a, int b){
		//a 인덱스부터 b 인덱스까지의 평균을 리턴
		int sum=0;
		for(int i=a; i<=b; i++){
			sum += prices[i];
		}
		return sum / (b-a+1); //a부터 b까지의 개수
	}

	public int solution(int[] prices, int d, int k){
		int n = prices.length;
		Arrays.sort(prices);

		if(prices[n-1] - prices[0] <= d){
			return getAverage(prices, 0, n-1);
		}

		//if로 해도 됨. return을 했기 때문에
		else if(prices[n-2] - prices[1] <= d){
			return getAverage(prices, 1, n-2);			
		}

		//3번 조건 정도의 사고력이 필요
		for(int i=0; i<=n-k; i++){
			//k개 가격을 가지고 고려해야 함
			if(prices[i+k-1] - prices[i] <= d){
				return getAverage(prices, i, i+k-1);
			}
		}//4,5,6,7,8 일 때 평균값이 가장 적게 나올려면 오름차순한 상태에서
		//처음 4,5,6 이어야 한다. 그래서 인덱스가 0~2가 되도록 for문과 
		//if 문을 짜준 것이다.
		return prices[(n-1)/2];
	}
	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(new int[]{4, 5, 6, 7, 8}, 4, 3));
		System.out.println(T.solution(new int[]{4, 5, 6, 7, 8}, 2, 1));
		System.out.println(T.solution(new int[]{1, 8, 1, 8, 1, 8}, 6, 4));
	}
}


//답
//6
//6
//1
