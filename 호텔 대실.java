import java.util.*;
class Solution {
    public int getTime(String s){
        int H = Integer.parseInt(s.split(":")[0]);
        int M = Integer.parseInt(s.split(":")[1]);
        
        return H*60 + M;
    }

    public int solution(String[][] book_time) {
        int answer = 0;
        int[][] time = new int[book_time.length][2];
        
        for(int i=0; i<book_time.length;i++){
            time[i][0] = getTime(book_time[i][0]);
            time[i][1] = getTime(book_time[i][1])+10;
        }
        Arrays.sort(time, (a, b)->a[0]-b[0]);
        
		
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        for(int[] x : time){
            while (!pq.isEmpty() && pq.peek()[1]<=x[0]){
                pq.poll();
            }
            pq.add(x);
            answer = Math.max(answer, pq.size());

        }
        return answer;
    }

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new String[][]{{"15:00", "17:00"}, {"16:40", "18:20"}, 
		{"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}}));

		System.out.println(T.solution(new String[][]{{"09:10", "10:10"}, {"10:20", "12:20"}}));

		System.out.println(T.solution(new String[][]{{"10:20", "12:30"}, {"10:20", "12:30"}, 
		{"10:20", "12:30"}}));
	}
}


/* 출력
3
1
3
*/
