import java.util.*;
class Solution {
	//현재까지 조합된 상태, 아직 사용하지 않은 알파벳, 몇개를 더 조합해야 하는지 카운트.
	public void dfs(String order, String other, int cnt){
		
	}
	public String[] solution(String[] orders, int[] course) {
        
    }

	public static void main(String args[]){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2,3,4})));
		System.out.println(Arrays.toString(T.solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2,3,5})));
		System.out.println(Arrays.toString(T.solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2,3,4})));
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
