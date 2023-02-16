import java.util.*;
class Solution {
    private static int getTime(String time){
		int H = Integer.parseInt(time.split(":")[0]);
		int M = Integer.parseInt(time.split(":")[1]);

		return 60*H+M;
	}
    
    public int[] solution(int[] fees, String[] records) {
		int[] map = new int[10001]; // 입차 시간. IN인 버스들
		int[] sum = new int[10001]; // OUT - IN 시간 계산
		int[] visit = new int[10001]; // IN만 있는 경우를 찾기 위해 버스 번호를 인덱스로 저장.

		for(String x : records){
			String a = x.split(" ")[0];
			String b = x.split(" ")[1];
			String c = x.split(" ")[2];

			int num = Integer.parseInt(b);

			//map에 IN 넣기.
			if(c.equals("IN")){
				map[num] = getTime(a);
				
				visit[num] = 1;
			}
			else{
				sum[num] = getTime(a) - map[num] + sum[num];
				visit[num] = 0;
			}
		}
		

		ArrayList<Integer> res = new ArrayList<>();
		for(int i=0; i<10001; i++){
			// 0000이 1로 OUT하지 않고 남아있음
			if(visit[i] == 1) sum[i] += 23*60+59 - map[i];

			if(sum[i] > 0){
				res.add(sum[i]);
			}
		}


		int[] answer = new int[res.size()];
		for(int i=0; i<res.size(); i++){
            		answer[i] = fees[1];
            		if(res.get(i) > fees[0]){
                		answer[i] += Math.ceil((res.get(i) - fees[0]) / (double)fees[2]) * fees[3];
            		}
        	}

// 		int[] answer = new int[res.size()];
// 		int idx=0;
// 		for(int val : res){
// 			answer[idx] = fees[1]; //기본 요금
// 			if(val > fees[0]){ //추가 요금
// 				answer[idx] += Math.ceil((val - fees[0]) / (double)fees[2]) * fees[3];
// 			}

// 			idx++;
// 		}

        return answer;
    }
	
	public static void main(String[] args){
		System.out.println(Arrays.toString(solution(new int[]{180, 5000, 10, 600}, 
		new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", 
		"07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", 
		"23:00 5961 OUT"})));

		System.out.println(Arrays.toString(solution(new int[]{120, 0, 60, 591}, 
		new String[]{"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"})));

		System.out.println(Arrays.toString(solution(new int[]{1, 461, 1, 10}, 
		new String[]{"00:00 1234 IN"})));
	}
}


----------------------------------------------------------------------------------------------------------------------------------------------------------------
import java.util.*;
class Main{
	private static int getTime(String time){
		int H = Integer.parseInt(time.split(":")[0]);
		int M = Integer.parseInt(time.split(":")[1]);

		return 60*H+M;
	}

	private static int[] solution(int[] fees, String[] records) {
		HashMap<String, Integer> map = new HashMap<>(); //입차 시간. IN인 버스들
		TreeMap<String, Integer> sum = new TreeMap<>(); //사용 시간.
		

		for(String x : records){
			String a = x.split(" ")[0];
			String b = x.split(" ")[1];
			String c = x.split(" ")[2];

			//map에 삽입.
			if(c.equals("IN")){
				map.put(b, getTime(a));
				//최초로 들어온 차량이라면 0으로 초기화.
				//초기화 안하면 sum에 null 에러 발생.
				if(sum.containsKey(b) == false){ 
					sum.put(b, 0);
				}
			}
			
			
			else{
				sum.put(b, (getTime(a) - map.get(b)) + sum.getOrDefault(b, 0));
				map.remove(b);
			}

		}

		//map.remove(b); 해서 현재 OUT 하지 않고 남아있는 타량은 '0000' 이다
		// System.out.println(map);
		//{0000=1139}


		map.forEach((key, val) -> {
			sum.put(key, sum.get(key) + 23 * 60 + 59 - val);
		});

		//System.out.println(sum);
		//{0000=334, 0148=670, 5961=146}

		
		int[] answer = new int[sum.size()];
		int idx = 0;
		for(int val : sum.values()){ // sum.values() - value들을 모두 가져옴.
			answer[idx] = fees[1]; //기본 요금
			if(val > fees[0]){ //추가 요금
				answer[idx] += Math.ceil((val - fees[0]) / (double)fees[2]) * fees[3];
			}

			idx++;
		}
        return answer;
    }
	
	public static void main(String[] args){
		System.out.println(Arrays.toString(solution(new int[]{180, 5000, 10, 600}, 
		new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", 
		"07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", 
		"23:00 5961 OUT"})));

		System.out.println(Arrays.toString(solution(new int[]{120, 0, 60, 591}, 
		new String[]{"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"})));

		System.out.println(Arrays.toString(solution(new int[]{1, 461, 1, 10}, 
		new String[]{"00:00 1234 IN"})));
	}
}



/* 출력
[14600, 34400, 5000]
[0, 591]
[14841]
*/
