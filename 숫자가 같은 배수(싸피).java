import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
		    sc.nextLine();
        //각 줄에는 자연수 N (1 ≤N ≤ 106) 이 공백 하나를 사이로 두고 주어진다고 했으므로 해준 
		

        for(int test_case = 1 ; test_case <= T ; test_case++) {
          //자릿수를 보기 위해 String으로 함.
            String s = sc.nextLine(); //수 입력
            int n = Integer.parseInt(s); //문자열 s를 정수로

            int result = 0; //배수를 했을 때 결과.
            int multi = 2; //2의 배수부터 시작하므로 2부터 시작.

            String resultStr = ""; //배수를 곱했을 때 문자열을 저장하기 위한 변수
            int resultLength = 0; //배수한 값의 길이.

            int cnt=0; //일치하는 숫자의 개수를 카운트

            //입력한 숫자의 자릿수가 배수를 했을 때 자릿수보다 커지기 전까지 반복
            while(s.length() >= resultLength){
                cnt=0; //일치하는 숫자의 개수를 카운트 (다음 테스트 케이스로 넘어갈 때 cnt 0으로 초기화 시켜줘야 함.)

                result = n * multi; //1035의 경우 n은 1035, multi가 2,3,4,...배수

                //배수한 값을 String으로 하고 length 해줌
                resultStr = Integer.toString(result);
                resultLength = resultStr.length();

                if(s.length() < resultLength){ //배수한 값의 자릿수가 더 커지면 break
                  break;
                }

              for(int i=0; i<resultLength; i++){
                  if(s.indexOf(resultStr.charAt(i)) == -1){ //1035의 경우 입력한 문자열 1035을 2의 배수를 했다고 가정했을 때
                    //2,0,7,0을 s에서 찾지 못하면 -1이라는 뜻
                    break;
                  }
                  else{//일치하는 숫자의 개수를 카운트
                    cnt++;
                  }
              }

              if(cnt == s.length()){
                  System.out.println("#" + test_case + " possible");
                  resultLength = 1000000;
                  break;
              }
              multi++; // 2의 배수했으니 다음 3의 배수로
              cnt=0;
            }

            if(cnt != s.length()){
                System.out.println("#" + test_case + " impossible");
            }
        }
    }
}


/*입력
3
142857
1
1035
*/

/*출력
#1 possible
#2 impossible
#3 possible
*/
