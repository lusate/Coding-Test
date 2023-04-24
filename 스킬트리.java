import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(String s : skill_trees){
            String tmp = s; // 스킬들

            for(int i=0; i<s.length(); i++){
                String str = s.substring(i, i+1);

                if(!skill.contains(str)){ // skill에 skill_trees가 포함되어 있는지 확인.
                    //포함되어 있지 않으면 제거
                    tmp = tmp.replace(str, "");
//                    System.out.println(tmp);
                }
            }

            // 제거하고 남은 tmp가 skill의 첫번째 인덱스에 있으면 순서 지킨 것.
            if(skill.indexOf(tmp) == 0){
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }
}

/* 출력
2
*/
