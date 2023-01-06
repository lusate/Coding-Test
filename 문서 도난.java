import java.util.*;

//이름과 시간이 쌍이되도록 만들어줘야 한다.
class Info implements Comparable<Info>{
	public String name;
	public int time;
	Info(String name, int time){
		this.name=name;
		this.time=time;
	}
	@Override
	public int compareTo(Info ob){
		return this.time - ob.time; //시간을 기준으로 오름차순.
	}
}
class Main{
	private static int getTime(String time){
		int H = Integer.parseInt(time.split(":")[0]);
		int M = Integer.parseInt(time.split(":")[1]);

		return 60 * H + M;
	}

	private static String[] solution(String[] reports, String times){
		ArrayList<Info> arr = new ArrayList<>();
		
		//report에 " "를 분리
		for(String x : reports){
			String a = x.split(" ")[0]; //john, daniel, tom, park, luis
			String b = x.split(" ")[1]; //시간들

			//arr에 Info로 된 a,b를 삽입.
			arr.add(new Info(a, getTime(b)));
		}
		
		Collections.sort(arr);

		//times에서 시작 시간과 마지막 시간. (" "를 분리해서)
		int start = getTime(times.split(" ")[0]);
		int end = getTime(times.split(" ")[1]);


		//조건 만족하는 이름 List에 저장.
		ArrayList<String> tmp = new ArrayList<>();
		for(Info ob : arr){
			if(ob.time >= start && ob.time <= end){
				tmp.add(ob.name);
			}
			if(ob.time > end) break;
		}

		String[] answer = new String[tmp.size()];
		for(int i=0; i<tmp.size(); i++){
			answer[i] = tmp.get(i);
		}
		return answer;
	}
	
	public static void main(String[] args){
		System.out.println(Arrays.toString(solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23",
		"park 09:59", "luis 08:57"}, "08:33 09:45")));


		System.out.println(Arrays.toString(solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59",
		"luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
	}
}


/* 출력
["luis", "daniel"]

["john", "bill", "bob"]
*/
