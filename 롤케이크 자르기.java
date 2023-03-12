//HashSet을 2개 사용하여 이중 for문 돌릴 때 시간초과 발생.
//HashSet을 하나만 사용하여 chulsoo와 brother 배열에 롤케이크 종류를 넣기로 함.

import java.util.*;
class Solution {
	public int solution(int[] topping) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        
        int[] chulsoo = new int[topping.length];
        int[] brother = new int[topping.length];
        
        for(int i=0; i<topping.length; i++){
            set.add(topping[i]);
            chulsoo[i] = set.size();
        }
        set.clear(); //HashSet을 초기화해서 다시 사용할 수 있도록 해줌.
        
        for(int i=topping.length-1; i>=0; i--){
            set.add(topping[i]);
            brother[i] = set.size();
            //동생은 반대로 해서 채워줌. -> 형이 인덱스 0을 가져갈 때 동생은 나머지 인덱스를 모두 가져가기 때문
        }
        
        // System.out.println(Arrays.toString(chulsoo));
        // 	[1, 2, 2, 3, 3, 4, 4, 4]
        // System.out.println(Arrays.toString(brother));
        // 	[0, 4, 4, 4, 3, 3, 2, 1]
        
        for(int i=0; i<topping.length-1; i++){
            if(chulsoo[i] == brother[i+1]){
                answer++;
            }
        }
        return answer;
    }

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2}));
		System.out.println(T.solution(new int[]{1, 2, 3, 1, 4}));
	}
}

/* 출력
2
0
*/



//HashMap을 이용해서 set에 topping[0] 넣고 topping 개수를 map으로 카운팅하여 for문으로 -1 카운팅 하면서
//set에 넣어주는 식으로 해도 가능은 하지만 조금 느림.

/*
import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int n = topping.length;
        
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        set.add(topping[0]);
        for (int i = 1; i < size; i++) {
            map.put(topping[i], map.getOrDefault(topping[i], 0) + 1);
        }
        
        for (int i = 1;i < size; i++) {
            set.add(topping[i]);
            map.put(topping[i], map.get(topping[i]) - 1);
            if (map.get(topping[i]) == 0) {
                map.remove(topping[i]);
            }
            if (set.size() == map.size()) answer++;
        }
        
        
        return answer;
    }
}
*/
