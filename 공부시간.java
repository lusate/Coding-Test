import java.util.*;

class Main{	
	//분으로 환산
	public int getTime(String time){
		String[] tmp = time.split(":");
		int hour = Integer.parseInt((tmp[0]));
		int minute = Integer.parseInt((tmp[1]));

		return hour * 60 + minute;
	}
	public String solution(String[] times){
		ArrayList<Integer> tmp = new ArrayList<>();
		//for(int i=0; i<times.length; i++){
			//tmp.add(getTime(times[i]));
		//}
		
		for(String x : times){
			tmp.add(getTime(x));
		}
		
		int sum=0;
		for(int i=0; i<tmp.size(); i+=2){
			int time = tmp.get(i+1) - tmp.get(i);

			//5분 미만이면 0분 공부했다고 함
			if(time < 5){
				sum += 0;
			}
			//105분 이상이면 105분 공부한 걸로 함
			else if(time>=105){
				sum+=105;
			}
			//둘 다 아니면 시간을 더해준다.
			else
				sum+=time;
		}

		int H = sum / 60;
		int M = sum % 60;

		//02:20 이런 식으로 출력해야 하므로 한 자리수면 "0" + H / 두 자리수면 H
		return (H<10?"0"+H : H)+":"+(M<10?"0"+M:M);
	}
	public static void main (String[] args){
		Main T = new Main();
		String[] tmp1 = new String[]{"08:30", "09:00", "14:00", "16:00", "16:01", "16:06", "16:07", "16:11"};
		System.out.println(T.solution(tmp1));
	}
}
