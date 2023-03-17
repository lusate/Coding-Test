//큐 사용하면 메모리 사용 한도 초과 발생
//그래서 큐 없이 코드 작성

import java.util.*;
class Solution {
	//방향 조심
	int[] dx = {-1, 0, 1, 0};
	int[] dy = {0, 1, 0, -1};

    public int[] solution(String command) {
		int[] answer = new int[2];
		int x=0, y=0;
		int dir = 1; //오른쪽 회전이면 오른쪽부터 시작하기 위해 dir을 1로 함.
		for(char c : command.toCharArray()){
			if(c == 'G'){
				x += dx[dir];
				y += dy[dir];
			}
			else if(c == 'B'){
				x -= dx[dir];
				y -= dy[dir];
			}
			else if(c == 'R'){
				dir = (dir+1) % 4;
			}
			else if(c == 'L'){
				dir = (dir+3) % 4;
			}
		}

		answer[0] = x;
		answer[1] = y;

		return answer;
    }

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution("GRGLGRG")));
		System.out.println(Arrays.toString(T.solution("GRGRGRB")));
	}
}


/* 출력
[2, 2]
[2, 0]
*/
