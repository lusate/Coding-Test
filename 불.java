import java.util.*;
class Point{
    int x, y;
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}
class Main {
	static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int r,c;
    static int[][] map, visited;
    static Queue<Point> jQ = new LinkedList<>();
    static Queue<Point> fQ = new LinkedList<>();
    static boolean[][] jQvisited;
    static boolean[][] fQvisited;
	public void bfs(){
        int time = 0;
        while(!jQ.isEmpty()){
            int jQlen = jQ.size();
            int fQlen = fQ.size();
            for(int i=0; i<fQlen; i++){
                Point fire = fQ.poll();
                for(int j=0; j<4; j++){
                    int nx = fire.x + dx[j];
                    int ny = fire.y + dy[j];
                    if(nx>=0 && nx<r && ny>=0 && ny<c && map[nx][ny] != '#' && !fQvisited[nx][ny]){
                        fQvisited[nx][ny] = true;
                        map[nx][ny] = 'F';
                        fQ.offer(new Point(nx, ny));
                    }
                }
            }
            
            for(int i=0; i<jQlen; i++){
                Point ji = jQ.poll();
                for(int j=0; j<4; j++){
                    int nx = ji.x + dx[j];
                    int ny = ji.y + dy[j];
                    if(nx>=0 && nx<r && ny>=0 && ny<c){
                        if(map[nx][ny] == '.' && !jQvisited[nx][ny]){
                            jQvisited[nx][ny] = true;
                            jQ.offer(new Point(nx, ny));
                        }    
                    }
                }
            }
            time++;
        }
        System.out.println(time);
	}

	public static void main(String[] args) throws Exception{
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
        c = sc.nextInt();
		map = new int[r][c];
        jQvisited = new boolean[r][c];
        fQvisited = new boolean[r][c];

		for(int i=0; i<r; i++){
            String s = sc.next();
			for(int j=0; j<c; j++){
				map[i][j] = s.charAt(j);
                if(map[i][j] == 'J'){
                    map[i][j] = '.';
                    jQ.offer(new Point(i, j));
                    jQvisited[i][j] = true;
                }
                else if(map[i][j] == 'F'){
                    fQ.offer(new Point(i, j));
                    fQvisited[i][j] = true;
                }
			}
		}
        T.bfs();
	}
}


/* 입력
4 4
####
#JF#
#..#
#..#

4 4
####
#JF#
#..#
####
*/

/* 출력
3

IMPOSSIBLE
*/
