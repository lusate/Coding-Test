import java.util.*;
import java.io.*;

class Solution{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] arr = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

		for (int test_case = 1; test_case <= T; test_case++) {
			String s = sc.next();
			int year = Integer.parseInt(s.substring(0, 4));
			int month = Integer.parseInt(s.substring(4, 6));
			int day = Integer.parseInt(s.substring(6, 8));

			if(month > 0 && month < 13 && day <= arr[month]){
				if(year < 1000){ // 1000 보다 작을 때 101년이면 0101로 출력
					if(month < 10 && day < 10){
						System.out.println("#" + test_case + " 0" + year + "/" + 
						"0" + month + "/" + "0" + day);
					}
					else{
						System.out.println("#" + test_case + " 0" + year + "/" + 
						 month + "/" + day);
					}
				}
				else if(month < 10){
					System.out.println("#" + test_case + " " + year + 
					"/0" + month + "/" + day);
				}
				else{
					System.out.println("#" + test_case + " " + year + "/" + 
					month + "/" + day);
				}
			}
			else{
				System.out.println("#" + test_case + " " + -1);
			}
		}
	}
}


/* 입력
5
22220228
20150002
01010101
20140230
11111111
*/

/* 출력
#1 2222/02/28
#2 -1
#3 0101/01/01
#4 -1
#5 1111/11/11
*/
