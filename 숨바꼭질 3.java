import java.util.*;
class Point{
	int x;
	int time;
	Point(int x, int time){
		this.x = x;
		this.time = time;
	}
}
class Main{
	static int L;
	static int cnt;
	static int[] ch;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		Queue<Point> Q = new LinkedList<>();
		ch = new int[100001];
		ch[n] = 1;
		Q.offer(new Point(n, 1));
		while(!Q.isEmpty()){
			Point tmp = Q.poll();

			//뒤로 한 칸
			if(tmp.x - 1 >= 0 && tmp.x - 1 < 100001){
				if(ch[tmp.x - 1] == 0 || ch[tmp.x - 1] > tmp.time + 1){
					ch[tmp.x - 1] = tmp.time + 1;
					Q.offer(new Point(tmp.x - 1, tmp.time + 1));
				}
			}//ch[tmp.x - 1] > tmp.time+1 은 이동해서 방문한 time 이 지금 time+1 보다 크면 다시 방문
			//즉 5에서 출발해서 가다가 10을 이미 방문했었는데 또 10이 나오는 경우는 다시 방문처리를 해둔다.
			

			//앞으로 한 칸
			if(tmp.x + 1 >= 0 && tmp.x + 1 < 100001){
				if(ch[tmp.x + 1] == 0 || ch[tmp.x + 1] > tmp.time + 1){
					ch[tmp.x + 1] = tmp.time + 1;
					Q.offer(new Point(tmp.x + 1, tmp.time + 1));
				}
			}

			//순간이동
			if(tmp.x * 2 >= 0 && tmp.x * 2 < 100001){
				if(ch[tmp.x * 2] == 0 || ch[tmp.x * 2] > tmp.time){
					ch[tmp.x * 2] = tmp.time;
					Q.offer(new Point(tmp.x * 2, tmp.time));
				}
			}
		}

		System.out.println(ch[k] - 1);
	}
}


/* 입력
5 17
*/

/* 출력
2
*/
