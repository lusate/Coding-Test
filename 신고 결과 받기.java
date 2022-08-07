import java.util.*;
class Main{	
	public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, HashSet<String>> map = new HashMap<>();
		//key는 유저아이디, value는 key를 신고한 유저의 아이디의 Set을 가진 Map
		//동일한 유저에 대한 신고횟수는 1회로 처리하기 때문에 중복 없애기 위해 Set을 value로 함

        HashMap<String, Integer> idxMap = new HashMap<>();
		//신고 받은 아이디(key)와 신고받은 횟수(value)
		
		//Map 초기화
        for (int i = 0; i < id_list.length; i++) {
            String name = id_list[i];

            map.put(name, new HashSet<>());
			//System.out.println(map);
			//{muzi=[], neo=[], frodo=[], apeach=[]}

            idxMap.put(name, i);
			//System.out.println(idxMap);
			//{muzi=0, neo=3, frodo=1, apeach=2}
        }
 
		for(String x : report){
			String[] str = x.split(" ");
			String from = str[0]; //신고한 쪽
			String to = str[1]; //신고 받은 쪽
			map.get(to).add(from);
			//신고한 ID에 대해 누가 신고했는지 Map에 저장
			//{muzi=[apeach], neo=[muzi, frodo], frodo=[muzi, apeach], apeach=[]}
			//앞이 신고 받은 쪽, [] 안 ID가 신고 한 쪽
		}

		for (int i = 0; i < id_list.length; i++) {
            HashSet<String> send = map.get(id_list[i]);
			//send는 신고한 쪽의 Set으로 send.size() 는 1,2,0,2
            if (send.size() >= k) {
                for (String name : send) {
                    answer[idxMap.get(name)]++;
                }
            }
        }

        return answer;
	}
	public static void main(String[] args){
		Main T = new Main();
		String[] id_list1 = new String[]{"muzi", "frodo", "apeach", "neo"};
		String[] report1 = new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		System.out.println(T.solution(id_list1, report1, 2));

		String[] id_list2 = new String[]{"con", "ryan"};
		String[] report2 = new String[]{"ryan con", "ryan con", "ryan con", "ryan con"};
		System.out.println(T.solution(id_list2, report2, 3));
	}
}
