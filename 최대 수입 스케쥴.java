import java.util.*;
class Lecture implements Comparable<Lecture>{
	int money;
	int date;
	public Lecture(int money, int date) {
		this.money = money;
		this.date = date;
	}
	@Override
	public int compareTo(Lecture ob) {
		return ob.date - this.date; //시간을 기준으로 내림차순
	}
}
class Main{
	static int n, max = Integer.MIN_VALUE;
	public int solution(ArrayList<Lecture> arr) {
		int answer=0;
		PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
		Collections.sort(arr);
		int j=0;
		for(int i=max; i>=1; i--) {
			for( ; j<n; j++) {
				//처음 arr.get(j).date 는 3으로 날짜 i인 3보다 작으면 break
				if(arr.get(j).date < i) break;
				pQ.offer(arr.get(j).money);
			}
			//i 날짜에 어떤 강연을 할 건지 선택
			if(!pQ.isEmpty()) {
				//pQ에서 poll하면 가장 큰 값이 poll됨. reverseOrder 여서
				answer += pQ.poll();
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		ArrayList<Lecture> arr = new ArrayList<>();
		for(int i=0; i<n; i++) {
			int m = sc.nextInt(); //돈
			int d = sc.nextInt(); //시간
			arr.add(new Lecture(m, d));
			if(d > max) max = d;
		}
		System.out.println(T.solution(arr));
	}
}


/* 입력
6
50 2
20 1
40 2
60 3
30 3
30 1
*/

/* 출력
150
*/

//코드 포맷을 암기
import java.util.*;
class Main{
	public int solution(int[][] nums){
		int answer=0;
		PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
		Arrays.sort(nums, (a,b) -> b[1] - a[1]);
		//날짜로 내림차순

		int max = nums[0][1];
		int j=0;
		for(int i=max; i>=1; i--){
			//for문에서 j가 0 아님
			for( ; j<nums.length; j++){
				//i=3 일 때 j = 0,1,2 / i=2 일 때 j = 2,3,4 / i=1 일 때 j = 4,5
				if(nums[j][1] < i) break; //i 보다 날짜가 작으면 break
				//즉 3일 금액이 들어갈 때 2일 금액이 들어가면 안됌.

				pQ.offer(nums[j][0]); //가장 큰 것만 offer
				//우선 순위 큐 이므로 pQ에는 40, 30, 20, 30 이 있다.
				//System.out.println(pQ);
			}

			if(!pQ.isEmpty()) answer+=pQ.poll();
			//pQ가 비어있지 않으면 answer는 빼낸 60+50+40 해서 150
		}

		return answer;
	}
	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(new int[][]{{50, 2}, {20, 1}, {40, 2}, {60, 3}, {30, 3}, {30, 1}}));
	}
}
//for 문 
//i = 3 일 때 (60, 3), (30, 3) 으로 2가지 있으므로 j는 0,1,2 로 3개 
//i = 2 일 때 (50, 2), (40, 2) 2가지 있으므로 j는 2,3,4
//i = 1 일 때는 j는  j<length 까지 해서 4,5
//즉 j는 가지 수 +1만큼 반복
