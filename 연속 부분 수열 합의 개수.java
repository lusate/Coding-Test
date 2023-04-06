import java.util.*;
class Solution{
    public int solution(int[] elements) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();

        int n = elements.length;

        ArrayList<Integer> arr = new ArrayList<>();
        for(int x : elements){
            arr.add(x);
        }

        int time = 0;
        while(time < n){
            int sum = 0;

            for(int i=0; i<n; i++){
                sum += arr.get(i);
                // System.out.println(sum);
                set.add(sum);
            }

            int tmp = arr.remove(0);
            arr.add(tmp);
            // 다시 배열에 삽입

            time++;
        }
        answer = set.size();
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{7, 9, 1, 1, 4}));
    }
}
