import java.util.*;
import java.io.*;

class Solution{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		//문자 '1' 의 개수가 짝수면 모두 제거 가능, 홀수면 제거 불가능.
		for (int test_case = 1; test_case <= T; test_case++) {
			String s = sc.next();
			int cnt = 0;
			for(int i=0; i<s.length(); i++){
				if(s.charAt(i) == '1') cnt++;
			}

			if(cnt % 2 == 0){
				System.out.println("#" + test_case + " no");
			}
			else{
				System.out.println("#" + test_case + " yes");
			}
		}
	}
}

/* 입력
3
010
0000
11111
*/

/* 출력
#1 yes
#2 no
#3 yes
*/
