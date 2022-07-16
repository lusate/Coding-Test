class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        //'*' 를 10으로, '#'를 12로
        int left = 10;
        int right = 12;
        for(int tmp : numbers){
            if(tmp == 1 || tmp == 4 || tmp == 7){ //왼엄지로
                answer += "L";
                left = tmp; //왼엄지로 누르고 현재 위치 기억
            }
            else if(tmp == 3 || tmp == 6 || tmp == 9){ //오른엄지로
                answer += "R";
                right = tmp; //오른엄지로 누르고 그 위치 기억
            }
            else{
                if(tmp == 0) tmp = 11;
                //가운데에 있는 숫자 2,5,8,0 은 좌우 번호와의 차가 1
                //상하 번호와의 차는 3이다 그래서 상하로 차가 3일 때 /3을 해주고 좌우로 차가 1일 때 %3을 해준다.
                int leftdist = Math.abs(tmp-left)/3 + Math.abs(tmp-left) % 3;
                int rightdist = Math.abs(tmp-right)/3 + Math.abs(tmp-right) % 3;
                
                if(leftdist < rightdist){
                    answer += "L";
                    left = tmp;
                }
                else if(leftdist == rightdist){
                    if(hand.equals("left")){
                        answer += "L";
                        left = tmp;
                    }
                    else if(hand.equals("right")){
                        answer += "R";
                        right = tmp;
                    }
                }
                else{
                    answer += "R";
                    right = tmp;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){
		Solution T = new Solution();
		int[] arr1 = new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		System.out.println(T.solution(arr1, "right"));
        //"LRLLLRLLRRL"

        int[] arr2 = new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		System.out.println(T.solution(arr2, "left"));
        //"LRLLRRLLLRR"
	}
}
