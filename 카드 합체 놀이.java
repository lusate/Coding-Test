import java.util.*;
public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			int num = sc.nextInt();
			pq.add(num);
		}
		
		for(int i=0; i<m; i++) {
			int a = pq.poll();
			int b = pq.poll();
			pq.add(a+b);
			pq.add(a+b);
		}
		int answer = 0;
		
		while(!pq.isEmpty()) {
			answer += pq.poll();
			//System.out.println("sum = " + answer);
		}
		System.out.println(answer);
	}
}// 우선 순위 큐를 사용해 가장 작은 2개의 카드 수를 꺼내고 더한 다음 2번 넣어줌.
// 이 과정을 m번 반복.
//4 3 2 1 -> 1 + 2 해서 3을 2번 넣어줌.
//4 3 3 3 -> 3 + 3 해서 6을 2번 넣어줌
//6 6 4 3 -> m번 다함
//7 6 6
//12 7
//19

/* 입력
4 2
4 2 3 1
*/

/* 출력
19
*/
