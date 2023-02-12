import java.util.*;
class Solution {
	public boolean dfs(String str){
        int mid = (str.length() - 1) / 2; //가운데에 있는 것이 루트.
        char root = str.charAt(mid); //mid 인덱스의 문자가 root.
        String lt = str.substring(0, mid); //root를 제외한 나머지 문자열들
        String rt = str.substring(mid+1, str.length());
        
        int ltRoot = (lt.length() - 1) / 2; //왼쪽 문자열의 루트값
        int rtRoot = (rt.length() - 1) / 2; //오른쪽
        
        if(root == '0' && (lt.charAt(ltRoot) == '1' || rt.charAt(rtRoot) == '1')){
            return false;
        } //root가 0이고 왼쪽, 오른쪽 문자열의 Root에 있는 값이 1이면 false로 포화 이진트리 불가능.

        boolean flag = true;
		// 0001010 의 경우 lt 가 3 이상임.
        if(lt.length() >= 3){
            flag = dfs(lt);
        }
        if(flag && rt.length() >= 3){
            flag = dfs(rt);
        }

       return flag;
    }

    public int[] solution(long[] numbers) {
		int n = numbers.length;
        int[] answer = new int[n];
        
        for(int i=0; i<n; i++){
            String str = Long.toBinaryString(numbers[i]);  //10진수를 2진수로
            // System.out.println(str);
            
            int m = 0;
            while(Math.pow(2, m) - 1 < str.length()){
                m++;
            }
            
			//포화 이진트리는 높이를 h라 했을 때 노드의 개수 = 2**h - 1
			//그래서 h를 증가시켜가며 주어진 요소의 길이보다 큰 노드의 개수 값을 찾고 그 차이만큼 앞에 0을 추가.
            for(int j=0; j<Math.pow(2, m)-1; j++){
                if(Math.pow(2, m) - 1 == str.length()) break;
                str = "0" + str; //10 처럼 m=3이 되고 if문에서 7 != 4 이되면 "0"을 더해줌.
            }
			// System.out.println(str);
			// 111
			// 0101010
			// 0001010
            
            if(dfs(str)) answer[i] = 1;
            else answer[i] = 0;
        }
        
        return answer;
    }

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(new long[]{7, 42, 10})));
		System.out.println(Arrays.toString(T.solution(new long[]{63, 111, 95})));
	}
}


/* 출력
[1, 1, 1]
[1, 1, 0]
*/
