import java.util.*;
class Solution {
    public static int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];
        HashMap<String, HashSet<String>> map = new HashMap<>();
        HashMap<String, Integer> stop = new HashMap<>();
		//report에서 중복을 없앤 set을 가져옴.
        HashSet<String> set = new HashSet<>(Arrays.asList(report));

		//System.out.println(set);
		//[apeach frodo, muzi frodo, apeach muzi, frodo neo, muzi neo]
		//[ryan con]


        for(String x : set){
            String a = x.split(" ")[0];
            String b = x.split(" ")[1];
            map.putIfAbsent(a, new HashSet<String>());
            map.get(a).add(b);
            stop.put(b, stop.getOrDefault(b, 0) + 1);
        }
		System.out.println(map);
		System.out.println(stop);
		//{muzi=[neo, frodo], frodo=[neo], apeach=[muzi, frodo]}
		//{muzi=1, neo=2, frodo=2}

		for(int i=0; i<id_list.length; i++){
			int cnt = 0;
			//neo가 신고한 사람은 없기 때문에 null
			//System.out.println(map.get(id_list[i]));
			// [neo, frodo]
			// [neo]
			// [muzi, frodo]
			// null

			if(map.get(id_list[i]) == null) continue;
			for(String key : map.get(id_list[i])){
				if(stop.get(key) >= k){
					cnt++;
				}
			}

			answer[i] = cnt;
		}

        return answer;
    }

	public static void main(String[] args){
		String[] id_list = new String[]{"muzi", "frodo", "apeach", "neo"};
		String[] report = new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		System.out.println(Arrays.toString(solution(id_list, report, 2)));


		String[] id_list2 = new String[]{"con", "ryan"};
		String[] report2 = new String[]{"ryan con", "ryan con", "ryan con", "ryan con"};
		//System.out.println(Arrays.toString(solution(id_list2, report2, 3)));
	}
}



/* 츌력
[2,1,1,0]

[0,0]
*/
