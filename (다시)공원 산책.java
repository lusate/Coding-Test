import java.util.*;
class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public int[] solution(String[] park, String[] routes) {
        int n = park.length;
        int m = park[0].length();
        char[][] map = new char[n][m];
        
        int sx = 0;
        int sy = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j] = park[i].charAt(j);
                
                if(map[i][j] == 'S'){
                    sx = i;
                    sy = j;
                }
            }
        }
        
        int[] answer = new int[2];
        
        for(String x : routes){
            String a = x.split(" ")[0];
            int b = Integer.parseInt(x.split(" ")[1]);
            
            if(sx>=0 && sy>=0 && sx<n && sy<m && map[sx][sy] != 'X'){
                if(a.equals("N")){
                    sx += b * dx[0];
                    sy += b * dy[0];
                }
                else if(a.equals("E")){
                    sx += b * dx[1];
                    sy += b * dy[1];
                }
                else if(a.equals("S")){
                    sx += b * dx[2];
                    sy += b * dy[2];
                }
                else if(a.equals("W")){
                    sx += b * dx[3];
                    sy += b * dy[3];
                }
            }
            // System.out.println(sx + " : " + sy);
            
            answer[0] = sx;
            answer[1] = sy;
        }
        
        return answer;
    }

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(new String[]{"SOO","OOO","OOO"}, new String[]{"E 2","S 2","W 1"})));
		System.out.println(Arrays.toString(T.solution(new String[]{"SOO","OXX","OOO"}, new String[]{"E 2","S 2","W 1"})));
		System.out.println(Arrays.toString(T.solution(new String[]{"OSO","OOO","OXO","OOO"}, new String[]{"E 2","S 3","W 1"})));
	}
}


/* 출력
[2,1]
[0,1]
[0,0]
*/
