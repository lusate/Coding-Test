import java.util.*;

public class Solution {

    public int solution(String[] friends, String[] gifts) {
        int answer = 0;

        HashMap<String, HashMap<String, Integer>> map = new HashMap<>();
        for (String from : friends) {
            HashMap<String, Integer> tmp = new HashMap<>();

            for (String to : friends) {
                tmp.put(to, 0);
            }

            tmp.put("exponent", 0);
            map.put(from, tmp);
        }

        for (String gift : gifts) {
            String send = gift.split(" ")[0];
            String receipt = gift.split(" ")[1];

            // 선물을 준 개수
            map.get(send).put(receipt, map.get(send).get(receipt) + 1);
            // 선물 지수 - 선물 지수는 선물을 준 횟수를 말한다.
            map.get(send).put("exponent", map.get(send).get("exponent") + 1);

            // 선물을 받은 개수
            map.get(receipt).put(send, map.get(receipt).get(send) - 1);
            // 선물을 받았으니 지수는 받은 수만큼 떨어진다.
            map.get(receipt).put("exponent", map.get(receipt).get("exponent") - 1);
        }
        System.out.println("map = " + map);


        for (String from : friends) {
            int nextMonthGift = 0;
            for (String to : friends) {
                // 본인이 아니라면
                if (!from.equals(to)) {
                    int sendCount = map.get(from).get(to);
                    int receiptCount = map.get(to).get(from);

                    if (sendCount > receiptCount) {
                        nextMonthGift++;
                    } 
                    // 주고 받은 수가 같으면 지수를 통해 비교
                    else if (sendCount == receiptCount && map.get(from).get("exponent") > map.get(to).get("exponent")) {
                        nextMonthGift++;
                    }
                    // 선물 지수가 모두 같은 경우 아무것도 하지 않음.
                }
            }

            // 다음 달에 가장 선물을 많이 받은 사람의 선물 수를 구함. (최댓값)
            if (answer < nextMonthGift) {
                answer = nextMonthGift;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new String[]{"muzi", "ryan", "frodo", "neo"},
                new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"}));

//        System.out.println(T.solution(new String[]{"a", "b", "c"},
//                new String[]{"a b", "b a", "c a", "a c", "a c", "c a"}));
    }
}
