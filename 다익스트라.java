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
class Main{
	static ArrayList<ArrayList<Edge>> graph;
	static int[] dis;
	static int n,m;
	public void solution(int v){
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		pQ.offer(new Edge(v, 0));
		dis[v] = 0;
		while(!pQ.isEmpty()){
			Edge tmp = pQ.poll();
			int now = tmp.vex;
			int nowCost = tmp.cost;
			if(nowCost > dis[now]) continue;
			for(Edge ob : graph.get(now)){
				if(dis[ob.vex] > nowCost + ob.cost){
					dis[ob.vex] = nowCost + ob.cost;
					pQ.offer(new Edge(ob.vex, nowCost+ob.cost));
				}
			}
		}
	}
	public static void main(String[] args){
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		graph = new ArrayList<ArrayList<Edge>>();
		for(int i=0; i<=n; i++){
			graph.add(new ArrayList<Edge>());
		}
		dis = new int[n+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		for(int i=0; i<m; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			graph.get(a).add(new Edge(b, c));
		}

		T.solution(1);
		for(int i=2; i<=n; i++){
			if(dis[i] != Integer.MAX_VALUE) System.out.println(i + " : " + dis[i]);
			else System.out.println(i + " : impossible");
		}
	}
}


/* 입력
6 9
1 2 12
1 3 4
2 1 2
2 3 5
2 5 5
3 4 5
4 2 2
4 5 5
6 4 5
*/

/* 출력
2 : 11
3 : 4
4 : 9
5 : 14
6 : impossible
*/


////////////////////////////////////////////////////////////////////////////////////////////////////////////////


import java.util.*;
//(1,0), (2, 12).... 으로 1번 정점 가는데 드는 비용 0, 2번 정점 가는데 드는 비용 12 
//이런식으로 만들기 위해서 Edge 클래스를 생성
class Edge implements Comparable<Edge>{
    public int vex;
	public int cost;
    Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge ob){
        return this.cost-ob.cost; //최소힙으로 오름차순
    }//this에서 ob객체 빼면 오름차순
	//비용을 오름차순으로
}

class Main {
	public int solution(int n, int[][] edges, int end){
		ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
		for(int i=0; i<=n; i++){ //n+1 인덱스를 만들기 위함
			graph.add(new ArrayList<Edge>());
		}
		int[] dis = new int[n+1];
		Arrays.fill(dis, Integer.MAX_VALUE); //dis를 무한대로 초기화하는 과정
		for(int[] x : edges){
			graph.get(x[0]).add(new Edge(x[1], x[2]));
		}// 시작 정점에서x[0]에서 x[1]로 가는데 드는 비용은 x[2] 이다.

		//다익스트라 시작
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		pQ.offer(new Edge(1, 0));
		dis[1] = 0; //1번 정점으로 가는 비용은 0으로 초기화 (안 하면 무한대임)
		while(!pQ.isEmpty()){
			Edge tmp = pQ.poll(); //Edge 형 변수
			int now = tmp.vex; //현재 내가 위치한 정점
			int nowCost = tmp.cost; //현재 위치한 정점까지의 비용
			if(nowCost > dis[now]) continue; //현재 위치한 정점의 비용이 작은 경우 continue
			for(Edge ob : graph.get(now)){ //now 정점과 연결된 좌표들 now가 1이면 ob.vex는 2, ob.cost는 비용 12
				if(dis[ob.vex] > nowCost + ob.cost){// 
					dis[ob.vex] = nowCost + ob.cost; //작은 값으로 갱신
					pQ.offer(new Edge(ob.vex, dis[ob.vex]));
				}
			}
		}
		
		return dis[end] == Integer.MAX_VALUE? -1 : dis[end];
		//무한대 그대로 있으면 -1 리턴 아니면 dis[end] 비교한 최소 비용을 리턴
	}
		
	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(6, new int[][]{{1, 2, 12}, {1, 3, 4}, 
			{2, 1, 2}, {2, 3, 5}, {2, 5, 5}, {3, 4, 5}, {4, 2, 2}, {4, 5, 5}, {6, 4, 5}}, 5));
	}
}
/* 입력
1번 정점에서 출발해서 5번 정점으로 가는데
최소 비용
*/

/* 출력
14
*/

//다익스트라 : 특정한 하나의 정점에서 다른 모든 정점으로 가는 최단 경로
