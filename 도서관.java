import java.util.*;
class Solution{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> Q1 = new PriorityQueue<>((p1, p2) -> p2 - p1);
		PriorityQueue<Integer> Q2 = new PriorityQueue<>((p1, p2) -> p2 - p1);
		
		int n = sc.nextInt(); //총 책 개수
		int m = sc.nextInt(); //들고갈 책 개수
		
		for(int i=0; i<n; i++) {
			int tmp = sc.nextInt();
			
			if(tmp > 0) Q1.offer(tmp); //양수
			else Q2.offer(Math.abs(tmp)); //음수여서
		}
		
		//Q1, Q2에서 최대값을 구해줌.
		int max = 0;
		if(Q1.isEmpty()) {
			max = Q2.peek();
		}
		else if(Q2.isEmpty()) {
			max = Q1.peek();
		}
		else max = Math.max(Q1.peek(), Q2.peek());
		
		
		int answer = 0;
		while(!Q1.isEmpty()) {
			int tmp = Q1.poll(); //처음 tmp는 11
			for(int i=0; i<m-1; i++) {
				Q1.poll(); //여기서 2가 빠짐 그러면 Q1은 비어있음.
				
				if(Q1.isEmpty()) {
					break;
				}
			}
			//들고갈 책이 하나면
			answer = answer + tmp * 2; //22
		}
		while(!Q2.isEmpty()) {
			int tmp = Q2.poll(); //처음은 39
			
			for(int i=0; i<m-1; i++) {
				Q2.poll(); //37 뺌
				
				if(Q2.isEmpty()) {
					break;
				}
			}
			answer = answer + tmp * 2; //39*2 + 29*2 + 6*2
		}
		
		answer = answer - max; //39는 한 번만 더하기 위함.
		System.out.println(answer);
	}
}

/* 입력
7 2
-37 2 -6 -39 -29 11 -28

8 3
-18 -9 -4 50 22 -26 40 -45
*/

/* 출력
131

158
*/
