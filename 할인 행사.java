import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
		int answer = 0;
		HashMap<String, Integer> map = new HashMap<>();

		int cnt = 0;
		for(int i=0; i<want.length; i++){
			map.put(want[i], number[i]);
			cnt += number[i]; // 10일 동안 이기 때문에 이렇게 한 것인데 문제에서는 10으로 고정했으므로 그냥 10으로 초기화해도 무관
		}

		for(int i=0; i<=discount.length-cnt; i++){
			HashMap<String, Integer> tmp = new HashMap<>();

			for(String key : map.keySet()){
				tmp.put(key, map.get(key));
			}

			boolean isExist = true; // 회원 가입을 할 것인지 안 할 것인지 여부
			for(int j=0; j<cnt; j++){ //열흘동안
				int idx = i+j;
				String idxKey = discount[idx];

				if(!tmp.containsKey(idxKey)){ // tmp에 없으면 break;
					isExist = false; //존재하지 않으므로 회원가입 안함.
					break;
				}

				int valueCnt = tmp.get(idxKey); //tmp의 값들
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
			
			// tmp의 값이 0이어야 개수만큼 모두 할인한 것.
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

// ---------------------------------------------------------------------------------------------------------

// 다시 푼 문제 풀이
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        int st = 0;
        int day = 10;
        int ed = discount.length;

        // Map으로
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        for (int i = 0; i < ed - day + 1; i++) {
            HashMap<String, Integer> tmp = new HashMap<>();
            for (int j = st; j < st + day; j++) { // 10번을 해야 함
                if (st + 10 <= ed) {
                    tmp.put(discount[j], tmp.getOrDefault(discount[j], 0) + 1);
                }
            }
//            for(int j = 0; j < day; j++){
//                tmp.put(discount[i + j], tmp.getOrDefault(discount[i + j], 0) + 1);
//            }


            boolean flag = true;
            for (String key : map.keySet()) {
                if (map.get(key) != tmp.get(key)) {
                    flag = false;
                }
            }
            if (flag) {
              answer += 1;
            } else {
              answer += 0;
            }
             // answer += flag ? 1 : 0;

            st++;
        }

        return answer;
    }
}

/* 출력
3
0
*/
