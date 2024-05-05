import java.util.*;
class Main { //시작점에서 도착점으로 이동을 하므로 BFS로 한다.
	public int solution(int[] nums){
		int n = nums.length;
		int[] ch = new int[n];
		Queue<Integer> Q = new LinkedList<>();
		Q.offer(0); //0번 인덱스를 넣음
		ch[0] = 1; //0번 인덱스에서 출발하므로 처음 ch[0]은 1로 초기화
		int L=0;
		while(!Q.isEmpty()){
			int len=Q.size(); // 사용할 점프만을 선택하기 때문에 q에 들어가있는 점프만 사용함.
			for(int i=0; i<len; i++){
				int x = Q.poll();
				// nums -> 2,2,0,2,1,1, x는 인덱스로 nums 안에 값 이하로 점프함
				for(int j=1; j<=nums[x]; j++){
					int nx = x + j;
					if(nx == n-1) return L+1; //타일이 도착하면 L+1
					if(nx < n && ch[nx] == 0){
						ch[nx] = 1;
						Q.offer(nx);
					}
				}
			}
			L++;
		}
		return -1;
	}

	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(new int[]{2, 2, 0, 2, 1, 1}));
		System.out.println(T.solution(new int[]{1, 0, 1, 1, 3, 1, 2, 1}));
		System.out.println(T.solution(new int[]{2, 3, 1, 0, 1, 1, 2, 3, 1, 5, 1, 3, 1}));
		System.out.println(T.solution(new int[]{1, 2, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1}));
	}
}
