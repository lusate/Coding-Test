import java.util.*;
class Time implements Comparable<Time>{
	public int time;
	public int state; //들어왔으면 1 나갔다면 2 
	
	Time(int time, int state){
		this.time = time;
		this.state = state;
	}//새로운 배열을 만들어줌
	//[14, 1] [18,2] [12,1] [15,2] [15,1] [20,2] [30,2] [5,1] [14,2]

	@Override //시작점을 기준으로 오름차순 정렬
	public int compareTo(Time ob){
		if(this.time == ob.time){
			return ob.state - this.state;
		}
		else{
			return this.time - ob.time;
		}
	}
	//[5,1] [12,1] [14,2] [14,1] [15,2] [15,1] [18,2] [20,2] [30,2]
}
class Main{
	public int solution(int[][] times){
		int answer = Integer.MIN_VALUE;
		ArrayList<Time> list = new ArrayList<>();

		for(int[] x : times){
			list.add(new Time(x[0], 1)); // 상태가 1인(들어온) 시간들
			list.add(new Time(x[1], 2)); // 상태가 2인(나간) 시간들
		}
		
		//[14, 1] [18,2] [12,1] [15,2] [15,1] [20,2] [30,2] [5,1] [14,2]
		//list에 새로운 배열을 만듦

		Collections.sort(list);
		//[5,1] [12,1] [14,2] [14,1] [15,2] [15,1] [18,2] [20,2] [30,2]

		int cnt = 0; //동시에 존재하는 인원 수
		for(Time ob : list){
			//System.out.println(ob.time + ", " + ob.state);
			//Time ob에 정렬한 배열이 들어감

			if(ob.state == 1) cnt++; //사람이 들어오면 cnt++
			else cnt--; //나가면 cnt--
			answer = Math.max(answer, cnt);
			//동시에 존재하는 최대 인원 수
		}

		return answer;
	}
	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(new int[][]{{14, 18}, {12, 15}, {15, 20}, {20, 30}, {5, 14}}));
	}
}


//답
//2

/*
Comparable, Comparator 둘 다 implements 해야하고 
<> 사이에 들어갈 타입은 Time 객체와 또 다른 Time 객체를 비교하고 싶다면, <> 사이에 들어갈 타입 또한 Time이 되어야 한다.


Comparable 구현 할 때
class Student implements Comparable<Student> {}
public int compareTo(Student o) {}


Comparator 구현할 때
class Student implements Comparator<Student> {}
public int compare(Student o1, Student o2) {}
*/


