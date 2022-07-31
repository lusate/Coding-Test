import java.util.*;
class Main {
	public int solution(int n, int[] lost, int[] reserve){
		int answer = n - lost.length;
		Arrays.sort(lost);
		Arrays.sort(reserve);

		//여벌 체육복을 가져온 학생이 도난당한 경우 체육복을 빌려줄 수가 없음
		//그래서 reserve 배열에서 제외시켜준다. (reserve[j] 값을 -1로 변경)
		//lost[i] 의 값도 -1로 변경해 도난당한 대상에서 제외시킨다.
		for(int i=0; i<lost.length; i++){
			for(int j=0; j<reserve.length; j++){
				if(lost[i] == reserve[j]){ 
					answer++;
					lost[i] = reserve[j] = -1; // -1로 reserve에서 제외
					//본인 체육복은 있지만 빌려주지는 못함 그래서 reserve 에서 제외
					break;
				}
			}
		}

		//체육복 빌려주기
		for(int i=0; i<lost.length; i++){
			for(int j=0; j<reserve.length; j++){
				//잃어버린 사람 앞 번호 또는 뒷 번호가 reserve와 같다면 빌려주어서 answer++
				if(lost[i]-1 == reserve[j] || lost[i]+1 == reserve[j]){
					answer++;
					reserve[j] = -1; //빌려주고 난 후 -1로 resereve에서 제외
					break;
				}
			}
		}

		return answer;
	}
		
	public static void main(String[] args){
		Main T = new Main();
		int[] lost1 = new int[]{2,4};
		int[] reserve1 = new int[]{1,3,5};
		System.out.println(T.solution(5, lost1, reserve1));

		int[] lost2 = new int[]{2,4};
		int[] reserve2 = new int[]{3};
		System.out.println(T.solution(5, lost2, reserve2));

		int[] lost3 = new int[]{3};
		int[] reserve3 = new int[]{1,3,5};
		System.out.println(T.solution(5, lost3, reserve3));
	}
}
