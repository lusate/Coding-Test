//가장 가까운 시간 -> 시간을 분으로 바꿔놓고 푼다. (요런 문제들은 대부분 분으로 바꾼다.)
import java.util.*;

class Main{
	//분으로 바꾸면 12, 0, 65, 57
	public int getTime(String time){
		String[] tmp = time.split(":"); //시간과 분을 분린

		int H = Integer.parseInt(tmp[0]); //시
		int M = Integer.parseInt(tmp[1]); //분ㄴ

		return H * 60 + M;
		//이런 스타일의 문제를 발견한다면 int getTime(String time) 메서드를 생성하기
	}

	public int solution(String[] times){
		ArrayList<Integer> tmp = new ArrayList<>();

		for(String x : times){
			tmp.add(getTime(x)); //분으로 환산해서 들어감
			//System.out.println(tmp); 출력 -> [12, 0, 65, 57]
		}

		Collections.sort(tmp);

		int answer = 24*60 + tmp.get(0) - tmp.get(tmp.size()-1);
		//24*60분 + a - b  하면 b와 a의 시간 차이를 알 수 있음

		for(int i=0; i<tmp.size()-1; i++){
			//가장 짧은 시간 차를 구함
			answer = Math.min(answer, tmp.get(i+1) - tmp.get(i));
		}

		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		String[] str1 = new String[]{"00:12","00:00", "01:05", "00:57"};
		System.out.println(T.solution(str1));
		String[] str2 = new String[]{"23:59","00:00", "23:57"};
		System.out.println(T.solution(str2));
	}
}
