//Union & Find 기본 문제.
import java.util.*;
class Solution{
    int[] parent;
    public int Find(int a) {
        if (a == parent[a]) {
            return parent[a];
        }
        else
            return parent[a] = Find(parent[a]);
    }
    public void Union(int a, int b) { //a, b를 한 집합으로 만들기 위함.
        a = Find(a);
        b = Find(b);
        if (a > b) {
            parent[a] = b;
        }
        else{
            parent[b] = a;
        }
    }
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];

        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        int sum = 0;
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < costs.length; i++) {
            if (Find(costs[i][0]) != Find(costs[i][1])) { // 같지 않으면 "서로 같은 집합이다" 라고 parent에 연결해줌.
                answer += costs[i][2]; //같은 집합이므로 cost 더해줌.
                Union(costs[i][0], costs[i][1]); //같은 집합으로 만들어줌.
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(4, new int[][]{{0,1,1}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,8}}));
    }
}
