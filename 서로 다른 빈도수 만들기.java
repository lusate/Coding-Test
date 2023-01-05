import java.util.*;
class Main{
	private static int solution(String s){
		int answer = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		HashSet<Integer> set = new HashSet<>();
		
		for(char x : s.toCharArray()){
			map.put(x, map.getOrDefault(x, 0)+1);
		}

		for(char key : map.keySet()){
			
			while(set.contains(map.get(key))){ //참이면 유니크하지 않음.
				answer++;
				map.put(key, map.get(key) - 1); //유니크하지 않으므로 -1해줌.
			}
			
			//여기부터는 유니크함.
			if(map.get(key) == 0) continue;

			set.add(map.get(key));
		}
		


		return answer;
	}
	
	public static void main(String[] args){
		System.out.println(solution("aaabbbcc"));
		System.out.println(solution("aaabbc"));
		System.out.println(solution("aebbbbc"));
		System.out.println(solution("aaabbbccde"));
	}
}
