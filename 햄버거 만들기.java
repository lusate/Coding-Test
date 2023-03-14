import java.util.*;
class Solution {
	public int solution(int[] ingredient) {
        int answer = 0;
        ArrayList<Integer> res = new ArrayList<>();

		for(int i=0; i<ingredient.length; i++){
			res.add(ingredient[i]);

			if(res.size() > 3 && res.get(res.size() - 4) == 1 && 
				res.get(res.size() - 3) == 2 && res.get(res.size() - 2) == 3 && 
				res.get(res.size() - 1) == 1){

				answer++;

				for(int j=0; j<4; j++){
					res.remove(res.size() - 1);
				}
			}
		}

		return answer;
    }

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}));
		System.out.println(T.solution(new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2}));
	}
}


/* 출력
2
0
*/
