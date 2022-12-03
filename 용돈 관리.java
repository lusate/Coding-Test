import java.util.*;
class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 인출 횟수
		int m = sc.nextInt();

		int[] money = new int[n]; //사용할 금액.

		int left = 0;
		int right = 0;

		for(int i=0; i<n; i++){
			money[i] = sc.nextInt();
			if(left < money[i]){  
				left = money[i]; // 100, 400, 500
				//left = 500
				//System.out.println("left = " + left);
			}
			
			right += money[i]; // 100, 500, 800, 900, 1400, 1501, 1901
			//right = 1901
		}

		while(left <= right){
			int mid = (left + right) / 2;
			int sum = 0;
			int cnt = 0; //인출 횟수

			for(int i=0; i<n; i++){
				if(sum + money[i] > mid){
					sum = 0;
					cnt++; //인출 횟수
				}
				sum += money[i]; //집어넣고 다시 K원 인출
			}
			if(sum != 0) cnt++;
			if(cnt > m) left = mid+1;
			else right = mid-1;
		}

		System.out.println(left);
	}
}


/* 입력
7 5
100
400
300
100
500
101
400
*/


/* 출력
500
*/
