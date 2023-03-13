import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "No";
        int cards1Idx = 0;
        int cards2Idx = 0;
        // int k = 0;
        // ArrayList 사용대도 되지만 while(k < goal.length)를 해서 answer는 if(k == goal.length) answer = "Yes" 이런 식으로도 가능
        
        ArrayList<String> res = new ArrayList<>();
        for(String x : goal){
            if(cards1Idx < cards1.length && x.equals(cards1[cards1Idx])){
                res.add(x);
                cards1Idx++;
            }
            
            // 아무리 && 연산이어도 앞에 조건인 cards2Idx < cards2.length 부터 시작하기 때문에 인덱스 에러가 발생한다.
            // 그러므로 항상 이럴 때는 앞에다가 조건을 붙여준다. -> 이것 때문에 못 풀었다.
            else if(cards2Idx < cards2.length && x.equals(cards2[cards2Idx])){
                res.add(x);
                cards2Idx++;
            }
            else break;
        }

        System.out.println(res);
        if(res.size() == goal.length){
            answer = "Yes";
        }
        
        return answer;
    }

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new String[]{"i", "drink", "water"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"}));
        System.out.println(T.solution(new String[]{"i", "water", "drink"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"}));
	}
}

/* 출력
"Yes"
"No"
*/
