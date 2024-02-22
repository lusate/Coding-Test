// 내가 푼 방식
import java.util.*;
class Solution{
    public int[] solution(int n, String[] words) {
        ArrayList<String> res = new ArrayList<>();
        int[] answer = {0, 0};

        for (int i = 0; i < words.length; i++) {
            if (res.contains(words[i])) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }

            res.add(words[i]);
          
            if (i > 0 && words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1)) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));

        System.out.println(Arrays.toString(T.solution(5, new String[]{"hello", "observe",
                "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"})));

        System.out.println(Arrays.toString(T.solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"})));
    }
}


/* 출력
[3, 3]
[0, 0]
[1, 3]
*/


// ------------------------------------------------------------------------------------------------

// 다른 풀이 Map
import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<words.length; i++){
            if(i != 0){
                String str1 = words[i-1];
                String str2 = words[i];

                char last = str1.charAt(str1.length() - 1);
                char first = str2.charAt(0);

                if(map.containsKey(str2) || last != first){
                    answer[0] = (i % n) + 1;
                    answer[1] = (i / n) + 1;
                    return answer;
                }
            }
            map.put(words[i], 1);
        }
        

        return answer;
    }
}


// ------------------------------------------------------------------------------------------------

// 다른 풀이 Set
import java.util.*;
class Solution{
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int cnt = 1;
        Set<String> set = new HashSet<>();
        set.add(words[0]);

        //먼저 처음 단어를 set에 넣고 그 다음 단어와 비교.
        for (int i = 1; i < words.length; i++) {
            // 이미 존재하면 바로 빠져나옴.
            if(set.contains(words[i])) break; // 같은 단어라 하더라도 끝말잇기가 가능하면 계속 이어서 함. 같은 단어가 나오면 멈춰야 함.

            if (words[i].charAt(0) == words[i - 1].charAt(words[i - 1].length() - 1)) {
                set.add(words[i]);
                cnt++; // cnt가 아닌 set.size()로 계산해도 가능
            }
            else break;
        }

        if(cnt == words.length) answer = new int[]{0, 0};
        else answer = new int[]{cnt % n + 1, cnt / n + 1};

        return answer;
    }
}
