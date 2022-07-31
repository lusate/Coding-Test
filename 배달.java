import java.util.*;
class Edge implements Comparable<Edge>{
    public int vex;
	public int cost;
    Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge ob){
        return this.cost-ob.cost;
    }
}

class Main {
    public int solution(int N, int[][] road, int K){
		int answer=0;
		ArrayList<ArrayList<Edge>> graph=new ArrayList<>();
		for(int i=0; i<=N; i++){
			graph.add(new ArrayList<Edge>());
		}
		int[] dis=new int[N+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		for(int[] x : road){
			graph.get(x[0]).add(new Edge(x[1], x[2]));
			graph.get(x[1]).add(new Edge(x[0], x[2]));
		}
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		pQ.offer(new Edge(1, 0));
		dis[1]=0;
		while(!pQ.isEmpty()){
			Edge tmp=pQ.poll();
			int now=tmp.vex;
			int nowCost=tmp.cost;
			if(nowCost>dis[now]) continue;
			for(Edge ob : graph.get(now)){
				if(dis[ob.vex]>nowCost+ob.cost){
					dis[ob.vex]=nowCost+ob.cost;
					pQ.offer(new Edge(ob.vex, dis[ob.vex]));
				}
			}
		}
		
		for(int x : dis){
			if(x <= K) {
				answer++;
			}
		}
		return answer;
    }

	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(5, new int[][]{{1, 2, 1}, {2, 3, 3}, 
			{5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}}, 3));
		
		System.out.println(T.solution(6, new int[][]{{1, 2, 1}, {1, 3, 2}, 
			{2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}}, 4));
	}
}

//결과는 4, 4


현재 1번 마을에 있는 음식점에서 각 마을로 음식 배달을 하려고 합니다. 
각 마을로부터 음식 주문을 받으려고 하는데, N개의 마을 중에서 K 시간 이하로 배달이 가능한 마을에서만 주문을 받으려고 합니다
