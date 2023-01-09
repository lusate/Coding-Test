import java.util.*;
class Main{
	private static int solution(int n, int[][] meetings){
		int answer=0;
		int[] res = new int[n];
		
		//a는 끝나는 시간, b는 방 번호
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
		TreeSet<Integer> rooms = new TreeSet<>();
		for(int i=0; i<n; i++){
			rooms.add(i);
		}
		Arrays.sort(meetings, (a,b)->a[0]-b[0]); //시작을 기준으로 오름차순
		//System.out.println(Arrays.toString(meetings));
		
		for(int x[] : meetings){
			while(!pq.isEmpty() && pq.peek()[0] <= x[0]){
				rooms.add(pq.poll()[1]);
			}

			if(!rooms.isEmpty()){ //빈 방이 있음
				int roomNum = rooms.pollFirst(); //rooms에서 첫 번째 0부터.
				res[roomNum]++; //방 번호 카운트
				pq.add(new int[]{x[1], roomNum}); //x의 끝나는 시간, room 번호
			}
			else { //빈 방이 없으면 가장 빨리 끝나는 회의를 가져옴.
				int[] tmp = pq.poll(); // [5, 0]이 빠짐.
				// tmp[0]은 끝나는 시간, tmp[1]은 방 번호.
				res[tmp[1]]++; //방 번호 카운트
				pq.add(new int[]{tmp[0] + (x[1] - x[0]), tmp[1]});
			}

		}

		int max = 0;
		for(int i=0; i<n; i++){
			if(res[i] > max){
				max = res[i];
				answer = i;
			}
		}

		
		return answer;
	}
	
	public static void main(String[] args){
		System.out.println(solution(2, new int[][]{{0,5}, {2,7}, {4,5}, {7,10}, {9,12}}));
		System.out.println(solution(3, new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
		System.out.println(solution(4, new int[][]{{3,20}, {1,25}, {5,8}, {10,15}, {9,14}, {12,14}, {15,20}}));
	}
}


/* 출력
0
0
2
*/
