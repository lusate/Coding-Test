package 인프런_입문.배열;

import java.util.*;
public class 보이는_학생 {
    public int solution(int n, int[] arr){
        int answer = 0;
        int max = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        보이는_학생 T = new 보이는_학생();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, arr));
    }
}

/*
▣ 입력예제 1 
8
130 135 148 140 145 150 150 153 
▣ 출력예제 1
5
*/
