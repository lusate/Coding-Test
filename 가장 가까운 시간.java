import java.util.*;

class Main{
	public int getTime(String time){
		String[] tmp = time.split(":");

		int H = Integer.parseInt(tmp[0]);
		int M = Integer.parseInt(tmp[1]);

		return H * 60 + M;
	}

	public int solution(String[] times){
		ArrayList<Integer> tmp = new ArrayList<>();

		for(String x : times){
			tmp.add(getTime(x));
			//System.out.println(tmp); 출력 -> [12, 0, 65, 57]
		}

		Collections.sort(tmp);

		int answer = 24*60 + tmp.get(0) - tmp.get(tmp.size()-1);

		for(int i=1; i<tmp.size(); i++){
			answer = Math.min(answer, tmp.get(i) - tmp.get(i-1));
		}

		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		String[] str1 = new String[]{"00:12","00:00", "01:05", "00:57"};
		System.out.println(T.solution(str1));
	}
}
