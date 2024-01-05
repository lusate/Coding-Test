package 인프런_입문.배열;

import java.util.*;
public class 등수구하기 {
    public int[] solution(int n, int[] arr){
        int[] answer = new int[n];
        for(int i=0; i<n; i++){
            int cnt = 1;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    cnt++;
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }

    public static void main(String[] args) {
        등수구하기 T = new 등수구하기();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i] = kb.nextInt();
        }
        for(int x : T.solution(n, arr)) System.out.print(x+" ");
    }
}

/*
▣ 입력예제 1 
5
87 89 92 100 76
▣ 출력예제 1
4 3 2 1 5

*/
