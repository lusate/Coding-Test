import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
		String answer = "";
        char[] list = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};

        HashMap<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < list.length; i++) {
			map.put(list[i], 0);		
		}

        for(int i=0; i<choices.length; i++){
            char key = ' ';
            if(choices[i] == 4) continue;
            if(choices[i] < 4) key = survey[i].charAt(0);
            if(choices[i] > 4) key = survey[i].charAt(1);
            
            int value = 0;
            if (choices[i] == 7 || choices[i] == 1) {
				value += 3;
			} else if (choices[i] == 6 || choices[i] == 2) {
				value += 2;
			} else {
				value += 1;
			}

            map.put(key, map.getOrDefault(key, 0) + value);
        }
        
        System.out.println(map);
        
        
        StringBuilder sb =new StringBuilder();
		//RT, CF, JM, AN
		int R = map.get('R');
		int T = map.get('T');
		if(T>R) {
			sb.append("T");
		}else{
			sb.append("R");
		}

		int C = map.get('C');
		int F = map.get('F');
		if(F>C) {
			sb.append("F");
		}else {
			sb.append("C");
		}

		int J = map.get('J');
		int M = map.get('M');
		if(M>J) {
			sb.append("M");
		}else {
			sb.append("J");
		}

		int A = map.get('A');
		int N = map.get('N');
		if(N>A) {
			sb.append("N");
		}else {
			sb.append("A");
		}

        answer = sb.toString();
        return answer;
    }

	public static void main(String args[]){
		Solution T = new Solution();
		System.out.println(T.solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, 
		new int[]{5, 3, 2, 7, 5}));

		System.out.println(T.solution(new String[]{"TR", "RT", "TR"}, 
		new int[]{7, 1, 3}));
	}
}


/* 출력
"TCMA"
"RCJA"
*/
