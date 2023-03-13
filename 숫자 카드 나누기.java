import java.util.*;
class Solution {
    public boolean notDivide(int[] arr, int n){
        for(int x : arr)
            if(x % n == 0)
                return false;
        return true;
    }
    
    // 최대공약수 구하기
    public int gcd(int a, int b){
        if(a % b == 0)return b;
        return gcd(b, a % b);
    }
  
    public int solution(int[] arrayA, int[] arrayB) {
        // 0. 입력 및 초기화
        int answer = 0;
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        // 1. 각 배열의 최대공약수 구하기
        for(int i =1; i< arrayA.length;i++){
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }
        // System.out.println(gcdA);
        // System.out.println(gcdB);
        
        // 2. 서로의 배열을 나눌 수 없는지 확인
        // arrayA에서 최대공약수로 arrayB를 나눌 수 없는지 확인
        if(notDivide(arrayB, gcdA)){
            answer = Math.max(answer, gcdA);
        }
        
        // arrayB에서 최대공약수로 arrayA를 나눌 수 없는지 확인
        if(notDivide(arrayA, gcdB)){
            answer = Math.max(answer, gcdB);
        }
        
        // 3. 최댓값 반환
        return answer;
    }

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[]{10, 17}, new int[]{5, 20}));
        System.out.println(T.solution(new int[]{10, 20}, new int[]{5, 17}));
        System.out.println(T.solution(new int[]{14, 35, 119}, new int[]{18, 30, 102}));
	}
}

/* 출력
0
10
7
*/
