import java.util.*;
class Main{
	public ArrayList<Integer> solution(int n, int[] arr){
		ArrayList<Integer> answer = new ArrayList<>();
		int[] tmp = arr.clone();
		Arrays.sort(tmp);

		for(int i=0; i<n; i++){
			if(arr[i] != tmp[i]) answer.add(i+1);
		}
		System.out.println(answer);
		return answer;
	}
	public static void main(String[] args){
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		T.solution(n, arr);
	}
}


/* 입력
9
120 125 152 130 135 135 143 127 160
*/

/*출력
3 8
*/
