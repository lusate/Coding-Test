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
        return this.cost-ob.cost; //최소힙으로 오름차순
    }//this에서 객체 빼면 오름차순
}

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
        }
        int[] dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for(int[] x : edge){
            graph.get(x[0]).add(x[1]);
            graph.get(x[1]).add(x[0]);
        }
        
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(1, 0));
        dis[1]=0;
        dis[0]=0; //dis[0]은 무한대로 저장되어 있어서 밑에서 계산할 때 
		//최대가 무한대가 되버림
        
        while(!pQ.isEmpty()){
			Edge tmp = pQ.poll();
			int now = tmp.vex;
			int nowCost = tmp.cost;
			if(nowCost > dis[now]) continue;

			//비용을 계산하는 것이 아님
			for(int nv : graph.get(now)){
				if(dis[nv] > nowCost + 1){
					//간선 하나를 지나가는 것을 가중치 1로 생각하고 계산해서 +1을 한다
					dis[nv] = nowCost + 1;
					pQ.offer(new Edge(nv, dis[nv]));
				}
			}
		}
        
        int maxd = 0;
        for(int x : dis){ //dis는 시작에서 도착까지의 비용
            maxd = Math.max(maxd, x); //문제에서는 최대 거리 2이다
        }
        for(int x : dis){
            if(x == maxd) answer++; //2인 것의 개수를 세주면 
        } //maxd와 같은 정점들을 카운트
        return answer;
    }

	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(6, new int[][]{{3, 6}, {4,3}, {3,2}, {1,3}, {1,2}, {2,4} ,{5,2}}));
	}
}
