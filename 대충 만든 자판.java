import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character,Integer> map = new HashMap<>();

		//버튼 눌렀을 때 알파벳 별로 몇 번 눌러야 하는지 map에 저장.
        for(int i=0; i<keymap.length; i++){
            for (int j = 0; j < key.length(); j++) {
                char ch = keymap[i].charAt(j);

                if (map.containsKey(ch)){
					// j는 각 문자열의 인덱스이다.
                    if(map.get(ch)>j){ //만약 저장되어 있는 값이 j보다 크면 횟수를 최소로 바꿔준다.
                        map.put(ch,j+1);
                    }
                }
				else{
					// map에 없으면 버튼 누른 횟수를 저장. 누른 횟수는 (인덱스 + 1)
                    map.put(ch,j+1);
                }
            }
        }
		// System.out.println(map);
		// {A=1, B=1, C=2, D=5, E=3, F=4}

        for(int i=0; i<targets.length; i++){
            int sum = 0;
            for(int j=0; j<targets[i].length();j++){
                char ch = targets[i].charAt(j);

				//이제 target에서 같은 알파벳이 있으면 sum 구해줌.
                if(map.containsKey(ch)){
			sum += map.get(ch);
		}
		else {
			sum = -1;
			break;
		}
            }
            answer[i] = sum;
        }

        return answer;
    }

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD","AABB"})));
		System.out.println(Arrays.toString(T.solution(new String[]{"AA"}, new String[]{"B"})));
		System.out.println(Arrays.toString(T.solution(new String[]{"AGZ", "BSSS"}, new String[]{"ASA","BGZ"})));
	}
}


/* 출력
[9, 4]
[-1]
[4, 6]
*/
