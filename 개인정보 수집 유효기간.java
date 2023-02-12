import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
		//연, 월, 일을 모두 일(int) 로 바꿈
        int year = Integer.parseInt(today.substring(0, 4));
        int month = Integer.parseInt(today.substring(5, 7));
        int day = Integer.parseInt(today.substring(8, 10));
        
        int cnt = (year * 12 * 28) + (month * 28) + day; //day로 바꿈.
        
        int[] arr = new int[privacies.length];
        
        for(int i=0; i<privacies.length; i++){
            String[] p = privacies[i].split(" ");
            int num = 0; //약관 달
            
            for(int j=0; j<terms.length; j++){
                String[] t = terms[j].split(" ");
                if(p[1].equals(t[0])){
                    num = Integer.parseInt(t[1]);
                    break;
                }
            }
            
            //p[]를 연, 월, 일 별로 pDate에 저장
            String[] pDate = p[0].split("\\.");
            //정규식에서 .은 무작위 글자 하나만을 의미한다. 그래서 만약 "가.나.다.가나다"; 일 경우 "." 만 split하면 작동하지 않는다.
		//따라서 이스케이프 문자(\\) 를 앞에 붙여줘야 한다.
		
		
            int pyear = Integer.parseInt(pDate[0]);
            int pmonth = Integer.parseInt(pDate[1]);
            int pday = Integer.parseInt(pDate[2]);
            
            pmonth += num;
            
            int tCnt = (pyear * 12 * 28) + (pmonth * 28) + pday-1;
            
            if(cnt > tCnt){ //파기된 것 번호 arr에 저장.
                arr[i] = i+1;
            }
            // System.out.println(arr[i]);
			// [1, 0, 3, 0]
        }
        
		//이제 1,3만 answer에 저장.
        int a = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] > 0){
                a++;
            }
        }
        
        int[] answer = new int[a];
        int idx = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] > 0){
                answer[idx] = arr[i];
                idx++;
            }
        }
        
        return answer;
    }

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution("2022.05.19", 
		new String[]{"A 6", "B 12", "C 3"}, 
		new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"})));


		System.out.println(Arrays.toString(T.solution("2020.01.01", 
		new String[]{"Z 3", "D 5"}, 
		new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"})));
	}
}


/* 출력
[1, 3]
[1, 4, 5]
*/
