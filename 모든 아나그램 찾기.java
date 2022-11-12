public class Main {
	public int solution(String a, String b) {
		int answer=0;
		HashMap<Character, Integer> am = new HashMap<>();
		HashMap<Character, Integer> bm = new HashMap<>();
		for(char x : b.toCharArray()) {
			bm.put(x,  bm.getOrDefault(x, 0) + 1);
		}
		int L=b.length()-1;
		
		for(int i=0; i<L; i++) {
			am.put(a.charAt(i), am.getOrDefault(a.charAt(i), 0) + 1);
		}
		
		int left=0;
		for(int right = L; right < a.length(); right++) {
			am.put(a.charAt(right), am.getOrDefault(a.charAt(right), 0) + 1);
			if(am.equals(bm)) answer++;
			am.put(a.charAt(left), am.get(a.charAt(left)) - 1);
			if(am.get(a.charAt(left)) == 0) am.remove(a.charAt(left));
			left++;
		}
		
		return answer;
	}
	
	public static void main(String[] args) throws Exception {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next();
		String b = sc.next();
		System.out.println(T.solution(a, b));
	}
}


/* 입력
bacaAacba
abc
*/

/* 출력
3
*/
