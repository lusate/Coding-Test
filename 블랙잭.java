//백준



//프로그래머스
import java.util.*;
public class Main {
	public int solution(int[] choice, int n, int m) {
        int answer=0; //3장의 카드를 더한 변수
		int sum=0; //이전 sum의 값을 저장하기 위한 변수
		

		for(int i=0; i<n-2; i++){
			for(int j=i+1; j<n-1; j++){
				for(int k=j+1; k<n; k++){
					sum = choice[i] + choice[j] + choice[k];
					if(sum == m){
						return sum;
					}
					else if(sum < m && answer < sum){
						//m보다 작고 이전 sum 값보다 작아야함.
						answer = sum;
					}
				}
			}
		}
        return answer;
    }
	public static void main(String[] args){
		Main T = new Main();
		int[] choice1 = new int[]{5,6,7,8,9};
		int[] choice2 = new int[]{93, 181, 245, 214, 315, 36, 185, 138, 216, 295};
		System.out.println(T.solution(choice1, 5, 21));
		System.out.println(T.solution(choice2, 10, 500));
	}
}
