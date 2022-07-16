class Solution {
    public String solution(String new_id) {
        String answer;
        
        // 1단계 -> 모두 소문자로
        String step1 = new_id.toLowerCase();

        // 2단계 -> 문자 제거
        char[] step1_arr = step1.toCharArray();
        StringBuilder step2 = new StringBuilder();
        for (char x : step1_arr) {
            if ((x >= 'a' && x <= 'z') || (x >= '0' && x <= '9') || x == '-' || x == '_' || x == '.') {
                step2.append(x);
            }
        }

        // 3단계 '.' 중복 제거
        String step3 = step2.toString().replace("..", ".");
        while (step3.contains("..")) {
            step3 = step3.replace("..", ".");
        }

        // 4단계 맨 앞 맨 뒤 '.' 제거
        String step4 = step3;
        if (step4.length() > 0) {
            if (step4.charAt(0) == '.') { //첫 번째 . 를 제외하고 나머지를 뽑아냄
                step4 = step4.substring(1, step4.length());
            }
        }
        if(step4.length() > 0){
            if(step4.charAt(step4.length()-1) == '.'){
                step4 = step4.substring(0, step4.length()-1);
            }
        }
        
        //5단계 -> 빈 문자열이면 "a"
        String step5 = step4;
        if(step5.equals("")){
            step5 = "a";
        }
        
        //6단계 -> 길이가 16 이상이면 16넘어가는 문자들은 제거
        String step6 = step5;
        if(step6.length() >= 16){
            step6 = step6.substring(0, 15);
            if(step6.charAt(step6.length()-1) == '.'){
                step6 = step6.substring(0, 14);
            }
        }

        //7단계 -> 길이가 2자면 길이가 3이 될 때까지 반복해서 끝에 붙임
        String step7 = step6;
        if(step7.length() <= 2){
            while(step7.length() < 3){
                step7 += step7.charAt(step7.length()-1);
            }
        }
        answer = step7;
        return answer;
    }
    
    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution("...!@BaT#*..y.abcdefghijklm"));
    }
}

//결과는  "bat.y.abcdefghi"
