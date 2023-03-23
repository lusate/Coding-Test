import java.util.*;
class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    
    public int[] solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        char[][] board = new char[n][m];
        boolean[][] visit = new boolean[n][m];
	    
        for(int i=0; i<n; i++){
            String s = maps[i];
            for(int j=0; j<m; j++){
                board[i][j] = s.charAt(j);
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visit[i][j] && board[i][j] != 'X'){ // 방문한 적이 없어야 그 지역을 탐색할 수 있다. (이것 때문에 못풀었음.)
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    visit[i][j] = true;
                    
                    int sum = 0;
                    while(!q.isEmpty()){
                        int[] tmp = q.poll();
                        
                        sum += board[tmp[0]][tmp[1]] - 48;
                        for(int k=0; k<4; k++){
                            int nx = tmp[0] + dx[k];
                            int ny = tmp[1] + dy[k];
                            
                            if(nx>=0 && ny>=0 && nx<n && ny<m && board[nx][ny] != 'X' && !visit[nx][ny]){
                                q.offer(new int[]{nx, ny});
                                visit[nx][ny] = true;
                            }
                        }
                    }
                    
                    res.add(sum);
                }
            }
        }
        
        
        Collections.sort(res);
        if(res.size() == 0) res.add(-1);
        
        int[] answer = new int[res.size()];
        for(int i=0; i<res.size(); i++){
            answer[i] = res.get(i);
        }
        return answer;
    }

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(new String[]{"X591X","X1X5X","X231X", "1XXX1"})));
		System.out.println(Arrays.toString(T.solution(new String[]{"XXX","XXX","XXX"})));
	}
}


/* 출력
[1, 1, 27]
[-1]
*/
