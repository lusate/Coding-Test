import java.util.*;
 
class Solution{
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case=1; test_case<=T; test_case++) {
            double D = sc.nextDouble();
			int N = sc.nextInt();
			double max = 0;
			for(int i=0; i<N; i++){
				double S = sc.nextDouble();
				double K = sc.nextDouble();
				
				max = Math.max(max, (D-S) / K);
			}
			System.out.printf("#%d %.8f\n", test_case, D/max);
        }
    }
}

// 거리 / 속력 = 시간.


/* 입력
3
101 1
96 1
101 2
96 1
1 100
101 2
1 1
96 1
*/

/* 출력
#1 20.2000000
#2 20.2000000
#3 1.0100000
*/
