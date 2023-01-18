import java.util.*;
class Info implements Comparable<Info>{
    int num;
	char c;
	Info(int num, char c){
		this.num=num;
		this.c=c;
	}

	@Override
	public int compareTo(Info ob){
		if(this.num == ob.num) return this.c - ob.c; //내림차순
		else return ob.num - this.num;
	}
}
class Solution {
    public String solution(String s) {
		String answer = "";
		HashMap<Character, Integer> map = new HashMap<>();
		for(char x : s.toCharArray()){
			map.put(x, map.getOrDefault(x, 0) + 1);
		}

		PriorityQueue<Info> pq = new PriorityQueue<>();
		for(char key : map.keySet()){

			//pq에 숫자, 알파벳
			pq.offer(new Info(map.get(key), key));
		}

		while(pq.size() > 1){ //2개씩 빼서 하나 감소시킬 때 pq에 하나가 남아있을 수 있음.
			Info tmp1 = pq.poll();
			Info tmp2 = pq.poll();

			answer += tmp1.c;
			answer += tmp2.c;

			if(tmp1.num > 1) pq.add(new Info(tmp1.num - 1, tmp1.c));
			if(tmp2.num > 1) pq.add(new Info(tmp2.num - 1, tmp2.c));
		}

		//G가 하나 남아있음.
		if(pq.size() == 1) answer += pq.poll().c;


		return answer;
    }

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution("AAABBCDEFFG"));
    System.out.println(T.solution("ABCABCAD"));
    System.out.println(T.solution("ABCDEFGAAABDEFGFFGE"));
	}
}


/* 출력
ABAFABCDEFG
ABACABCD
AFAEFGABDEFGABCDEFG
*/
