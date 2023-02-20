import java.util.*;
class Solution{
	public String solution(String input_string) {
		String answer = "";
		int n = input_string.length();

		HashMap<Character, Integer> map = new HashMap<>();

		for(int i=0; i<n; i++){
			char ch = input_string.charAt(i);
			if(!map.containsKey(ch)){
				map.put(ch, 1);
			}
			else if(map.containsKey(ch) && input_string.charAt(i-1) != ch && i>0){
				map.put(ch, map.get(ch) + 1);
			}
			else continue;
		}

		ArrayList<String> res = new ArrayList<>();
		for(char key : map.keySet()){
			if(map.get(key) >= 2){
				res.add(String.valueOf(key));
			}
		}

		if(res.size() == 0) answer = "N";
		Collections.sort(res);

		for(int i=0; i<res.size(); i++){
			answer += res.get(i);
		}

		return answer;
	}

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution("edeaaabbccd"));
		System.out.println(T.solution("eeddee"));
		System.out.println(T.solution("string"));
		System.out.println(T.solution("zbzbz"));
	}
}


/* 출력
"de"
"e"
"N"
"bz"
*/
