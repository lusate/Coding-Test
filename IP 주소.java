import java.util.*;
class Solution{
	LinkedList<String> tmp;
	ArrayList<String> res;
	public void dfs(int st, String s){ //st는 인덱스를 뽑기 시작하는 지점.
		if(tmp.size() > 4) return; //더 길게 내려갈 필요없음.
		if(tmp.size() == 4 && st == s.length()){
			//System.out.println(tmp);
			String Ts = "";
			for(String x : tmp) Ts += x + ".";
			res.add(Ts.substring(0, Ts.length()-1));
		}

		else{
			for(int i=st; i<s.length(); i++){ //st부터 i까지 뽑아냄.
				// 숫자가 0으로 시작하면 return -> D(1)에서 "02"처럼 st가 1인데 i가 2이면 return
				if(s.charAt(st) == '0' && st < i) return;

				String num = s.substring(st, i+1); //첫 부분에 2, 20, 202 이런식으로 뽑아내기 위함.
				if(Integer.parseInt(num) > 255) return; //255보다 크면 뽑아내지 못함.

				tmp.add(num); //현재 i까지 뽑아낸 상태
				dfs(i+1, s); //다시 st부터 뽑아내야 하므로 i+1
				tmp.pollLast();
			}
		}

	}
	public String[] solution(String s) {
		tmp = new LinkedList<>();
		res = new ArrayList<>();

		dfs(0, s);

		String[] answer = new String[res.size()];

		for(int i=0; i<res.size(); i++){
			answer[i] = res.get(i);
		}
		
		return answer;
	}
	
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution("2025505")));
		// System.out.println(Arrays.toString(T.solution("0000")));
		// System.out.println(Arrays.toString(T.solution("255003")));
	}
}



/* 출력
[20.25.50.5, 20.255.0.5, 202.5.50.5, 202.55.0.5]
[0.0.0.0]
[25.50.0.3, 255.0.0.3]
*/
