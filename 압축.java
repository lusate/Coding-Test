import java.util.*;

public class 압축 {
    /**
     * 인덱스를 위해 배열을 사용하려고 하는데 크기 때문에 애매하다고 느껴지면 Map을 생각해보자.
     */
    public int[] solution(String msg) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put(String.valueOf((char) ('A' + i)), i + 1);
        }

        ArrayList<Integer> arr = new ArrayList<>();
        int idx = 0;
        while(idx < msg.length() - 1) {
            String now = "";
            String pre = String.valueOf(msg.charAt(idx));

            /**
             * 만들어진 문자가 map도 포함되어 있지 않으면 map가 추가하고 break 해서 빠져나오기
             */
            for (int i = 1; i <= msg.length() - idx; i++) {
                now = msg.substring(idx, idx + i);
                if (!map.containsKey(now)) {
                    map.put(now, map.size() + 1);
                    break;
                }
                pre = now;
            }

            /**
             * pre는 map에 포함되는 문자열이기 때문에 arr 에 삽입한다.
             * 그리고 index를 늘려줌으로써 now 를 위한 문자열을 뽑아낸다.
             */
            arr.add(map.get(pre));
            idx = idx + pre.length();
        }

        if (idx == msg.length() - 1) {
            arr.add(map.get(String.valueOf(msg.charAt(idx))));
        }

        int[] answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        압축 T = new 압축();
        System.out.println(Arrays.toString(T.solution("KAKAO")));
//        System.out.println(T.solution("TOBEORNOTTOBEORTOBEORNOT"));
//        System.out.println(T.solution("ABABABABABABABAB"));
    }
}



/* answer
[11, 1, 27, 15]
[20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34]
[1, 2, 27, 29, 28, 31, 30]
*/


// -----------------------------------------------------------------------------------------------------------------------

// Map으로가 아닌 내가 생각했던 ArrayList로도 바로 할 수 있다. (근데 Map으로가 더 쉬울 것 같아서 Map으로 푸는 방식을 바꿨음.)
package 프로그래머스;

import java.util.*;

public class 압축 {
    public int[] solution(String msg) {
        ArrayList<String> dic = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            dic.add(String.valueOf((char) ('A' + i)));
        }

        for (int i = 0; i < msg.length(); i++) {
            for (int j = dic.size() - 1; j >= 0; j--) {
                if (msg.substring(i).startsWith(dic.get(j))) {
                    i += dic.get(j).length() - 1;
                    arr.add(j + 1);
                    if (i + 1 < msg.length()) {
                        dic.add(dic.get(j) + msg.charAt(i + 1));
                    }
                    break;
                }
            }
        }

        int[] answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        return answer;
    }
}

