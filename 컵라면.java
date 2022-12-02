import java.util.*;
class Time implements Comparable<Time>{
	public int deadLine, cupRamen;
		
	public Time(int deadLine, int cupRamen) {
		this.deadLine = deadLine;
		this.cupRamen = cupRamen;
	}
		
	// deadline이 작은 순, 컵라면이 큰 순
	@Override
	public int compareTo(Time o) {
		if(this.deadLine == o.deadLine) { //데드라인이 같으면
			return o.cupRamen - this.cupRamen; //컵라면 개수 내림차순.
		}
		return this.deadLine - o.deadLine; //데드라인 다르면 데드라인 기준 그대로 오름차순.
	}
}
class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		ArrayList<Time> arr = new ArrayList<>();
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		//어떤 문제에 써야하는지 아직 감이 안 잡힘.
		
		
		for(int i=0; i<n; i++) {
			int deadLine = sc.nextInt();
			int cupRamen = sc.nextInt();
			arr.add(new Time(deadLine, cupRamen));
		}

		// 데드라인이 작고, 라면이 큰순으로 정렬하기 
		Collections.sort(arr);
		
		for(Time time : arr) {
			// 사이즈는 일(day)  수를 뜻함 
			int size = queue.size();
			// 데드라인이 작다면 무조건 삽입 가능 
			if(size < time.deadLine) {
				queue.offer(time.cupRamen);
			}
			// 같은 날짜라면, 큐에 담겨진 가장 작은 라면수와 현재 라면수랑 비교하기 
			else if(size == time.deadLine) {
				int peek = queue.peek();
				// 현재 라면이 크다면 큐에 있던것을 빼주고 현재 값으로 넣어주기 
				if(time.cupRamen > peek) {
					queue.poll();
					queue.add(time.cupRamen);
				}
			}
		}

		int max = 0;
		while(!queue.isEmpty()) {
			max += queue.poll();
		}
		System.out.println(max);
	}
	
}


/* 입력
7
1 6
1 7
3 2
3 1
2 4
2 5
6 1


7
2 4
3 5
2 3
2 2
1 6
3 6
1 3
*/


/* 출력
15

17
*/
