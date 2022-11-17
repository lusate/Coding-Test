import java.util.*;
class Solution{
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String s = "abcdefghijklmnopqrstuvwxyz";
		
		for(int test_case = 1; test_case <= T; test_case++){
			int answer = 0;
			Queue<Character> Q = new LinkedList<>();
			for(int i=0; i<26; i++){
				Q.offer(s.charAt(i)); //a~z Q에 삽입
			}

			String str = sc.next(); //내가 입력
			for(int i=0; i<str.length(); i++){
				char tmp = Q.poll();
				if(tmp == str.charAt(i)){
					answer++;
					//System.out.println(Q);
				}
				else{
					break;
				}
			}
			System.out.println("#" + test_case + " " + answer);
		}
	}
}


/* 입력
5
abcdefghijklmnopqrstu
abcdefghijklmnopqrstuvwzyx
abcefghijk
xyz
absolute
*/

/* 출력

#1 21
#2 23
#3 3
#4 0
#5 2
*/
