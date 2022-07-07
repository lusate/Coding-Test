//가장 가까운 시간 -> 시간을 분으로 바꿔놓고 푼다.(요런 문제들은 대부분 분으로 바꾼다.)
import java.util.*;

class Main{	
	// 분으로 바꾸면 12, 0, 65, 57
	public int getTime(String time){
		String[] tmp = time.split(":"); //시간과 분으로 분리

		//int로 바꿈
		int hour = Integer.parseInt(tmp[0]); //시
		int minute = Integer.parseInt(tmp[1]); //분

		return hour*60+minute;
		//이게 시간을 분으로 환산하는 방법 (기억하기)
		//이런 스타일의 문제를 발견한다면 int getTime() 메서드를 생성하기
	}
	public int solution(String[] times){
		// 오름차순으로 정렬을 한다. (매우 중요)
		ArrayList<Integer> tmp = new ArrayList<>();

		for(String x : times){
			tmp.add(getTime(x)); //tmp에 분으로 환산되서 들어감
		}
		
		Collections.sort(tmp); //오름차순 정렬
		int answer = 24*60 + tmp.get(0) - tmp.get(tmp.size()-1);
		//여기 answer는 24시간을 분으로 바꾸면 1440
		//24*60 + a - b
		
		for(int i=1; i<tmp.size(); i++){
			answer = Math.min(answer, tmp.get(i) - tmp.get(i-1));
			//System.out.println("ans2: " + answer);
		}

		return answer;
	}
	public static void main (String[] args) throws java.lang.Exception{
		Main T = new Main();
		String[] tmp1 = new String[]{"00:12","00:00", "01:05", "00:57"};
		System.out.println(T.solution(tmp1));

		String[] tmp2 = new String[]{"23:59","00:00", "23:57"};
		System.out.println(T.solution(tmp2));
	}
}
