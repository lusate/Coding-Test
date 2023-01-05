import java.util.*;
class Main{
	private static ArrayList<Integer> solution(String s){
		ArrayList<Integer> answer = new ArrayList<>();
		HashMap<Character, Integer> map = new HashMap<>(); //abcde
		
		String str = "abcde";

		for(char x : str.toCharArray()){
			map.put(x, map.getOrDefault(x, 0));
		}

		for(char x : s.toCharArray()){
			map.put(x, map.getOrDefault(x, 0)+1);
		}

		//System.out.println(map);
		//{a=3, b=1, c=1, d=0, e=0}

		int max = 0;
		for(char key : map.keySet()){
			if(map.get(key) > max){
				max = map.get(key);
			}
		}

		
		for(char x : str.toCharArray()){
			answer.add(max - map.getOrDefault(x, 0));
		}

		return answer;
	}
	
	public static void main(String[] args){
		System.out.println(solution("aaabc"));
		System.out.println(solution("aabb"));
		System.out.println(solution("abcde"));
	}
}
