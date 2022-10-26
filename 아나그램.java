import java.util.*;
class Main{
	public String solution(String s1, String s2){
		String answer = "yes";
		HashMap<Character, Integer> map = new HashMap<>();
		for(char x : s1.toCharArray()){
			map.put(x, map.getOrDefault(x, 0) + 1);
		}
		
		for(char x : s2.toCharArray()){
			if(!map.containsKey(x) || map.get(x) == 0){ //거짓이면 아나그램이 아님.
				return "no";
			}
			map.put(x, map.get(x)-1);
		}
		//map.get(x) == 0 는 
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner sc = new Scanner(System.in);

		String s1 = sc.next();
		String s2 = sc.next();
		System.out.print(T.solution(s1, s2));
	}
}

/* 입력
AbaAeCe
baeeACA

abaCC
Caaab
*/

/* 출력
yes

no
*/
