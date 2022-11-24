import java.util.*;
 
class Solution {
    static int N,M;
    static int[] dis;
    static ArrayList<int[]>[] graph;
 
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int Tc = sc.nextInt();
        
        for(int test_case=1; test_case<=Tc; test_case++){
            N = sc.nextInt();
            M = sc.nextInt();
            graph = new ArrayList[N+1];
            for (int i = 0; i <= N; i++) {
				graph[i] = new ArrayList<>();
			}
 
            dis = new int[N+1];
            Arrays.fill(dis, Integer.MAX_VALUE);
            for(int i=0; i<M; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                int x = sc.nextInt();
                int y = sc.nextInt();
 
                graph[a].add(new int[]{b, x, y});
                graph[b].add(new int[]{a, x, y});
            }
 
            solution();
 
            if(dis[2]!=Integer.MAX_VALUE){
				System.out.println("#" + test_case + " " + dis[2]);
			}
			else System.out.println("#" + test_case + " -1");
        }
    }
 
    private static void solution() {
		//다익스트라
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));

        for(int[] next : graph[1]){
			//System.out.println(next[0]); //2, 3
			//System.out.println(next[1]); //9, 1
			//System.out.println(next[2]); //9, 1
            if(dis[next[0]]>next[1]*next[2]){
                pq.add(new int[]{next[0],next[1], next[2]});
                dis[next[0]] = next[1]*next[2];
            }
        }
 
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
 
            for(int[] next : graph[current[0]]){
                int sumX = current[1] + next[1];
                int sumY = current[2] + next[2];
 
                if(dis[next[0]] > sumX*sumY){
                    pq.add(new int[]{next[0], sumX, sumY});
                    dis[next[0]] = sumX*sumY;
                }
            }
        }
    }
}

/* 입력
3
4 4
1 3 1 9
4 1 4 4
2 3 9 1
2 4 4 4
3 0
3 3
1 2 9 9
2 3 4 1
3 1 1 1
*/

/* 출력
64
-1
10
*/
