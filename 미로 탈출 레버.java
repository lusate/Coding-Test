import java.util.*;
class Solution {
	int n,m;
    char map[][];
    boolean[][] visit;
    
    int dx[]={0,1,0,-1};
    int dy[]={-1,0,1,0};
	public int bfs(int sx,int sy,int ex,int ey){
        int result=Integer.MAX_VALUE;
        Queue<int[]> q=new LinkedList<>();
        visit=new boolean[n][m];
        visit[sx][sy]=true;
        q.offer(new int[]{sx,sy,0});

        while(!q.isEmpty()){
            int[] cur=q.poll();

            
            for(int i=0;i<4;i++){
                int nx=cur[0]+dx[i];
                int ny=cur[1]+dy[i];
                if(nx==ex && ny==ey){
                    result=Math.min(cur[2] + 1, result);
                }
                
                if(nx>=0 && nx<n && ny>=0 && ny<m && map[nx][ny] != 'X' && !visit[nx][ny]){
                    visit[nx][ny]=true;
                    q.offer(new int[]{nx,ny,cur[2] + 1});
                }
            }
        }

        return result;
    }

    public int solution(String[] maps) {
        int answer = 0;
        
        n=maps.length;
        m=maps[0].length();
        int sx=0;
        int sy=0;
        int lx=0;
        int ly=0;
        int ex=0;
        int ey=0;
        map=new char[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map[i][j] = maps[i].charAt(j);
                if(map[i][j] == 'S'){
                    sx=i;
                    sy=j;
                }
                else if(map[i][j] == 'L'){
                    lx=i;
                    ly=j;
                }
                else if(map[i][j] == 'E'){
                    ex=i;
                    ey=j;
                }
            }
        }
        int a=bfs(sx,sy,lx,ly);
        int b=bfs(lx,ly,ex,ey);
        if(a==Integer.MAX_VALUE || b==Integer.MAX_VALUE) return -1;
        answer = a + b;
        return answer;
    }

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new String[]{"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"}));
		System.out.println(T.solution(new String[]{"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"}));
	}
}


/* 출력
16
-1
*/
