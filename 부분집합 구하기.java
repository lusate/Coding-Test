import java.util.*;
class Main {
    static int n;
	static int[] ch; //체크 하고 안 하고를 판단. 즉 부분집합으로 사용 O 또는 X
    private static void dfs(int L){
		if(L == n+1){
			String tmp = "";
			for(int i=1; i<=n; i++){
				if(ch[i] == 1) tmp += (i + " ");
			}

			//0보다 커야 공집합이 되지 않음.
			if(tmp.length() > 0) System.out.println(tmp);
		}
		else{
			ch[L] = 1;
			dfs(L+1); //트리 왼쪽으로 뻗어 나감. -> 부분 집합으로 사용함.

			ch[L] = 0;
			dfs(L+1); //트리 오른쪽으로 뻗어 나감. -> 부분 집합으로 사용 안 함.
		}
    }
    public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		ch = new int[n+1];

		dfs(1);
	}
}


/* 입력
3
*/


/* 출력
1 2 3
1 2
1 3
1
2 3
2
3
*/
