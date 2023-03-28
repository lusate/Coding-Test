import java.util.*;
class Solution {
    public int count(int mid, int k, int[] stones){
        int cnt = 0;
        for(int i=0; i<stones.length; i++){
            if(stones[i] < mid){
                cnt++;
                if(cnt >= k) break;
            }
            else{
                cnt=0;
            }
        }
        return cnt;
    }
    public int solution(int[] stones, int k) {
        int answer = 0;

        int lt = 0;
        int rt = Integer.MAX_VALUE; // 돌다리 숫자가 매우 최대면 최대로 사람수가 건널 수 있기 때문에 MAX로 설정.
        while(lt<=rt){
            int mid = (lt+rt) / 2;
            if(count(mid, k, stones) < k){
                lt = mid + 1;
                answer = mid;
            }
            else{
                rt = mid - 1;
            }
        }
        return answer;
    }
}
