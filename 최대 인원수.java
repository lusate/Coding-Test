import java.util.*;
class Main{
	private static int solution(int n, int[][] trans, int[][] bookings){
		int answer=0;

		//도착역에 도착했을 때 수용할 수 인원이 몇 명인지 저장
		int[] arr = new int[n+1]; //n번 역까진 운행함.
		for(int[] x : trans){
			arr[x[0]] += x[2];
			arr[x[1]] -= x[2];
		}
		//[0, 2, 1, 0, -2, -1]
		
		for(int i=1; i<=n; i++){
			arr[i] += arr[i-1];
		}
		//[0, 2, 3, 3, 1, 0]

		Arrays.sort(bookings, (a,b) -> a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);
		LinkedList<Integer> nums = new LinkedList<>();
		int idx = 0;
		for(int i=1; i<=n; i++){
			while(!nums.isEmpty() && nums.peek() == i){
				//도착했으면 nums에서 맨 앞에 있는 값을 빼줌.
				answer++;
				nums.pollFirst();
			}

			//idx 범위 지정을 해주어야 함.
			//1번 역 승차 인원부터 nums에 넣어줌.
			while(idx < bookings.length && bookings[idx][0] == i){
				nums.add(bookings[idx][1]);
				idx++;
			}

			Collections.sort(nums);

			while(nums.size() > arr[i]){
				nums.pollLast();
			}
		}
		

		return answer;
	}
	
	public static void main(String[] args){
		System.out.println(solution(5, new int[][]{{1, 4, 2}, {2, 5, 1}}, 
		new int[][]{{1, 2}, {1, 5}, {2, 3}, {2, 4}, {2, 5}, {2, 5}, {3, 5}, {3, 4}}));
		
		System.out.println(solution(8, new int[][]{{1, 8, 3}, {3, 8, 1}}, 
		new int[][]{{1, 3}, {5, 8}, {2, 7}, {3, 8}, {2, 7}, {2, 8}, {3, 8}, {6, 8}, {7, 8}, {5, 8}, {2, 5}, {2, 7}, {3, 7}, {3, 8}}));
		
		System.out.println(solution(9, new int[][]{{1, 8, 3}, {3, 9, 1}, {1, 5, 3}}, 
		new int[][]{{1, 9}, {5, 8}, {2, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {7, 8}, {5, 8}, {3, 5}, {3, 7}, {4, 7}, {5,8}}));
	}
}


/* 출력
5
7
*/
