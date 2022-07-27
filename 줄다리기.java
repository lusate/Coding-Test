import java.util.*;
class Main {
	int answer=0;
	int[] ch;
	Stack<Integer> pm = new Stack<>();
	int[][] relation;

	public void DFS(int L){
		if(L == 7){
			answer++;
		}
		else{
			for(int i=1; i<8; i++){
				//1 2 4 가 되면 안되므로 4 이후는 의미없음
				//그래서 relation에서 1을 만나는 경우로 싸우게 되면
				//continue로 다음 if문 pass함
				if(!pm.empty() && relation[pm.peek()][i] == 1) continue;
				if(ch[i] == 0){
					pm.push(i);
					DFS(L+1);
					ch[i]=0;
					pm.pop();
				}
			}
		}
	}
	public int solution(int[][] fight){
		//학생 인원 수 8
		relation = new int[8][8];
		for(int[] x : fight){
			relation[x[0]][x[1]] = 1;
			relation[x[1]][x[0]] = 1;
		}
		//{1, 3}, {5, 7}, {4, 2} / {3, 1}, {7, 5}, {2, 4} 일 때도 1이므로 무방향 그래프로
		ch = new int[8];
		
		
		return answer;
	}
		
	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
	}
}
