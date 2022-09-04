import java.util.*;
class Main{
	public int solution(int[] nums){
		int answer = 0;
		int n = nums.length;
		int[] dist = new int[n];
		int d = 1000;
		
		for(int i=0; i<n; i++){
			//사람이 있는 1이라면 거리를 0으로 한다.
			if(nums[i] == 1){
				d = 0;
			}
			//왼쪽에 있는 사람과의 거리를 구함
			else{
				d++;
				dist[i] = d;
			}
			//System.out.print(dist[i]);
			//0,1,2,3,0,1,2,0,1,0 이 된다.
		}
		//System.out.println();
		for(int i=n-1; i>=0; i--){
			//사람이 있는 1이라면 거리를 0으로 한다.
			if(nums[i] == 1){
				d = 0;
			}
			
			//왼쪽에 있는 사람과의 거리를 구한 것과 비교하여 최소값을 dist[i]에 저장
			else{
				d++;
				//dist[i] = d;
				dist[i] = Math.min(dist[i], d);
			}
			//System.out.print(dist[i]);
			//그럼 dist에는 거꾸로 시작해서
			//0,3,2,1,0,2,1,0,1,0 이 된다.
			
			//0,1,2,3,0,1,2,0,1,0 과 비교해서 최소를 구함

			//최솟값을 뽑아서 결과는 0,1,2,1,0,1,1,0,1,0 이 된다.
		}


		//최대한 멀리 떨어져 앉도록 함
		for(int x : dist){
			if(x>answer) answer = x;
		}
		
		return answer;
	}
	public static void main(String[] args){
		Main T = new Main();
		int[] tmp1 = new int[]{1, 0, 0, 0, 1, 0, 0, 1, 0, 1};
		System.out.println(T.solution(tmp1));
	}
}


//답
//2
