import java.util.*;
class Solution {
    public int[] solution(String[] wallpaper) {
        int minX = wallpaper.length;
        int minY = wallpaper[0].length();
        int maxX = 0;
        int maxY = 0;
        
        for(int i=0; i<wallpaper.length; i++){
            for(int j=0; j<wallpaper[0].length(); j++){
                if(wallpaper[i].charAt(j) == '#'){
                    minX = Math.min(i, minX);
                    minY = Math.min(j, minY);
                    maxX = Math.max(i, maxX);
                    maxY = Math.max(j, maxY);
                }
            }
        }
        
        return new int[]{minX, minY, maxX + 1, maxY + 1};
    }

	public static void main(String args[]){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(new String[]{".#...", "..#..", "...#."})));
		System.out.println(Arrays.toString(T.solution(new String[]{"..........", ".....#....", "......##..", "...##.....", "....#....."})));
		System.out.println(Arrays.toString(T.solution(new String[]{".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."})));
		System.out.println(Arrays.toString(T.solution(new String[]{"..", "#."})));
	}
}

/* 출력
[0, 1, 3, 4]
[1, 3, 5, 8]
[0, 0, 7, 9]
[1, 0, 2, 1]
*/
