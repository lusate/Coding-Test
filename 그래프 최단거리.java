import java.util.*;
public class Main {
	static int n, m;
	static ArrayList<ArrayList<Integer>> graph;
	static int[] ch, dis;
	
	public void BFS(int v){
		Queue<Integer> Q = new LinkedList<>();
		ch[v] = 1;
		dis[v] = 0;
		Q.offer(v);

		while(!Q.isEmpty()){
			int x = Q.poll();
			for(int nx : graph.get(x)){
				if(ch[nx] == 0){
					ch[nx] = 1;
					Q.offer(nx);
					dis[nx] = dis[v] + 1;
				}
			}
		}
	}

    public static void main(String[] args){
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		graph = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=n; i++){
			graph.add(new ArrayList<Integer>());
		}
		ch = new int[n+1];
		dis = new int[n+1];
		for(int i=0; i<m; i++){
			int s = sc.nextInt();
			int e = sc.nextInt();
			graph.get(s).add(e);
		}

		T.BFS(1);

		for(int i=2; i<=n; i++){
			System.out.println(i + " : " + dis[i]);
		}
	}
}
