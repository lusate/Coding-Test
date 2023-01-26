import java.util.*;
class Solution {
	public int solution(String[] board){
		int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int n = board.length;
        int m = board[0].length();
        char[][] chars = new char[n][m];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = board[i].charAt(j);
                chars[i][j] = c;
                if (c >= 97 && c <= 122) {
                    cnt++;
                }
            }
        }
        int keys = (1 << cnt) - 1;
        Queue<int[]> queue = new LinkedList();
        boolean[][][] visited = new boolean[n][m][keys + 1];
        queue.offer(new int[]{0, 0, 0});
        visited[0][0][0] = true;
        int L = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int x = cur[0] + dx[k];
                    int y = cur[1] + dy[k];
                    if (x < 0 || x >= n || y < 0 || y >= m || chars[x][y] == '#') {
                        continue;
                    }
                    char c = chars[x][y];
                    int ks = addKey(cur[2], (int)c);
                    if(ks == keys) return L + 1;
                    if (visited[x][y][ks]) {
                        continue;
                    }
                    if (c >= 65 && c <= 90 && !unlock(cur[2], (int)c)) continue;
                    visited[x][y][ks] = true;
                    queue.offer(new int[]{x, y, ks});
                }
            }
            L++;
        }
        return -1;
   }
   public int addKey(int keys, int c) {
        if (c >= 97 && c <= 122) {
            int index = c - 97;
            return keys | (1 << index);
        }
        return keys;
    }
    
    public boolean unlock(int keys, int c) {
        int index = c - 65;
        return (keys & (1 << index)) > 0;
    }
		
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new String[]{"..a.b", "###B#", "..#A.", ".cC..", "....."}));
		System.out.println(T.solution(new String[]{"..a..", "###.#", "b.A.B"}));
		System.out.println(T.solution(new String[]{"...aA", "..B#.", "....b"}));
	}
}
