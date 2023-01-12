import java.util.*;
class Solution {
    private static int[] solution(String[] gems) {
        int[] answer = new int[2];
		//배열을 set으로 바꾸기
		HashSet<String> set = new HashSet<>(Arrays.asList(gems));
		HashMap<String, Integer> map = new HashMap<>();

		for(int i=0; i<gems.length; i++){
			set.add(gems[i]);
		}
		System.out.println(set);

		int k = set.size(); //k는 4
		int min = 1000000;
		int left=0;
		for(int right=0; right<gems.length; right++){
			map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);

			while(map.size() == k){
				if(right - left + 1 < min){ //길이가 최소가 되도록.
					min = right - left + 1;
					answer = new int[]{left+1, right+1}; //인덱스를 1부터 시작했기 때문.
				}

				map.put(gems[left], map.getOrDefault(gems[left], 0) - 1);

				if(map.get(gems[left]) == 0){ //개수가 0이 되면 remove로 삭제해서 while 돌림.
					map.remove(gems[left]);
				}

				left++;
			}
		}


		return answer;
    }

	public static void main(String[] args){
		System.out.println(Arrays.toString(solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"})));
		//System.out.println(Arrays.toString(solution(new String[]{"AA", "AB", "AC", "AA", "AC"})));
		//System.out.println(Arrays.toString(solution(new String[]{"XYZ", "XYZ", "XYZ"})));
	}
}

/* 출력
[3, 7]
[1, 3]
[1, 1]
*/
