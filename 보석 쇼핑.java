import java.util.*;
class Main {
	public int[] solution(String[] gems) {
		int[] answer = new int[2];
		HashSet<String> set = new HashSet<>();
		HashMap<String, Integer> map = new HashMap<>();

		for(int i=0; i<gems.length; i++){
			set.add(gems[i]);
		}

		int start = 0;
		int tempStart = 0;
		int n = gems.length;
		
		Queue<String> Q = new LinkedList<>();
		for(int i=0; i<gems.length; i++){
			map.put(gems[i], map.getOrDefault(gems[i], 0)+1);
			
			Q.offer(gems[i]);
			while(!Q.isEmpty()){
				String gem = Q.peek();
				if(map.get(gem) > 1){// 중복이 있는 RUBY와 DIA
					map.put(gem, map.get(gem) - 1); //중복인 key의 value는 1감소
					Q.poll(); //Q에서 제거
					tempStart++; //start 를 뒤로 밀고 감
				}
				else break;
			}
			
			if(map.size() == set.size()){//map 크기와 set 크기가 같다면
				if(n > Q.size()){ // 모든 보석이 Q에 한 번 이상씩 포함되었다는 의미
					n = Q.size(); //현재 모든 보석이 포함된 길이(n) 보다 Q의 크기가 더 작은지 확인
					start = tempStart; //더 작으면 Q의 크기를 n으로 지정해주고 시작 지점을 재설정
				}
			}//n의 크기가 더 크면 위 연산 다시 반복
		}
		answer = new int[]{start + 1, start + n};
		return answer;
	}
		
	public static void main(String[] args){
		Main T = new Main();
		String[] gems1 = new String[]{"DIA", "RUBY", "RUBY","DIA","DIA","EMERALD","SAPPHIRE","DIA"};
		for(int x : T.solution(gems1)){
			System.out.print(x + " ");
		}
		//System.out.println();

		//String[] gems2 = new String[]{"AA", "AB", "AC","AA","AC"};
		//for(int x : T.solution(gems2)){
		//	System.out.print(x + " ");
		//}
		//System.out.println();

		//String[] gems3 = new String[]{"XYZ", "XYZ", "XYZ"};
		//for(int x : T.solution(gems3)){
		//	System.out.print(x + " ");
		//}
	}
}
