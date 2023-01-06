import java.util.*;
class Main{
	private static int solution(int[] tasks, long k){
		int answer = 0;
		int n = tasks.length;
		int[] copy = new int[n+1];
		//복사할 때 System.arraysCopy() 사용 가능.

		copy[0] = 0;
		for(int i=1; i<n+1; i++){
			copy[i] = tasks[i-1];
		}
		//이게 copy에서 0을 하는 이유이다.
		//이러면 copy에 [0,8,5,2,9,10,7] 이 됨.
		Arrays.sort(copy);
		//[0,2,5,7,8,9,10]

		int rest = tasks.length;

		for(int i=1; i<copy.length; i++){
			if(k < rest*(copy[i] - copy[i-1])){ //3 < 8일 경우
				// k = 3일 때임.
				// 남아있는 초에서 남은 rest를 % 해서 작업 처리를 줄임.
				// 즉 3번째 테스트케이스처럼 k가 11인 상태이고 rest가 5이면 2바퀴를 더 돌리지 않게 하기 위해
				// 바로 11 % 5 = 1로 k를 1로 함.
				k = k % rest; //rest = 4
				int cnt = 0;
				for(int j=0; j<tasks.length; j++){
					if(tasks[j] >= copy[i]){
						if(cnt == k){
							return j+1; //다시 시작해야 할 인덱스.
						}
						cnt++;
					}
				}
			}
			else {
				k = k - rest*(copy[i] - copy[i-1]);
				rest--;
			}
		}
		System.out.println(k);

		
		return -1;
	}
	
	public static void main(String[] args){
		System.out.println(solution(new int[]{1, 2, 3}, 5));
		System.out.println(solution(new int[]{8, 5, 2, 9, 10, 7}, 30));
		System.out.println(solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
	}
}


/* 출력
3
6
5
*/
