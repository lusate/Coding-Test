import java.util.*;
class Main {
	//3명 뽑고 나머지 3명은 다른 팀으로 순열이 아닌 조합
	int n, answer=2147000000;
	int[] ch;
	public void DFS(int L, int s, int[][] cans){
		if(L == n/2){
			ArrayList<Integer> A = new ArrayList<>();
			ArrayList<Integer> B = new ArrayList<>();
			for(int i=0; i<n; i++){
				if(ch[i] == 1){
					A.add(i);
				}
				else{
					B.add(i);
				}
				System.out.print(A);
				System.out.println();
				System.out.print(B);
			}

			int Asum=0, Bsum=0;
			for(int i=0; i<L; i++){
				Asum += cans[A.get(i)][0];
				Bsum += cans[B.get(i)][1];
			}
			answer = Math.min(answer, Math.abs(Asum - Bsum));
		}
		else{
			for(int i=s; i<n; i++){
				ch[i] = 1;
				DFS(L+1, i+1, cans);
				ch[i] = 0;
			}
		}
	}
	public int solution(int[][] cans){
		n = cans.length;
		ch = new int[n];
		DFS(0,0,cans);
		return answer;
	}
		
	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(new int[][]{{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
	}
}
