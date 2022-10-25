import java.util.*;
import java.io.*;

class Solution{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case=1; test_case<=T; test_case++){
			//통나무 길이
			int N = sc.nextInt();

			if(N % 2 == 0){
				System.out.println("#" + test_case + " " + "Alice");
			}
			else{
				System.out.println("#" + test_case + " " + "Bob");
			}
		}
		
	}
}


/* 입력
5
2
3
10
50
100
*/

/* 출력
#1 Alice
#2 Bob
#3 Alice
#4 Alice
#5 Alice
*/
