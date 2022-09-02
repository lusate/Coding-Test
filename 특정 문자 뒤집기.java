import java.util.*;

class Main {
    public String solution(String s){
        String answer = "";
        //s 라는 문자열을 char로 바꾼다
        char[] str = s.toCharArray();

        int left = 0;
        int right = s.length()-1;

        while(left < right){
            //str[left]가 알파벳이 아니면
            if(!Character.isAlphabetic(str[left])){
                left++;
            }
            //str[right]가 알파벳이 아니면
            else if(!Character.isAlphabetic(str[right])){
                right--;
            }
            //둘 다 알파벳이라면 서로 위치를 바꾸고 다음 셋으로
            else{
                char tmp = str[left];
                str[left] = str[right];
                str[right] = tmp;
                left++;
                right--;
            }
        }
        //answer = str;로 그냥 str 부를 수 없다. (str은 char이기 때문)
        answer = String.valueOf(str);
        return answer;
    }
    public static void main(String[] args){
        Main T = new Main();
        System.out.println(T.solution("a#b!GE*T@S"));
        System.out.println(T.solution("###ab*@@Sty"));
    }
}


//답
//S#T!EG*b@a
//###yt*@@Sba
