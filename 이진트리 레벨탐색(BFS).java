import java.util.*;
class Main {
	ArrayList<Integer> answer = new ArrayList<>();
	public ArrayList<Integer> solution(int n){
		Queue<Integer> Q=new LinkedList<>();
		Q.offer(1); //Q에 1들어감
		int L=0; //레벨 0
		while(!Q.isEmpty()){
			int len=Q.size(); //0레벨일 때 1개이므로 len=1
			//1레벨이면 2개 이므로 len=2로 2바퀴 돔 다음은 len=4
			for(int i=0; i<len; i++){
				int v=Q.poll(); //1 꺼냄, 레벨 바퀴 돌고나면 Q는 비어있어야 함
				answer.add(v); //v = 1
				for(int nv : new int[]{v*2, v*2+1}){ //Q에 2하고 3이 들어감
					if(nv>n) continue;
					Q.offer(nv);
				}//answer가 3레벨 까지 했다면 nv는 4레벨이 된다.
			}
			//System.out.println(L+" "+answer);
			//0 [1]
			//1 [1, 2, 3]
			//2 [1, 2, 3, 4, 5, 6, 7]
			L++; //레벨이 1 증가해서 다음은 레벨이 0 -> 1
		}
		return answer;
	}
		
	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(7));
	}
}
