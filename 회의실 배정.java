import java.util.*;
class Time implements Comparable<Time>{
	public int s, e;
	Time(int s, int e){
		this.s=s;
		this.e=e;
	}
	@Override
	public int compareTo(Time ob){
		if(this.e == ob.e) return this.s - ob.s; //같으면 시작점을 가지고 오름차순
		else return this.e - ob.e; //끝점을 가지고 오름차순
	}
}

class Main {
	public int solution(int n, ArrayList<Time> arr){
		int answer=0;
		Collections.sort(arr);
		int et = 0;
		for(Time ob : arr){
			if(et <= ob.s){
				answer++;
				et = ob.e;
			}
		}
		System.out.println(answer);
		return answer;
	}
	public static void main(String[] args)  {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Time> arr = new ArrayList<>();
		
		for(int i=0; i<n; i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr.add(new Time(x, y));
		}
		T.solution(n, arr);
	}
}


///////////////////////////////////////////////////////////////////////////////////////////

import java.util.*;
class Main{
	public int solution(int[][] times){
		int answer=0;
		Arrays.sort(times, (a,b) -> a[1] == b[1] ? a[0]-b[0] : a[1]-b[1]);
		//끝점 [1] 이 같다면 [0]을 기준으로 오름차순 같지 않으면 [1]을 기준으로 오름차순
		//a[0]-b[0] : [0]을 기준으로 오름차순
		//a[1]-b[1] : [1]을 기준으로 오름차순
		//[0] 이 시작점, [1]이 끝점

		int et=0; //et 는 새로 갱신할 끝점
		for(int[] x : times){
			if(x[0] >= et){
				answer++; //회의 수
				et = x[1];
				System.out.println("et:"+et);
			}
			//x[0]이 시작점, x[1]은 끝점

		}
		return answer;
    }//0 이면 시작점, 1이면 끝점
	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(new int[][]{{1, 4}, {2, 3}, {3, 5}, {4, 6}, {5, 7}}));
	}
}
