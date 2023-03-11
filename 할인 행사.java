import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
		int answer = 0;
		HashMap<String, Integer> map = new HashMap<>();

		int cnt = 0;
		for(int i=0; i<want.length; i++){
			map.put(want[i], number[i]);
			cnt += number[i];
		}

		for(int i=0; i<=discount.length-cnt; i++){
			HashMap<String, Integer> tmp = new HashMap<>();

			for(String key : map.keySet()){
				tmp.put(key, map.get(key));
			}

			boolean isExist = true;
			for(int j=0; j<cnt; j++){
				int idx = i+j;
				String idxKey = discount[idx]; // 10개씩

				if(!tmp.containsKey(idxKey)){ // tmp에 없으면 break;
					isExist = false;
					break;
				}

				int valueCnt = tmp.get(idxKey);
				if(valueCnt - 1 < 0){ //tmp의 값에서 -1을 했을 때 0보다 작으면 break
					isExist = false;
					break;
				}

				tmp.put(idxKey, valueCnt - 1);
			}

			if(isExist){ // 위 2가지를 제외하고 tmp의 값을 봤더니 0이 없으면 break
				for(String key : map.keySet()){
					if(tmp.get(key) != 0){
						isExist = false;
						break;
					}
				}

			}

			if(isExist) answer++;
		}

		return answer;
    }

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, 
		new int[]{3, 2, 2, 2, 1}, new String[]{"chicken", "apple", "apple", "banana", "rice", 
		"apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}));

		System.out.println(T.solution(new String[]{"apple"}, 
		new int[]{10}, new String[]{"banana", "banana", "banana", "banana", "banana", 
		"banana", "banana", "banana", "banana", "banana"}));
	}
}


/* 출력
3
0
*/
