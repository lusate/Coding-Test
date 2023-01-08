import java.util.*;
class Point{
	int x, y, t;

	public Point(int x, int y, int t){
		this.x=x;
		this.y=y;
		this.t=t;
	}
}
class Solution{
	static int[][] Board;
	static int[] dx={-1, 0, 1, 0};
	static int[] dy={0, 1, 0, -1};
	private static int bfs(Point start, Point dst){ //조작키로 이동
		Queue<Point> Q = new LinkedList<>();
		boolean[][] visit = new boolean[4][4];

		Q.offer(start);
		while(!Q.isEmpty()){
			Point tmp = Q.poll();
			if(tmp.x == dst.x && tmp.y == dst.y) return tmp.t;

			for(int i=0; i<4; i++){
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];

				if(nx>=0 && nx<4 && ny>=0 && ny<4){ //방향키로 이동
					if(!visit[nx][ny]){
						Q.offer(new Point(nx, ny, tmp.t+1));
					}

					//한 번 이동하고 최대 2번 더 이동할 수 있기 때문에 j는 1까지해서 반복.
					for(int j=0; j<2; j++){
						if(Board[nx][ny] != 0) break; //그림 카드면 이동 불가능

						//경계 벗어나면 break
						if(nx + dx[i]<0 || nx + dx[i]>=4 || ny + dy[i]<0 || ny + dy[i]>=4){
							break;
						}

						//여기는 이제 이동을 할 수 있음.
						nx += dx[i];
						ny += dy[i];
					}

					if(!visit[nx][ny]){
						Q.offer(new Point(nx, ny, tmp.t+1));
					}
				}
			}
		}

		return Integer.MAX_VALUE;
	}


	private static int check(Point start){
		int result = Integer.MAX_VALUE;

		for(int k=1; k<=6; k++){ //숫자 카드는 1~6까지만 존재.
			ArrayList<Point> card = new ArrayList<>();
			for(int i=0; i<4; i++){
				for(int j=0; j<4; j++){
					if(Board[i][j] == k){ //board에서 남아있는 그림 카드라면 (6개 중 하나라면)
						card.add(new Point(i, j, 0));
					}
				}
			}

			if(card.isEmpty()) continue;

			//같은 숫자 카드를 순차로 삭제할지 역순으로 삭제할지에 따라 조작 횟수가 달라진다
			//순차로 현재 위치에서 숫자가 있는 곳으로 이동 + 그 위치에서 도착 지점으로 이동 + enter 2번
			int se = bfs(start, card.get(0)) + bfs(card.get(0), card.get(1)) + 2;

			//역순은 반대로
			int re = bfs(start, card.get(1)) + bfs(card.get(1), card.get(0)) + 2;


			//카드를 없애줌.
			for(int i=0; i<2; i++){
				Board[card.get(i).x][card.get(i).y] = 0;
			}


			//위 로직으로는 k가 1일 때를 생각하면 한 번만 카드를 뒤집은 경우이므로 재귀를 해서
			//나머지 카드들 2,3 인 경우도 더해준다. 
			result = Math.min(result, se + check(card.get(1)));
			result = Math.min(result, re + check(card.get(0)));


			//1번 하고나서 2번을 할 때 0으로 했던 1번을 다시 복원 해줌.
			for(int i=0; i<2; i++){
				Board[card.get(i).x][card.get(i).y] = k;
			}
		}

		//card가 다 없어지고 나면 result가 MAX_VALUE로 남아있으므로 끝내줌.
		if(result == Integer.MAX_VALUE) return 0;

		return result;
	}


	private static int solution(int[][] board, int r, int c) {
		int answer = 0;
		Board = board;

		answer = check(new Point(r,c,0));
		
		return answer;
	}
	
	public static void main(String[] args){
		System.out.println(solution(new int[][]{{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}}, 1, 0));

		System.out.println(solution(new int[][]{{3,0,0,2},{0,0,1,0},{0,1,0,0},{2,0,0,3}}, 0, 1));
	}
}

/* 출력
14

16
*/
