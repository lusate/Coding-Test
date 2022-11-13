import java.util.*;
class Edge implements Comparable<Edge>{
	public int vex, cost;
	Edge(int vex, int cost){
		this.vex = vex;
		this.cost = cost;
	}
	@Override
	public int compareTo(Edge ob){
		return this.cost - ob.cost;
	}
}
class Main {
	public static void main(String[] args){
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
		for(int i=0; i<=n; i++){
			graph.add(new ArrayList<Edge>());
		}
		int[] ch = new int[n+1];
		for(int i=0; i<=n; i++){
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
			graph.get(a).add(new Edge(b,c));
			graph.get(b).add(new Edge(a,c));
		}

		int answer=0;
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		pQ.offer(new Edge(1, 0)); //1번 정점으로 가는데 비용은 0
		while(!pQ.isEmpty()){
			Edge tmp = pQ.poll();
			int nv = tmp.vex; //nv는 도착 정점.
			if(ch[nv] == 0){
				ch[nv] = 1;
				answer += tmp.cost;
				for(Edge ob : graph.get(nv)){
					if(ch[ob.vex] == 0) pQ.offer(new Edge(ob.vex, ob.cost));
				}
			}
		}
		System.out.println(answer);
	}
}


/* 입력
9 12
1 2 12
1 9 25
2 3 10
2 8 17
2 9 8
3 4 18
3 7 55
4 5 44
5 6 60
5 7 38
7 8 35
8 9 15
*/


/* 출력
196
*/
