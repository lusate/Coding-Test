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
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		String[] dir = {"u", "r", "d", "l"};

		PriorityQueue<Info> pq = new PriorityQueue<>();
		pq.add(new Info(x, y, 0, ""));

		while(!pq.isEmpty()){
			Info tmp = pq.poll();
			int minDist = Math.abs(tmp.r - r) + Math.abs(tmp.c - c);
			int remainDist = k - tmp.dist;

			if(remainDist < minDist || (remainDist - minDist) % 2 != 0) continue;

			if(tmp.dist == k && r == tmp.r && c == tmp.c){
				return tmp.path;
			}

			for(int t=0; t<4; t++){
				int nx = tmp.r + dx[t];
				int ny = tmp.c + dy[t];

				if(nx<1 || ny<1 || nx>n || ny>m || tmp.dist >= k) continue;
				pq.add(new Info(nx, ny, tmp.dist+1, tmp.path + dir[t]));
				// if(tmp.dist < k && nx >= 1 && nx <= n && ny >= 1 && ny <= m) {
                //     pq.offer(new Info(nx, ny, tmp.dist + 1, tmp.path + dir[t]));
                // }
			}
		}
        
        return "impossible";
    }

	public static void main(String args[]){
		Solution T = new Solution();
		System.out.println(T.solution(3, 4, 2, 3, 3, 1, 5));
		System.out.println(T.solution(2, 2, 1, 1, 2, 2, 2));
		System.out.println(T.solution(3, 3, 1, 2, 3, 3, 4));
	}
}


/* 출력
dllrl
dr
impossible
*/
