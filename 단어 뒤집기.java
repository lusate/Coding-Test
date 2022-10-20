import java.util.*;
public class Main{
	public ArrayList<String> solution(int n, String[] str){
		ArrayList<String> answer = new ArrayList<>();
		for(String x : str){
			//x라는 단어가 뒤집어 지고 다시 String으로 만들어야 한다.
			String tmp = new StringBuilder(x).reverse().toString();
			
			answer.add(tmp);
		}
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] str = new String[n];

		for(int i=0; i<n; i++){
			str[i] = sc.next();
		}

		for(String x : T.solution(n, str)){
			System.out.println(x);
		}
	}
}


--------------------------------------------------------------------------------------

import java.util.*;
public class Main{
	public ArrayList<String> solution(int n, String[] str){
		ArrayList<String> answer = new ArrayList<>();
		
		for(String x : str){
			char[] s = x.toCharArray();
			int left = 0;
			int right = x.length()-1;

			while(left < right){
				char tmp = s[left];
				s[left] = s[right];
				s[right] = tmp;
				left++;
				right--;
			}

			String tmp = String.valueOf(s);
			answer.add(tmp);
		}
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] str = new String[n];

		for(int i=0; i<n; i++){
			str[i] = sc.next();
		}

		for(String x : T.solution(n, str)){
			System.out.println(x);
		}
	}
}


//입력
2
good
doig

//출력
//doog
//giod
