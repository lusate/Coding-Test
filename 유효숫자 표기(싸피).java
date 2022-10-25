import java.util.*;
import java.io.*;

class Solution{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		for(int test_case=1; test_case<=T; test_case++){
			String s = sc.next();
			int len = s.length()-1;
			sb.append("#").append(test_case).append(" ");

			//9999 처럼 앞 2자리가 99이고 3자리가 5보다 크면 반올림했을 때 10.0 이므로 1.0으로 해줌
			if(s.substring(0,2).equals("99") && s.charAt(2)-'0' >= 5){
				sb.append("1.0");
				len = s.length(); //10.0 -> 1.0이 됐으므로 s 길이 더해줌.
			}
			else{
				//588235 처럼 3번째 자리가 5보다 크면 5.9가 되므로 58문자를 정수로 바꾸고 1 더해서 
				//59로 만들어줌
				int num = s.charAt(2) - '0';
				if(num >= 5){
					int a = Integer.parseInt(s.substring(0, 2)) + 1;
					//System.out.println(a);
					sb.append(a/10).append(".").append(a%10); //59를 5.9로 만들어줌
				}
				else{
					//584235 처럼 3번째 자리가 5보다 작으면 반올림해서 5.8이 됨.
					sb.append(s.charAt(0)).append(".").append(s.charAt(1));
				}
			}
			sb.append("*10^").append(len).append("\n");
		}
		System.out.println(sb);
	}
}


/* 입력
4
100
9999
588235
602214090000000000000000
*/

/* 출력
#1 1.0*10^2
#2 1.0*10^4
#3 5.9*10^5
#4 6.0*10^23
*/
