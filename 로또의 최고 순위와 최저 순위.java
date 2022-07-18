class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        //알아볼 수 없는 0의 개수가 몇 개인지를 구한다.
        int zero = 0;
        //몇 개가 당첨 번호와 맞았는지 카운트
        int match = 0;
        
        for(int i=0; i<lottos.length; i++){
            //구매한 로또 번호가 0이라면
            if(lottos[i] == 0){
                zero++;
            }//번호에 0이 몇 개인지 카운트
            
            //0일 경우 제외하고 당첨 번호와 구매한 번호가 같다면
            else{
                for(int j=0; j<win_nums.length; j++){
                    if(win_nums[j] == lottos[i]){
                        match++;
                    }
                }
            }
        }
        
        //0이 다 당첨 번호와 일치하고(zero) + 번호가 당첨 번호와 일치할 경우(match)
        int max = zero + match;
        //0이 없음 + 번호가 당첨 번호와 일치할 경우(match)
        int min = match;
        
        //등수가 총 7개로 1,2,3,4,5,6(1개 일치),6(0개 일치) 이 있음
        //그래서 7에 빼줌, 6인 이유는 등수가 6위까지 있어서
        answer[0] = Math.min(7 - max, 6);
        answer[1] = Math.min(7 - min, 6);
        
        return answer;
    }
    
    public static void main(String[] args){
		Main T = new Main();
		int[] lotto = new int[]{44, 1, 0, 0, 31, 25};
		int[] win = new int[]{31, 10, 45, 1, 6, 19};
		for(int x : T.solution(lotto, win)){
			System.out.print(x+" ");
		}
	}
}
