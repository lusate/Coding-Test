import java.util.*;
import java.io.*;
class Point{
	int x;
	int time;
	public Point(int x, int time){
		this.x = x;
		this.time = time;
	}
}
public class Main {
	public int solution(int n, int k) {
		Queue<Point> Q = new LinkedList<>();
		int[] ch = new int[10001];
		int min = Integer.MAX_VALUE;
		Q.offer(new Point(n, 0));
		while(!Q.isEmpty()){
			Point point = Q.poll();
			ch[point.x] = 1;
			if(point.x == k) min = Math.min(min, point.time);

			if(point.x * 2 <= 10000 && ch[point.x * 2] == 0){
				Q.offer(new Point(point.x * 2, point.time));
			}
			if(point.x + 1 <= 10000 && ch[point.x + 1] == 0){
				Q.offer(new Point(point.x + 1, point.time + 1));
			}
			if(point.x - 1 >= 0 && ch[point.x - 1] == 0){
				Q.offer(new Point(point.x - 1, point.time + 1));
			}
		}

    	return min;
    }
	public static void main(String[] args){
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //수빈
		int k = sc.nextInt(); //동생
		
		System.out.println(T.solution(n, k));
	}
}
