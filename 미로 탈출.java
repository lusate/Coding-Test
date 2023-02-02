import java.util.*;
class Edge {
    int vertex;
    int weight;
    boolean isReverse;

    public Edge(int vertex, int weight, boolean isReverse) {
        this.vertex = vertex;
        this.weight = weight;
        this.isReverse = isReverse;
    }
}
class Node implements Comparable<Node> {
    // 현재 노드
    int vertex;
    // 시작 ~ 현재 노드의 경로
    int weight;
    // 현재 트랩의 활성 상태
    int trapStatus;

    public Node(int vertex, int weight, int trapStatus) {
        this.vertex = vertex;
        this.weight = weight;
        this.trapStatus = trapStatus;
    }

    @Override
    public int compareTo(Node ob) {
        return this.weight > ob.weight ? 1 : -1;
    }
}

class Solution{
		public int solution(int n, int start, int end, int[][] roads, int[] traps){
		int answer = 0;

		return answer;
    }
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(3, 1, 3, new int[][]{{1,2,2}, {3,2,3}}, new int[]{2}));
		System.out.println(T.solution(4, 1, 4, new int[][]{{1,2,1}, {3,2,1}, {2,4,1}}, new int[]{2,3}));
	}
}


/* 출력
5
4 
*/
