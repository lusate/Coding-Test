import java.util.*;
class Fail{
    int stage;
    double rate;
    Fail(int stage, double rate){
        this.stage=stage;
        this.rate=rate;
    }
}
class Solution {
    public int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
        List<Fail> fails = new ArrayList<>();
        
        int total = stages.length;
        int[] users = new int[N+1];
        for(int x : stages){
            users[x-1]++;
        }
        
        for(int i=0; i<N; i++){
            // System.out.println(users[i]);  1, 3, 2, 1, 0
            if(users[i] == 0){
                fails.add(new Fail(i+1, 0));
            }
            else{
                fails.add(new Fail(i+1, (double)users[i] / total));
                total = total - users[i];
            }
        }
        
        Collections.sort(fails, ((o1, o2) -> Double.compare(o2.rate, o1.rate)));
        
        for(int i=0; i<fails.size(); i++){
            answer[i] = fails.get(i).stage;
        }
        return answer;
    }

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
		System.out.println(Arrays.toString(T.solution(4, new int[]{4,4,4,4,4})));
	}
}
