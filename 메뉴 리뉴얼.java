import java.util.*;
class Solution {
    List<String> res = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();

	//현재까지 조합된 상태, 아직 사용하지 않은 알파벳, 몇개를 더 조합해야 하는지 카운트.
	public void dfs(String order, String other, int cnt){
		if(cnt == 0){ //더 이상 붙일 게 없을 때
            //조합된 order를 map에 저장.
            map.put(order, map.getOrDefault(order, 0) + 1);
            return;
        }


        for(int i=0; i<other.length(); i++){
            dfs(order + other.charAt(i), other.substring(i+1), cnt-1);
        }
	}
	public String[] solution(String[] orders, int[] course) {
        
        for(int i=0; i<orders.length; i++){ //정렬해서 다시 넣어줌.
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }
        

        //order를 기준으로 courseLength만큼의 조합 만듦.
        for(int courseLength : course){
            for(String order : orders){
                //order라는 String을 기반으로 courseLength 개수 만큼의 조합을 만들어 주는 재귀함수.
                dfs("", order, courseLength);
            }

            
            //가장 많은 조합을 answer에 저장.
            if(!map.isEmpty()){ //조합이 하나라도 잘 만들어졌다면
                //list는 courseLength가 2,3,5일 때 map의 value들을 저장.
                List<Integer> list = new ArrayList<>(map.values());
                int max = Collections.max(list); //2, 3, 5일 때 각각 value들의 최댓값.

                if(max > 1){
                    for(String key : map.keySet()){
                        if(map.get(key) == max){
                            res.add(key);
                        }
                    }
                }
                map.clear();
            }
        }
        // map
        // {AB=2, BC=1, CD=3, DE=2, XY=2, YZ=2, AC=2, BD=1, CE=1, XZ=2, AD=3, BE=1, AE=2}
        // {ABC=1, ACD=2, ADE=2, BCD=1, BDE=1, ABD=1, ACE=1, ABE=1, BCE=1, CDE=1, XYZ=2}
        // {ABCDE=1}
        

        Collections.sort(res);
        String[] answer = new String[res.size()];

        for(int i=0; i<res.size(); i++) answer[i] = res.get(i);
        return answer;
    }

	public static void main(String args[]){
		Solution T = new Solution();
		// System.out.println(Arrays.toString(T.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2,3,4})));
		System.out.println(Arrays.toString(T.solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2,3,5})));
		// System.out.println(Arrays.toString(T.solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2,3,4})));
	}
}

----------------------------------------------------------------------------------------------------------------
import java.util.*;
class Solution {
    List<Map<String, Integer>> map = new ArrayList<>();
    //메뉴 별로 최대 주문 횟수
    int[] maxCnt = new int[11];
    public void dfs(char[] arr, int pos, StringBuilder sb){
        if(pos >= arr.length){
            int len = sb.length(); //len은 orders의 문자열들의 길이.
            
            if(len >= 2){
                //요리 2개 이상이면 map에 저장.
                map.get(len).put(sb.toString(), map.get(len).getOrDefault(sb.toString(), 0) + 1);
                maxCnt[len] = Math.max(maxCnt[len], map.get(len).get(sb.toString()));

                // int cnt = map.get(len).getOrDefault(sb.toString(), 0) + 1;
                // map.get(len).put(sb.toString(), cnt);
                // maxCnt[len] = Math.max(maxCnt[len], cnt);
            }
            return;
        }

        dfs(arr, pos+1, sb.append(arr[pos]));
        sb.setLength(sb.length() - 1);
        dfs(arr, pos+1, sb);
    }
	public String[] solution(String[] orders, int[] course) {
        //orders의 각 원소는 2이상 10 이하.
        for(int i=0; i<11; i++){
            map.add(new HashMap<>());
        }

        //모든 메뉴에 대한 조합
        for(String x : orders){
            //알파벳 순서대로 고정
            char[] arr = x.toCharArray();
            Arrays.sort(arr);
            dfs(arr, 0, new StringBuilder());
        }

        // System.out.println(map);
        /* map에는 모든 조합들을 카운팅한 값들이 저장.
        [{}, {}, {AB=2, BC=1, CD=3, DE=2, XY=2, YZ=2, AC=2, BD=1, CE=1, XZ=2, AD=3, BE=1, AE=2}, 
        {ABC=1, ACD=2, ADE=2, BCD=1, BDE=1, ABD=1, ACE=1, ABE=1, BCE=1, CDE=1, XYZ=2}, 
        {ABCD=1, ABDE=1, ABCE=1, ACDE=1, BCDE=1}, 
        {ABCDE=1}, {}, {}, {}, {}, {}]
        */

        List<String> res = new ArrayList<>();
        //course
        for(int len : course){
            // entry 모두 출력하는 for문
            for(Map.Entry<String, Integer> entry : map.get(len).entrySet()){
                // entry에는 course 대로 요리 개수가 2,3,5일 때 가능한 요리 조합과 개수들이 저장되어 있음.
                // System.out.println(entry);   
                
                if(entry.getValue() >= 2 && entry.getValue() == maxCnt[len]){
                    res.add(entry.getKey());
                }
            }
        }

        Collections.sort(res);
        
        String[] answer = new String[res.size()];
        for(int i=0; i<res.size(); i++) answer[i] = res.get(i);
        return answer;
    }

	public static void main(String args[]){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2,3,4})));
		System.out.println(Arrays.toString(T.solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2,3,5})));
		System.out.println(Arrays.toString(T.solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2,3,4})));
	}
}



/* 출력
["AC", "ACDE", "BCFG", "CDE"]
["ACD", "AD", "ADE", "CD", "XYZ"]
["WX", "XY"]
*/
