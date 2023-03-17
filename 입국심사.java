import java.util.*;
class Solution {
	// mid 지났을 때 몇 명 심사했는지 카운트
	public long count(int[] times, long mid){
        long time = 0;
        for(int x : times){ // mid / x를 하면 mid 시간일 때 사람이 몇명 심사했는지 나옴.
            time = time + (mid / x);
        }
        return time;
    }

    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        
		//여기서 lt, rt는 걸린 시간
        long lt = 1; //최소 1분은 지남.
        long rt = (long)times[times.length-1] * n; //최대 시간 / 여기선 60시간.
        
        while(lt <= rt){
            long mid = (lt + rt) / 2; // 시간 (분)
            
            if(count(times, mid) >= n){ //n명 보다 크면 크기 줄여줘야 함.
                answer = mid;
                rt = mid - 1;
            }
            else lt = mid + 1;
        }
        
        
        return answer;
    }

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(6, new int[]{7, 10}));
	}
}


/* 출력
28
*/
