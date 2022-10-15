//팀구성 (Line문제)
import java.util.*;
class Main {
	//Arrays.sort(abilities, Collections.reverseOrder());
	//자바는 내림차순 없어서 이건 에러나옴
	public int solution(int[] abilities, int k){
		int answer=0;
		int n = abilities.length;

		//tmp는 내림차순한 abilities
		Integer[] tmp; //꼭 바깥에 선언을 해야 함
		//if문 안에 사용하면 다른 곳에서 이 tmp를 사용할 수가 없음

		if(n % 2 == 1){
			n++; //0을 추가하기 위해 길이 한 칸 늘림
			tmp = new Integer[n];
			//n 이 1 증가한 상태 이므로 n이 아닌 abilities.length 로 해야한다.
			for(int i=0; i<abilities.length; i++){
				tmp[i] = abilities[i];
			}
			tmp[n-1] = 0; //홀수면 끝에 0을 추가
		}

		else{//짝수인 경우는 그대로
			tmp = new Integer[n];
			for(int i=0; i<abilities.length; i++){
				tmp[i] = abilities[i];
			}
		}

		Arrays.sort(tmp, Collections.reverseOrder()); //내림차순
		
		//우선권이 없는 경우
		for(int i=0; i<n/2; i++){ // 라운드 개수 n/2 만큼
			answer += tmp[i*2+1]; //홀수 인덱스가 내가 선택한 사람
		}

		Integer[] diff = new Integer[n/2];  // 매라운드마다의 차를 저장(얘도 내림차순 할거임)
		//우선권 있는 경우
		for(int i=0; i<n/2; i++){
			diff[i] = tmp[i*2] - tmp[i*2+1]; //짝수에서 홀수를 빼서 차를 구함
		}// 그럼 매 라운드마다 능력 차가 생긴다.
		
		//그 차를 내림차순해서 더해준다.
		Arrays.sort(diff, Collections.reverseOrder());
		for(int i=0; i<k; i++){ //k가 우선권 개수
			answer += diff[i];
		}

		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(new int[]{2, 8, 3, 6, 1, 9, 1, 9}, 2));
		System.out.println(T.solution(new int[]{7, 6, 8, 9, 10}, 1));
	}
}



//답
//21
//22
