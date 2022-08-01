import java.util.*;
class Main {
    public int solution(){
		int left=0;
		int right=0;
		int n = t.length();
		int min = Integer.MAX_VALUE;
		int head=0;

		HashMap<Character, Integer> map = new HashMap<>();
		for(int i=0; i<n; i++){
			int cnt = map.getOrDefault(t.charAt(i), 0);
			map.put(t.charAt(i), cnt+1);
		}

		while(right < s.length()){
			char c = s.charAt(right);
			int cnt = map.getOrDefault(c, 0);
			if(cnt > 0){
				n--;
			}//ABC 모두 포함되어 t의 길이가 0이 됌
			map.put(c, cnt-1);
			right++;


			while(n == 0){
				if(right-left < min){
					min = right-left;
					head = left;
				}

				char ch = s.charAt(left);
				int count = map.getOrDefault(ch, 0);
				if(count == 0){
					n++;//A,B,C 모두 포함되면 t 길이 다시 늘림
				}
				map.put(ch, count+1);
				left++; //A,B,C 모두 포함되어 있으면 left++
			}
		}
		return min == Integer.MAX_VALUE ? "" : s.substring(head, head+min);
	}

	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution("ADOBECODEBANC", "ABC"));
	}
}
