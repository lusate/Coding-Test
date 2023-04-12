import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data, (a,b) -> a[col-1] == b[col-1] ? b[0] - a[0] : a[col-1] - b[col-1]);
        
        
        for(int i=row_begin-1; i<row_end; i++){
            int sum = 0;
            for(int x : data[i]){
                sum += (x % (i+1));
            }
            
            answer ^= sum; // ^ 는 XOR 연산
        }
        return answer;
    }
}
