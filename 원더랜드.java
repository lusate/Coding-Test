import java.util.*;
class Edge implements Comparable<Edge>{
    public int v1; 
	public int v2;
	public int cost;
    Edge(int v1, int v2, int cost) {
        this.v1 = v1;
		this.v2 = v2;
        this.cost = cost;
    }
    @Override //cost 값에 의해서 오름차순
    public int compareTo(Edge ob){
        return this.cost-ob.cost;
    }
}

class Main {
	int[] unf;
	public int Find(int v){
		if(v == unf[v]) return v;
		else return unf[v] = Find(unf[v]);
	}
	public void Union(int a, int b){
		int fa = Find(a);
		int fb = Find(b);
		if(fa != fb) unf[fa] = fb;
	}

	public int solution(int n, int[][] edges){
		unf = new int[n+1];
		ArrayList<Edge> list = new ArrayList<>();
		for(int i=1; i<=n; i++){
			unf[i] = i;
			//System.out.print(unf[i]); 1 ~ 9까지
		}
		for(int[] x : edges){
			list.add(new Edge(x[0], x[1], x[2]));
		} //간선 정보 add
		
		int answer=0;
		//System.out.print(list);
		Collections.sort(list); //오름차순 정렬 (비용 x[2]를 기준으로)
		//list는 입력한 edges 들
		
		for(Edge ob : list){ // 다르면 선택 같으면 지나감
			int fv1 = Find(ob.v1);
			int fv2 = Find(ob.v2);
			if(fv1 != fv2){
				answer += ob.cost;
				Union(ob.v1, ob.v2);
			}
		}
		return answer;
    }
	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(9, new int[][]{{1, 2, 12}, {1, 9, 25}, {2, 3, 10}, {2, 8, 17}, {2, 9, 8}, 
			{3, 4, 18}, {3, 7, 55}, {4, 5, 44}, {5, 6, 60}, {5, 7, 38}, {7, 8, 35}, {8, 9, 15}}));
	}
}
