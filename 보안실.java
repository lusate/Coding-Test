import java.util.*;
class Solution{
	public int getTime(String s){
		int H = Integer.parseInt(s.split(":")[0]);
		int M = Integer.parseInt(s.split(":")[1]);

		return H*60+M;
	}
	public String[] solution(String[] reports, int k) {
		HashMap<String, ArrayList<Integer>> map = new HashMap<>();
		
		for(String x : reports){
			String a = x.split(" ")[0];
			String b = x.split(" ")[1];

			// map.put(a, new ArrayList<Integer>());
			map.putIfAbsent(a, new ArrayList<Integer>());
			map.get(a).add(getTime(b));
		}
		
		//System.out.println(map);
		// {daniel=[621, 675], luis=[491, 552, 585, 525, 1128, 635, 645], emily=[514, 552, 574]}

		ArrayList<String> res = new ArrayList<>();
		for(String key : map.keySet()){
			ArrayList<Integer> arr = map.get(key); //arr에 각 직원마다 시간이 들어감.
			// [621, 675] -> daniel
			// [491, 552, 585, 525, 1128, 635, 645] -> luis
			// [514, 552, 574] -> emily

			arr.sort((a,b) -> a-b); //오름차순 정렬

			int lt=0;
			for(int rt=0; rt<arr.size(); rt++){
				while(arr.get(rt) - arr.get(lt) > 60) lt++;
				if(rt-lt+1 == k){
					res.add(key);
					break;
				}
			}
		}

		String[] answer = new String[res.size()];
		res.sort((a, b) -> a.compareTo(b)); //a와 b 비교해서 오르차순으로
		
		for(int i=0; i<res.size(); i++){
			answer[i] = res.get(i);
		}
		
		return answer;
	}
	
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(new String[]{"luis 08:11", "daniel 10:21", "luis 09:12", 
		"emily 08:34", "luis 09:45", "luis 08:45", "luis 18:48", "emily 09:12", 
		"daniel 11:15", "emily 09:34", "luis 10:35", "luis 10:45"}, 3)));
		
		System.out.println(Arrays.toString(T.solution(new String[]{"james 08:35", "james 08:50", "james 00:00"}, 3)));
	}
}


/* 출력
[emily, luis]
[]
*/
