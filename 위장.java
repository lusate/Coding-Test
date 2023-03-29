import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        // System.out.println(map);
        
        for(String key : map.keySet()){
            answer *= map.get(key) + 1; //선택하지 않는 경우도 고려
        }
        
        
        //둘 다 선택하지 않을 순 없으므로 -1해줌
        return answer-1;
    }
}
