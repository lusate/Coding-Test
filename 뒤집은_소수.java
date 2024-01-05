package 인프런_입문.배열;

import java.util.*;
public class 뒤집은_소수 {
    public boolean isPrime(int num) {
        if(num == 1) return false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    public ArrayList<Integer> solution(int n, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int tmp = arr[i];
            int res = 0;

            // 910을 반대로 바꿀 때 19. 32을 23으로 바꿀 때. 공식 암기
            while (tmp>0) {
                int one = tmp % 10;
                tmp = tmp / 10;
                res = res * 10 + one;
            }

            if (isPrime(res)) {
                answer.add(res);
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        뒤집은_소수 T = new 뒤집은_소수();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        for(int x : T.solution(n, arr)){
            System.out.print(x+" ");
        }
    }
}


/*
▣ 입력예제 1 
9
32 55 62 20 250 370 200 30 100
▣ 출력예제 1
23 2 73 2 3
*/
