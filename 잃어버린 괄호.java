import java.io.*;
import java.util.*;
public class Main {
	public int solution(String[] sub) {
		int answer=Integer.MAX_VALUE;
		// for(int i=0; i<sub.length; i++){
		// 	System.out.println(sub[i] + "#");
		// }
		//문자를 분리 -> 55 와 50+40 으로 분리.
		
	
		for(int i=0; i<sub.length; i++){
			int temp=0; //+ 계산하는 변수
			String[] add = sub[i].split("\\+");

			for(int j=0; j<add.length; j++){
				temp = temp + Integer.parseInt(add[j]);
			}

			if(answer == Integer.MAX_VALUE){
				answer = temp;
			}
			else{
				answer -= temp;
			}
		}

		return answer;
    }
	public static void main(String[] args) throws IOException{
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		//String[] 으로 입력. 배열이 아닌 String으로 하면 제대로 분리 안됨.
		String[] sub = sc.nextLine().split("-");

		System.out.println(T.solution(sub));
	}
}
