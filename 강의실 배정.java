import java.util.*;
class Main {
	public static void main(String[] args)  {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [][] arr = new int [n][2];
		
		for(int i = 0; i < n ; i++) {
			for(int j = 0; j < 2; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		//2차월 배열 정렬 0번쨰 열 다음 1번째 열 기준(다중 배열 정렬)
		//Arrays.sort(arr, (a,b) -> a[1]==b[1] ? a[0]-b[0] : a[1] - b[1]);

		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o1[1] - o2[1]; //끝점을 기준으로 오름차순
				}else {
					return o1[0] - o2[0]; 
				}
			}
		});
		
		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		
		for(int i = 0; i < n; i++) {
			int end = arr[i][1];
			
			if(!pQ.isEmpty() && pQ.peek() <= arr[i][0]){
				pQ.poll();
			}

			pQ.offer(end);
		}
		System.out.println(pQ.size());
	}
}


/* 입력
3
1 3
2 4
3 5
*/

/* 출력
2
*/
