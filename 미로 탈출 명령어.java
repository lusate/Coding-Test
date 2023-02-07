import java.util.*;
class Info implements Comparable<Info>{
	int r, c, dist;
	String path;
	Info(int r, int c, int dist, String path){
		this.r=r;
		this.c=c;
		this.dist=dist;
		this.path=path;
	}

	@Override
	public int compareTo(Info ob){
		return path.compareTo(ob.path);
	}
}
class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
	    	String answer = "impossible";
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		String[] dir = {"u", "r", "d", "l"};

		PriorityQueue<Info> pq = new PriorityQueue<>();
		pq.add(new Info(x, y, 0, ""));

		while(!pq.isEmpty()){
			Info tmp = pq.poll();
			//도착지점까지 최소 거리 계산
			int minDist = Math.abs(tmp.r - r) + Math.abs(tmp.c - c);
			//남은 거리 계산
			int remainDist = k - tmp.dist;

			//최소 거리가 3인데 남은 거리가 3보다 작아질 수 없음.
			//0이 되면 continue -> 0으로 홀수가 되면 
			// remainDist - minDist가 홀수면 E에 도착했다가 이동하고나서 다시 E로 갈 수가 없음.
			if(remainDist < minDist || (remainDist - minDist) % 2 != 0){
				continue;
			}
			if(tmp.dist == k && r == tmp.r && c == tmp.c){ //도착
				return tmp.path;
			}

			for(int t=0; t<4; t++){
				int nx = tmp.r + dx[t];
				int ny = tmp.c + dy[t];

				if(nx<1 || ny<1 || nx>n || ny>m || tmp.dist > k) continue;
				pq.add(new Info(nx, ny, tmp.dist+1, tmp.path + dir[t]));
				// if(tmp.dist < k && nx >= 1 && nx <= n && ny >= 1 && ny <= m) {
                //     pq.offer(new Info(nx, ny, tmp.dist + 1, tmp.path + dir[t]));
                // }
			}
		}
        
        return answer;
    }

	public static void main(String args[]){
		Solution T = new Solution();
		System.out.println(T.solution(3, 4, 2, 4, 3, 1, 5));
		System.out.println(T.solution(2, 2, 1, 1, 2, 2, 2));
		System.out.println(T.solution(3, 3, 1, 2, 3, 3, 4));
	}
}


/* 출력
dllrl
dr
impossible
*/
