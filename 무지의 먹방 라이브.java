import java.util.*;
class Solution {
    public int solution(int[] food_times, long k) {
		int[] copy = new int[food_times.length + 1];
        System.arraycopy(food_times, 0, copy, 1, food_times.length);
		Arrays.sort(copy);

		int rest = food_times.length;
		for(int i=1; i<copy.length; i++){
			//k가 long 이므로 rest * (copy[i] - copy[i-1]) 도 long으로 해서 비교
			if(k < (long)rest * (copy[i] - copy[i-1])){
				long idx = k % rest;
				int cnt = 0;
				for(int j=0; j<food_times.length; j++){
					if(food_times[j] >= copy[i]){
						if(cnt == idx) return j+1;
						cnt++;
					}
				}
			}

			else{
				k -= rest * (copy[i] - copy[i-1]);
				rest--;
			}
		}
      
		return -1;
    }

	public static void main(String args[]){
		Solution T = new Solution();
		System.out.println(T.solution(new int[]{3,1,2}, 5));
	}
}


/* 출력
1
*/
