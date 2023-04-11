import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];

        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<players.length; i++){
            map.put(players[i], i);
        }
        // System.out.println(map);

        for(String x : callings){
            int idx = map.get(x);

            if(idx > 0){
                String tmp = players[idx-1];
                players[idx-1] = players[idx];
                players[idx] = tmp;

                // 순위 바꿨으면 map에서도 순위를 바꿔줘야 한다.
                map.put(players[idx-1], idx-1);
                map.put(players[idx], idx);
            }
        }

        for(int i=0; i<players.length; i++){
            answer[i] = players[i];
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new String[]{"mumu", "soe", "poe", "kai", "mine"},
                new String[]{"kai", "kai", "mine", "mine"})));
    }
}

/* 출력
["mumu", "kai", "mine", "soe", "poe"]
*/
