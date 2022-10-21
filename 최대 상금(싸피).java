import java.util.*;
import java.io.*;

class Solution {
    // 전역 배열 (점수판)
    static int[] numbers;
    // 최대 값
    static int max = 0;
	static String str;
    // dfs 함수 (인덱스, 변동 제한 수)
    public static void dfs(int start, int chance) {
        if(chance == 0){ //바꾸는 기회가 더 이상 없으면
			str = ""; //num 숫자를 넣을 문자.

			//int[] numbers 에 v를 문자열로 바꿔서 각각에 더해줌.
			Arrays.stream(numbers).forEach(v -> str += String.valueOf(v));
			int price = Integer.parseInt(str);
			if(price > max) max = price;
			return;
		}
		
		for(int i=start; i<numbers.length-1; i++){
			for(int j=i+1; j<numbers.length; j++){
				int temp = numbers[i];
				numbers[i] = numbers[j];
				numbers[j] = temp;

				dfs(i, chance - 1);

				numbers[j] = numbers[i];
				numbers[i] = temp;
			}
		}
    }
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1 ; test_case <= T ; test_case++) {
            // max는 항상 초기화 해줘야함
            max = 0;
            // 번호판 입력
            int num = sc.nextInt();
            // 제한 횟수 입력
            int chance = sc.nextInt();
            
			//정수형 num을 문자열로 바꾸고 char[] 에 저장.
			char[] ch = Integer.toString(num).toCharArray();

			numbers = new int[ch.length];

			for(int i=0; i<ch.length; i++){
				numbers[i] = ch[i] - '0';
			}//문자를 다시 숫자로

			//123 으로 length가 3인데 chance 가 5이라 하면 chance = 3으로
			//즉 number 길이가 chance보다 크면 안됨.
			if(numbers.length < chance) chance = numbers.length;
			dfs(0, chance);

			System.out.println("#" + test_case + " " + max);
        }
    }
}


/* 입력
10
123 1
2737 1
757148 1
78466 2
32888 2
777770 5
436659 2
431159 7
112233 3
456789 10
*/


/* 출력
#1 321
#2 7732
#3 857147
#4 87664
#5 88832
#6 777770
#7 966354
#8 954311
#9 332211
#10 987645
*/
