import java.util.*;
class Point { 
	int x, time;
	public Point(int x, int time){
		this.x=x;
		this.time=time;
	}
}
class Main {
	static int n, k;
	static int[] ch;
	
	private static void bfs() {
		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(n, 1)); //시작 n에서 1초로 함.
		ch[n] = 1; //n에서 1초로 하여 방문처리함
		
		while(!Q.isEmpty()){
			Point tmp = Q.poll();
			//v-1, v+1 은 1초 추가지만 v*2는 0초 추가이므로 따로 나눠줌.
			//tmp.x는 현재 위치.
			if(tmp.x - 1 >= 0 && tmp.x - 1 < 100001){
				if(ch[tmp.x - 1] == 0 || ch[tmp.x - 1] > tmp.time + 1){  //방문처리.
					ch[tmp.x - 1] = tmp.time + 1;
					Q.offer(new Point(tmp.x - 1, tmp.time + 1));
				}
			}

			if(tmp.x + 1 >= 0 && tmp.x + 1 < 100001){
				if(ch[tmp.x + 1] == 0 || ch[tmp.x + 1] > tmp.time + 1){
					ch[tmp.x + 1] = tmp.time + 1;
					Q.offer(new Point(tmp.x + 1, tmp.time + 1));
				}
			}

			if(tmp.x * 2 >= 0 && tmp.x * 2 < 100001){
				if(ch[tmp.x * 2] == 0 || ch[tmp.x * 2] > tmp.time){
					ch[tmp.x * 2] = tmp.time;
					Q.offer(new Point(tmp.x * 2, tmp.time));
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		ch = new int[100001];

		bfs();
		System.out.println(ch[k] - 1);
		//n에서 1초로 하여 방문처리했으므로 -1을 해줌.
	}
}


/* 입력
5 17

10001 10008
*/

/* 출력
2

7
*/
