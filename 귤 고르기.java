import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int x : tangerine){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        
        List<Integer> res = new ArrayList<>(map.keySet());
        res.sort((a,b) -> map.get(b) - map.get(a));
        // System.out.println(res);
        //res에는 내림차순으로 키들이 들어있음
        
        int i=0;
        while(k > 0){
            // k에 map의 값만큼 빼서 음수가 나오면 더 이상 진행 안 함.
            k -= map.get(res.get(i));
            answer++;
            i++;
        }
        
        return answer;
    }

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
		System.out.println(T.solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
		System.out.println(T.solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}));
	}
}


/* 출력
3
2
1
*/
