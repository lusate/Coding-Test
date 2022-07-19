import java.util.*;
class Main{
	public int solution(int[] people, int limit) {
		int answer = 0;
		int left = 0;
		int right = people.length-1;

		Arrays.sort(people);

		while(left <= right){
			if(people[left] + people[right] <= 100){
				answer++;
				left++;
				right--;
			}
			else{
				answer++;
				right--;
			};
		}

		return answer;
	}
	public static void main(String[] args){
		Main T = new Main();
		int[] people = new int[]{70,50,80,50};
		System.out.println(T.solution(people, 100));
	}
}
