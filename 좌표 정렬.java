import java.util.*;
class Point implements Comparable<Point>{
	public int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Point o) {
		if(this.x == o.x) {
			return this.y - o.y; //오름차순
//			return o.y - this.y; //내림차순
		}
		else {
			return this.x - o.x;
//			return o.x - this.x;
		}
	}
}
class Main{
	public static void main(String[] args) {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		ArrayList<Point> arr = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr.add(new Point(x, y));
		}
		
		Collections.sort(arr);
		for(Point o : arr) {
			System.out.println(o.x + "  " + o.y);
		}
	}
}

/* 입력
5
2 7
1 3
1 2
2 5
3 6
*/

/* 출력
1  2
1  3
2  5
2  7
3  6
*/
