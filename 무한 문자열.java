import java.util.*;
class Solution{
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++){
			String s1 = sc.next();
			String s2 = sc.next();
			String S = s1;
			String V = s2;
			
			if(s1.length() != s2.length()){
				int len = lmc(s1.length(), s2.length());
				//ababab , abab 의 경우 최소 공배수가 6이기 때문에
				//이 12의 길이를 맞춰주기 위해  V에 s2를 더함.
				while(S.length() != len){ 
					S += s1;
				}
				while(V.length() != len){
					V += s2;
				}
			}
			if(S.equals(V)){
				System.out.println("#" + test_case + " yes");
			}
			else System.out.println("#" + test_case + " no");
		}
		
	}
	//각각 최대공약수, 최소공배수 암기.
	//최대 공약수
	public static int gcd(int a, int b){
		while(b>0){
			int tmp = a;
			a = b;
			b = tmp % b;
		}
		return a;
	}
	//최소 공배수 (a*b) / a와 b의 최대 공약수
	public static int lmc(int a, int b){
		return(a * b) / gcd(a, b);
	}
}


/* 입력
3
ababab abab
aba bab
hello hello
*/

/* 출력
#1 yes
#2 no
#3 yes
*/
