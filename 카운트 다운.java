import java.util.*;
class Solution {
    public int[] solution(int target) {
		int[][] memo = new int[target+1][2]; //[22][2]

		Set<Integer> set = new HashSet<>();
		set.add(50);
		
		for(int i=1; i<=20; i++){
			set.add(i); // set에 20까지의 모든 수 삽입.
			set.add(i*2); // set에 2의 배수 삽입.
			set.add(i*3); // set에 3의 배수 삽입.
		}
		// 한 번만 던져서 만들 수 있는 target들을 set에 저장한 것
		// 불 사용 / 더블 / 트리플 / 그냥 수로 만들 수 있는 값들을 set에 모두 삽입.
		System.out.println(set);

		// 트리플을 해서 최대 3 * 20까지 할 수 있으므로 60이하로 제한.
		// i는 target
		for(int i=1; i<=target && i<=60; i++){
			if(set.contains(i)){
				memo[i][0] = 1; //싱글이나 더블, 트리플을 한번만 맞춰서 만들 수 있는 것이므로 1.
				if(i == 50 || i <= 20){
					memo[i][1] = 1; // 불 사용 한 번이거나 20이하의 싱글 한 번 사용.
				}
			}

			else{
				if(i>50 || i<=40){ //35라면 다트 횟수 2번 싱글 2번 (이유는 문제에서 싱글 또는 불을 최대한 많이 던져야 하기 때문에.)
					memo[i][0] = 2;
					memo[i][1] = 2; // 55라면 다트 횟수 2번으로 불 1번, 싱글 한번.
				}
				else{
					memo[i][0] = 2;
					memo[i][1] = 1;
				}
			}
		}

		if(target > 60){
			for(int i=61; i<=target; i++){
				if(memo[i-50][0] <= memo[i-60][0]){ //60보다 크면 불 하나 더 사용하기 때문에 1씩 더해줌.
					memo[i][0] = memo[i-50][0] + 1;
					memo[i][1] = memo[i-50][1] + 1;
				}

				else{ // 90같은 경우 20을 트리플 맞추고 10을 트리플 맞춰야 함.
					memo[i][0] = memo[i-60][0] + 1;
					memo[i][1] = memo[i-60][1];
				}
			}
		}
		return memo[target];
    }

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(21)));
		// System.out.println(Arrays.toString(T.solution(58)));
		// System.out.println(Arrays.toString(T.solution(100)));
	}
}


/* 출력
[1, 0]
[2, 2]
[2, 2]
*/
