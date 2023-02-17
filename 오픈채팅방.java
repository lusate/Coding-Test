import java.util.*;
class Solution{
	public String[] solution(String[] record) {
		HashMap<String, String> map = new HashMap<>();
        int cnt = 0;// Change일 때 카운트
        for(int i=0; i<record.length; i++){
            String[] res = record[i].split(" ");

            if(res[0].equals("Enter")){
                map.put(res[1], res[2]);
            }
            else if(res[0].equals("Leave")){
                continue;
            }
            else{
                map.put(res[1], res[2]);
                cnt++;
            }
        }
        
        String[] answer = new String[record.length - cnt];
        int idx = 0;
        for(int i=0; i<record.length; i++){
			String[] res = record[i].split(" ");
			String name = map.get(res[1]);
            
            if(res[0].equals("Enter")){
                answer[idx++] = name + "님이 들어왔습니다.";
            }
            else if(res[0].equals("Leave")){
                answer[idx++] = name + "님이 들어왔습니다.";
            }
        }
        
        return answer;
	}

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(new String[]{"Enter uid1234 Muzi", 
		"Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"})));
	}
}


/* 출력
"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", 
"Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."
*/
