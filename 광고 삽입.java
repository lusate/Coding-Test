import java.util.*;
class Solution {
	public int getTime(String s){
        int H = Integer.parseInt(s.split(":")[0]);
        int M = Integer.parseInt(s.split(":")[1]);
        int S = Integer.parseInt(s.split(":")[2]);
        
        return H*60*60 + M*60 + S;
    }

	public String solution(String play_time, String adv_time, String[] logs) {
		int play = getTime(play_time);
		int adv = getTime(adv_time);

		//전체 시간이 1초 ~ 99시간 59분 59초
        int[] totalSec = new int[100 * 3600];
        
        for(String x : logs){
            int st = getTime(x.substring(0, 8));
            int ed = getTime(x.substring(9, 17));
        
            for(int i=st; i<ed; i++){
                totalSec[i]++;
            }
        }
        //동영상, 공익광고 제한시간이 100시간인데 logs 크기가 30만이면 100 * 3600 * 30만이면
        //int 범위 벗어남. 그래서 long
        long cur = 0;
//         for(int i=0; i<adv; i++){
//             cur += totalSec[i];
//         }
		// 꼭 필요하지는 않음
		
        //adv_time이 한 칸씩 오른쪽으로 이동하면서 최대값을 구함
        long max = cur; //max에 초기값을 넣어주기 위함.
        int maxIdx = 0; //가장 클 때의 처음 인덱스
        for(int i=adv; i<play; i++){
            cur = cur + totalSec[i] - totalSec[i - adv];
            if(max < cur){
                max = cur;
                maxIdx = i - adv + 1;
            }
        }
    
        // System.out.println(maxIdx);
    
        int H = maxIdx / 3600;
        int M = maxIdx / 60 % 60;
        int S = maxIdx % 60;
    
        return (H<10 ? "0" + H : H) + ":" + (M<10 ? "0" + M : M) + ":" + 
            (S<10 ? "0" + S : S);
    }

	public static void main(String args[]){
		Solution T = new Solution();
		System.out.println(T.solution("02:03:55", "00:14:15", new String[]{"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"}));
    	System.out.println(T.solution("99:59:59", "25:00:00", new String[]{"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"}));
    	System.out.println(T.solution("50:00:00", "50:00:00", new String[]{"15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"}));
	}
}



/* 출력
01:30:59
01:00:00
00:00:00
*/
