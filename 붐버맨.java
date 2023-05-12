import java.util.*;
import java.io.*;
public class Main {
    static int r, c, N;
    static char[][] map;
    static int[][] bombtime;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int r = Integer.parseInt(inputs[0]);
        int c = Integer.parseInt(inputs[1]);
        int N = Integer.parseInt(inputs[2]);

        map = new char[r][c];
        bombtime = new int[r][c];

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'O') {
                    bombtime[i][j] = 3;
                }
            }
        }

        int time = 0;
        while (time < N) {
            time++;
            if (time % 2 == 0) {
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (map[i][j] == '.') {
                            map[i][j] = 'O';
                            bombtime[i][j] = time + 3;
                        }
                    }
                }
            }

            else if(time % 2 == 1){
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (bombtime[i][j] == time) {
                            map[i][j] = '.';
                            for (int k = 0; k < 4; k++) {
                                int nx = i + dx[k];
                                int ny = j + dy[k];

                                if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                                    if (map[nx][ny] == 'O' && bombtime[nx][ny] != time) {
                                        map[nx][ny] = '.';
                                        bombtime[nx][ny] = 0;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}


/* 입력
6 7 3
.......
...O...
....O..
.......
OO.....
OO.....


6 7 4
.......
...O...
....O..
.......
OO.....
OO.....


6 7 5
.......
...O...
....O..
.......
OO.....
OO.....
*/


/* 출력
OOO.OOO
OO...OO
OOO...O
..OO.OO
...OOOO
...OOOO

OOOOOOO
OOOOOOO
OOOOOOO
OOOOOOO
OOOOOOO
OOOOOOO


.......
...O...
....O..
.......
OO.....
OO.....
*/
