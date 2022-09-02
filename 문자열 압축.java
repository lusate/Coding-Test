import java.util.*;

class Main {
    public String solution(String s){
        String answer = "";
        //KK 로 중복됬으면 2가 되어야한다.
        int cnt = 1;
        //이거 안 쓰면 마지막 글자 E가 출력되지 않음
        //s의 마지막 문자도 비교할 문자가 존재해야 한다.
        s = s + ' ';

        //s.length()는 11
        //두 문자열 묶어서 비교하면 10번이므로 -1을 해줘야 한다.
        for(int i=0; i<s.length()-1; i++){

            //앞뒤 문자가 같다면
            if(s.charAt(i) == s.charAt(i+1)){
                cnt++;
            }
            else{
                answer += s.charAt(i); //앞 뒤 문자가 같지 않으면 문자를 씀
                //cnt가 2 이상이면 문자 뒤에 cnt를 출력한다.
                if(cnt > 1){
                    //cnt를 int가 아닌 String으로 해서 출력해야 한다.
                    answer += String.valueOf(cnt);
                    //cnt를 다시 1로 초기화 해야 한다.
                    cnt = 1;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
        Main T = new Main();
        System.out.println(T.solution("KKHSSSSSSSE"));
        System.out.println(T.solution("AAABCCCDD"));
    }
}

답
K2HS7E
A2BC3D2
