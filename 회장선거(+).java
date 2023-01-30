import java.util.*;
class Main{
	private static String solution(String[] votes, int k){
		String answer = "";
		HashMap<String, HashSet<String>> map = new HashMap<>();
		HashMap<String, Integer> candidate = new HashMap<>();
		HashMap<String, Integer> present = new HashMap<>();

		for(String x : votes){
			String a = x.split(" ")[0];
			String b = x.split(" ")[1];

			//HashMap 안에 HashSet이 있을 때 삽입하는 방법!!!
			map.putIfAbsent(a, new HashSet<>());
			map.get(a).add(b);


			candidate.put(b, candidate.getOrDefault(b, 0)+1);
		}

// 		System.out.println(map);
// 		System.out.println(candidate);


		int max = Integer.MIN_VALUE;
		for(String a : map.keySet()){ //a는 추천한 사람들.
			int cnt=0;
			for(String b : map.get(a)){ //b는 추천 받은 사람들.
				//추천 횟수가 k번 이상이면 카운트
				if(candidate.get(b) >= k) cnt++;
			}

			present.put(a, cnt); //a ->선물 받은 사람들(추천한 사람들 중에서)
			//cnt -> 출마한 사람들에게 선물 받은 수.
			max = Math.max(max, cnt);
		}
		//System.out.println(present);

		ArrayList<String> arr = new ArrayList<>();
		for(String x : present.keySet()){
			if(present.get(x) == max) arr.add(x);
		}

		System.out.println(arr);
		Collections.sort(arr);
		answer = arr.get(0);

		return answer;
	}

	//putIfAbsent(keyset이 포함된 HashMap에서 사용.)
	//Key 값이 존재하는 경우 Map의 Value의 값을 반환하고, 
	//Key값이 존재하지 않는 경우 Key와 Value를 Map에 저장.
	
	public static void main(String[] args){
		System.out.println(solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", 
		"daniel tom", "luis john"}, 2));
		
		System.out.println(solution(new String[]{"john tom", "park luis", 
		"john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", 
		"tom john", "tom park", "tom luis"}, 3));
	}
}



/* 출력
daniel
*/
