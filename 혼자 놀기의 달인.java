import java.util.*;
class Solution {
    public int solution(int[] cards) {
        int n = cards.length;
        int[] ch = new int[n];
        
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            int idx = i;
            int cnt = 0; //각 상자의 그룹에 몇 개의 카드가 들어가는지 카운트.
            while(ch[idx] == 0){
                cnt++;
                ch[idx] = 1;
                idx = cards[idx] - 1; //1번 상자부터이기 때문에 -1
            }
            
            arr.add(cnt);
        }
        
        Collections.sort(arr, Comparator.reverseOrder());
        
        return arr.size() == 1 ? 0 : arr.get(0) * arr.get(1);
    }

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[]{8, 6, 3, 7, 2, 5, 1, 4}));
		
	}
}

/* 출력
12
*/
