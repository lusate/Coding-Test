import java.util.*;
class Solution{
	LinkedList<Character> tmp;
	ArrayList<String> res;
	HashMap<Character, Integer> map;
	int len;
	public void dfs(){
		
		if(tmp.size() == len){
			String Ts = "";
			for(char x : tmp) Ts += x;
			res.add(Ts);
		}

		else{
			for(char key : map.keySet()){
				if(map.get(key) == 0) continue;
				tmp.add(0, key);
				tmp.add(key);
				map.put(key, map.get(key) - 2); //a:4, b:2에서 a:2, b:2가 되는 경우
				dfs();
				tmp.pollFirst();
				tmp.pollLast();
				map.put(key, map.get(key) + 2);
			}
		}
	}

	public String[] solution(String s) {
		len = s.length();
		map = new HashMap<>();
		res = new ArrayList<>();
		tmp	= new LinkedList<>();
		for(char x : s.toCharArray()){
			map.put(x, map.getOrDefault(x, 0) + 1);
		}
		
		int odd=0;
		char mid='0'; //가운데에 홀수인 key를 집어넣기 위함.
		for(char key : map.keySet()){
			if(map.get(key) % 2 == 1){
				mid = key;
				odd++; //홀수 찾기
			}
		}
		
		// 홀수 개수가 2이상이면 팰린드롬 만들기 불가. 그래서 그냥 [] 출력
		if(odd > 1) return new String[]{};

		if(mid != '0'){ // 홀수인 경우 mid에 '0'이 아니고 위에서 찾은 key, 짝수인 경우는 '0'
			tmp.add(mid);  //홀수이므로 mid 추가
			map.put(mid, map.get(mid) - 1); //홀수이므로 -1을 해줌
		}

		dfs();
		String[] answer = new String[res.size()];
		for(int i=0; i<res.size(); i++){
			answer[i] = res.get(i);
		}
		return answer;
	}
	
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution("aaaabba")));
		System.out.println(Arrays.toString(T.solution("aaaabb")));
		System.out.println(Arrays.toString(T.solution("abbcc")));
		System.out.println(Arrays.toString(T.solution("abbccee")));
	}
}


/* 출력
[baaaaab, abaaaba, aababaa]
[baaaab, abaaba, aabbaa]
[cbabc, bcacb]
[ecbabce, cebabec, ebcacbe, becaceb, cbeaebc, bceaecb]
*/
