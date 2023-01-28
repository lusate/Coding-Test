import java.util.*;
class Solution{
	private static String[] solution(int[] nums) {
		String[] answer = new String[nums.length];

		//한 자리수, 두 자리수, 세 자리수.... 일 때 회문이 몇개인지
		
		for(int i=0; i<nums.length; i++){
			int n = nums[i];
			int t = 1; //자릿수
			n--;

			for(int j=1; ; j++){
				if(n >= 9 * t){
					n = n - (9*t);
				}
				else{ //146이 나옴.
					int len = (j+1) / 2; //0, 1, 2번에 채워넣음. 그 다음은 1,2,3번
					int[] res = new int[100]; //자릿수
					String pal = "";

					//처음 숫자를 1로 초기화를 해준다. -> 첫 자리가 0이 될 수 없으므로
					res[0] = 1;
					for(int k=0; k<len; k++){
						//100으로 나눈 몫을 저장
						res[k] += (n / t);
						pal += String.valueOf(res[k]);
						n = n % t; // 146 -> 46
						t = t / 10; // 100나누고 그 다음 10을 나눔. 그 다음은 1
					}

					//거꾸로 삽입
					for(int k=len-1-(j%2); k>=0; k--){
						pal += String.valueOf(res[k]);
					}

					answer[i] = pal;
					break; //j가 break;
				}

				if(j % 2 == 0){
					t = t * 10; //j가 3일 때(자릿수가 세자리) 부터 10곱해서 90으로
				}
			}
			
		}
		return answer;
	}
	
	public static void main(String[] args){
		System.out.println(Arrays.toString(solution(new int[]{1, 12, 24})));
		System.out.println(Arrays.toString(solution(new int[]{10, 15, 30})));
		System.out.println(Arrays.toString(solution(new int[]{345, 3456, 2352, 939595})));
	}
}


/* 출력
["1", "33", "151"]
["11", "66", "212"]
["24642", "2457542", "1353531", "83959695938"]
*/
