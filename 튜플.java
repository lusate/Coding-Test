import java.util.*;

class Solution {
    public int[] solution(String s) {
        Set<String> set = new HashSet<>();
        //replaceAll() 에서 "[~]" ~에 들어가는 모든 문자를 변환한다.
        String[] res = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        // 그래서 {, } 를 모두 " "인 공백으로 변한한다.
        // trim()은 문자열 앞뒤 공백을 제거해준다. 그리고 split()으로 " , "를 기준으로 분리.

//        System.out.println(Arrays.toString(res));
        Arrays.sort(res, (a, b) ->{
            return a.length() - b.length();
        }); // 길이가 짧은 것부터 순서대로
//        System.out.println(Arrays.toString(res));

        int[] answer = new int[res.length];
        int idx = 0;
        for (String x1 : res) {
            for (String x2 : x1.split(",")) {
                if (set.add(x2)) {
                    answer[idx++] = Integer.parseInt(x2);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
        System.out.println(Arrays.toString(T.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
        System.out.println(Arrays.toString(T.solution("{{20,111},{111}}")));
        System.out.println(Arrays.toString(T.solution("{{123}}")));
        System.out.println(Arrays.toString(T.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")));
    }
}


/* 출력
[2, 1, 3, 4]
[2, 1, 3, 4]
[111, 20]
[123]
[3, 2, 4, 1]
*/


// -----------------------------------------------------------------------------------------------------------------------------------------------


// 내가 푼 방법
import java.util.*;

class Solution {

    public int[] solution(String s) {
        Map<String, Integer> map = new HashMap<>();

        //map에다가 수를 집어 넣음.  프로그래머스 문제 '수식 최대화'와 비슷함
        String num = "";
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch >= '0' && ch <= '9'){
                num += ch;
            }
            else{
                map.put(num, map.getOrDefault(num, 0) + 1);
                num = "";
                map.remove(""); //key가 ""인 값이 들어갔기 때문에 제거해줌.
            }
        }
        System.out.println(map);

        ArrayList<String> res1 = new ArrayList<>(map.keySet()); //key를 넣음.
        ArrayList<Integer> res2 = new ArrayList<>(map.values()); //values를 넣음.

        //key, values 를 꺼내서 res 배열에 넣어줌.
        int[][] res = new int[res1.size()][2];
        for(int i=0; i<res1.size(); i++){
            res[i][0] = Integer.parseInt(res1.get(i));
            res[i][1] = res2.get(i);
        }
        Arrays.sort(res, (a,b) -> b[1]-a[1]); // values를 기준으로 내림차순.

        // for(int i=0; i<res1.size(); i++){
        //     for(int j=0; j<2; j++){
        //         System.out.print(res[i][j]);
        //     }
        //     System.out.println();
        // }

        int[] answer = new int[res.length];
        for(int i=0; i<res.length; i++){
            answer[i] = res[i][0];
        }
        return answer;
    }

    public static void main(String[] args) {
       Solution T = new Solution();
       System.out.println(Arrays.toString(T.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
       System.out.println(Arrays.toString(T.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
       System.out.println(Arrays.toString(T.solution("{{20,111},{111}}")));
       System.out.println(Arrays.toString(T.solution("{{123}}")));
       System.out.println(Arrays.toString(T.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")));
    }
}
