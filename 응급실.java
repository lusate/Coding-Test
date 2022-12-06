import java.util.*;
class Person{
	public int idx, priority;
	public Person(int idx, int priority){
		this.idx = idx;
		this.priority = priority;
	}
}
class Main {
	private static int solution(int n, int m, int[] arr) {
		int answer = 0;
		Queue<Person> Q = new LinkedList<>();
		for(int i=0; i<n; i++){
			Q.offer(new Person(i, arr[i]));
		}

		while(!Q.isEmpty()){
			Person tmp = Q.poll();
			
			for(Person x : Q){
				if(tmp.priority < x.priority){ //현재 위험도보다 큰 위험도가 있으면
					Q.offer(tmp); 
					tmp=null; //진료 못 받음.
					break;
				}
			}
			if(tmp != null){ //진료를 받을 수 있음.
				answer++;
				if(tmp.idx == m) return answer;
			}
		}
		return answer;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}

		System.out.println(solution(n, m, arr));
	}
}


/* 
▣ 입력예제
5 2
60 50 70 80 90


6 3
70 60 90 60 60 60
*/


/* 출력
3

4
*/
