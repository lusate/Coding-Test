import java.util.*;
class Main{
	private static int getTime(String time){
		int H = Integer.parseInt(time.split(":")[0]);
		int M = Integer.parseInt(time.split(":")[1]);

		return 60 * H + M;
	}
	private static ArrayList<String> solution(String[] reports, int times){
		ArrayList<String> answer = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<>(); //들어와 있는 시간
		HashMap<String, Integer> sum = new HashMap<>(); //총 사용 시간.

		for(String x : reports){
			String a = x.split(" ")[0]; //이름
			String b = x.split(" ")[1]; //시간
			String c = x.split(" ")[2]; //in, out.


			//in이면. map에 삽입.
			if(c.equals("in")){
				map.put(a, getTime(b));
			}
			//out이면 sum에 삽입.
			else sum.put(a, (getTime(b) - map.get(a)) + sum.getOrDefault(a, 0));
			//getTime(b) - map.get(a) 는 직원의 이용시간.
			//sum.getOrDefault(a,0) 은 이전 직원의 이용시간.
			//직원이 이용시간이 2번 이상이 있기 때문에 누적해서 더해줘야 한다.
				
		}
		//System.out.println(map);

		for(String key : sum.keySet()){
			if(sum.get(key) >= times){
				answer.add(key);
			}
		}

		return answer;
	}
	
	public static void main(String[] args){
		System.out.println(solution(new String[]{"john 09:30 in", "daniel 10:05 in", 
		"john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", 
		"daniel 15:05 out"}, 60));



		System.out.println(solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", 
		"luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", 
		"daniel 14:55 out"}, 120));
	}
}



/* 출력
[daniel, john]

[daniel, luis]
*/
