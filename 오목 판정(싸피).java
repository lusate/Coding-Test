import java.util.*;
 
class Solution {
    static int n,cnt,ans;
    static int [] dx = {-1,0,1,1,1,0,-1,-1}, dy = {-1,-1,-1,0,1,1,1,0};
    static char [][] arr;
     
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            n = sc.nextInt();
            arr = new char [n][n];
            for (int i = 0; i < n; i++) {
                String s = sc.next();
                arr[i] = s.toCharArray();
            }
            ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(arr[i][j]=='o') check(j,i);
                }
            }
            if(ans==1) System.out.println("#"+t+" YES");
            else System.out.println("#"+t+" NO");
        }
    }
 
    private static void check(int x, int y) {
        int nx = x;
        int ny = y;
        for (int i = 0; i < 8; i++) {
            cnt = 0;
            while(true) {
                nx += dx[i];
                ny += dy[i];
                if(nx<0||nx>=n||ny<0||ny>=n||arr[ny][nx]!='o') {
                    nx -= dx[i];
                    ny -= dy[i];
                    break;
                }
                else if(++cnt == 4) {
                    ans = 1;
                    break;
                }
            }
        }
    }
}



/* 입력
4
5
....o
...o.
..o..
.o...
o....
5
...o.
ooooo
...o.
...o.
.....
5
.o.oo
oo.oo
.oo..
.o...
.o...
5
.o.o.
o.o.o
.o.o.
o.o.o
.o.o.
*/

/* 출력
#1 YES
#2 YES
#3 YES
#4 NO
*/
