import java.util.*;
class Main{
	Stack<Integer> pm = new Stack<>();
	//main이 static 이기 때문에 static이로 선언
	static int n, m;
	static int[] ch;
	static int[] nums; // 입력 넣을 배열
	public void DFS(int L){
		if(L==m){
			for(int x : pm) System.out.print(x+" ");
			System.out.println();
		}
		else{
			for(int i=0; i<n; i++){
				//체크를 안 한다면 (3 3)으로 중복 출력이 된다.
				if(ch[i] == 0){ //체크가 안되어있는 경우
					ch[i] = 1; //체크를 1로 해주고 push
					pm.push(nums[i]);
					DFS(L+1);
					//다시 초기화 시켜주고 pop
					ch[i] = 0;
					pm.pop();
				}
			}
		}
		//ch[0] = 1, push(3), DFS(1), ch[1]=1, push(6), DFS(2)가 되서 (3, 6) 출력
		//ch[1] = 0 초기화하고 pop
		//(3, ) 에서 ch[1] = 1, push(6), DFS(2)가 되서 (3, 9) 출력
		//ch[2] = 0 초기화 하고 pop 하면 [] 비어있게 됨

		//i=1부터 시작
		//ch[1] = 1, push(6), DFS(1), ch[0]=1, push(3), DFS(2)가 되서 (6,3 ) 출력
		//ch[0] = 0 초기화하고 pop
		//(6, ) 에서 ch[2] = 1, push(9), DFS(2)가 되서 (6, 9) 출력
		//ch[2] = 0 초기화 하고 pop 하면 [] 비어있게 됨
	}
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		n=kb.nextInt();
		m=kb.nextInt();
		ch=new int[n];
		nums=new int[n];
		//3을 사용했으면 ch에 0인덱스에서 1으로 체크를 해줌
		for(int i=0; i<n; i++){
			nums[i] = kb.nextInt();
		}
		T.DFS(0);
	}
}
