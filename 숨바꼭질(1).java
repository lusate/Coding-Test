import java.util.*;
class Edge{
    int vex, cost;

    Edge(int vex, int cost){
        this.vex = vex;
        this.cost = cost;
    }
}

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] lenArray;
    static int maxLen = Integer.MIN_VALUE;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        visited = new boolean[N+1];
        lenArray = new int[N+1];
        for(int i = 0; i<=N; i++)
            graph.add(new ArrayList<>());

        for(int i=0; i<M; i++){
            int s = sc.nextInt();
			int e = sc.nextInt();

            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        bfs();

        int maxIdx = 0;
        int maxCnt = 0;
        for(int i = 1; i<=N; i++)
            if(lenArray[i] == maxLen){
                if(maxIdx == 0)
                    maxIdx = i;
                maxCnt++;
            }

        System.out.println(maxIdx+" "+maxLen+" "+maxCnt);
    }

    static void bfs(){
        Queue<Edge> q = new LinkedList<>();
        q.offer(new Edge(1, 0));
        visited[1] = true;

        while(!q.isEmpty()){
            Edge tmp = q.poll();

            maxLen = Math.max(maxLen, tmp.cost);
            lenArray[tmp.vex] = tmp.cost;

            for(int i = 0; i<graph.get(tmp.vex).size(); i++){
                int nextV = graph.get(tmp.vex).get(i);

                if(visited[nextV])
                    continue;

                q.offer(new Edge(nextV, tmp.cost+1));
                visited[nextV] = true;
            }
        }
    }
}
