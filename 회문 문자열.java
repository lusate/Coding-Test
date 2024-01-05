//1 번째 방법
import java.util.*;

class Main {
    public String solution(String s){
        String answer = "No";
        //StringBuilder?????
        String str = new StringBuilder(s).reverse().toString();

        //문자 s 와 s를 거꾸로한 str이 같다면 answer = Yes
        //equalsIgnoreCase()는 대소문자 비교 안 함.
        if(s.equalsIgnoreCase(str)){
            answer = "Yes";
        }
        return answer;
    }
    public static void main(String[] args){
        Main T = new Main();
        System.out.println(T.solution("gooG"));
        System.out.println(T.solution("Moon"));
    }
}


//2 번째 방법
import java.util.*;

class Main {
    public String solution(String s){
        String answer = "Yes";
        int left = 0;
        int right = s.length() - 1;

        //대문자로 바꿔줌
        s = s.toUpperCase();

        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return "No";
            }
            else{
                left++;
                right--;
            }
        }
        return answer;


    }
    public static void main(String[] args){
        Main T = new Main();
        System.out.println(T.solution("gooG"));
        System.out.println(T.solution("Moon"));
    }
}


답
YES
NO
