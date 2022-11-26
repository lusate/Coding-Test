import java.util.*;
 
class Solution{
	static int n, cnt;
	static int[] arr;
	static int min;
	private static void solution(){
        for(int i=0;i<7;i++) { //시작 날짜는 일~토 로 아무때나 시작이 가능하다.
            int j=i;
            cnt = 0;
            int m = n;
            while(m != 0) {
                if(arr[j] == 1)
                    m--;
                j++; //다음 날
                if(j == 7) // 날짜가 7일이 되면 다시 처음으로 초기화
                    j=0;
                cnt++; //날짜 추가
            }
			
			//min 하는 이유는 일(arr[0])부터 시작하면 cnt = 9
			//월(arr[1]) 부터 시작하면 cnt = 8
			//화(arr[2]) 부터 시작하면 cnt = 14 , 차례대로 13,12,11,10 이 된다.
			//여기서 최소값을 선택!!
            if(min > cnt)
            	min = cnt;
        }
	}
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case=1; test_case<=T; test_case++) {
            arr = new int[7];
            n = sc.nextInt();
			min = 9999999;
            for(int i=0;i<7;i++)
                arr[i] = sc.nextInt();
            
			solution();
            System.out.println("#" + test_case + " " + min);
        }
    }
}


/*입력 
3
2
0 1 0 0 0 0 0
100000
1 0 0 0 1 0 1
1
1 0 0 0 0 0 0
*/


/* 출력
#1 8
#2 233332
#3 1
*/
