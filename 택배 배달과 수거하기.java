import java.util.*;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int d = 0; //배달 택배 수
        int p = 0; //수거 택배 수

        for(int i=n-1; i>=0; i--){
            //제일 멀리 있는 배달 혹은 수거가 남아있다면 무조건 그 거리를 다시 방문해야 하므로
            //deliveries 배열과 pickups 배열을 동시에 확인한다.
            if(deliveries[i] != 0 || pickups[i] != 0){
                int cnt = 0; //해당 장소를 방문한 횟수.

                while(d < deliveries[i] || p < pickups[i]){ //아직 배달이나 수거를 하지 않은 것.
                    d += cap;
                    p += cap; // 수거할 때 cap보다 적으면 수거를 하기 위함.
                    cnt++;
                }

                d -= deliveries[i];
                p -= pickups[i];
                answer += (i+1) * 2 * cnt;
                //한 지점에 와야할 횟수를 한 번에 계산하면서 동시에 미리 배달/수거할 박스를 더해놓고 초과한 만큼만 뺀다.
            }
        }
        /** 예시 해설
         * i = 4일 때 2개 배달을 한다. 배달을 하면 answer는 5가 되고 다시 물류 창고로 돌아와야 하므로 10이 된다.
         * 그러면 d = 2, p = 4가 된다.
         * i = 3일 때 4개를 수거하는데 i=4일 때 물류창고로 돌아오면서 이미 수거를 했다고 하면 p = 0이 된다.
         * 그러면 d = 2, p = 0
         * i = 2일 때 3개를 배달해야 한다. cap이 4로 3번 집으로 가면서 4개를 배달할 수 있으므로 1번에 배달을 하고 3번 집에 배달을 하면 된다.
         * d = 6, p = 4 -> d = 3, p = 4
         *
         */

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
//        System.out.println(T.solution(4, 5, new int[]{1, 0, 3, 1, 2}, new int[]{0, 3, 0, 4, 0}));
        System.out.println(T.solution(2, 7, new int[]{1, 0, 2, 0, 1, 0, 2}, new int[]{0, 2, 0, 1, 0, 2, 0}));
    }
}

/* 출력
16
30
*/
