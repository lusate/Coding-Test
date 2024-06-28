package 프로그래머스;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        HashMap<Integer, Integer> out = new HashMap<>();
        HashMap<Integer, Integer> in = new HashMap<>();

        for(int[] edge : edges) {
            out.put(edge[0], out.getOrDefault(edge[0], 0) + 1);
            in.put(edge[1], in.getOrDefault(edge[1], 0) + 1);
        }

        /**
         * 생성한 정점 번호
         * 들어오는 간선 없고, 나가는 간선이 2개 이상
         */
        for (int node : out.keySet()) {
            if(out.get(node) >= 2){
                if (!in.containsKey(node)) {
                    answer[0] = node;
                } else if (in.get(node) >= 2) {
                    answer[3] += 1;
                }
            }
        }

        /**
         * 마지막 정점 기준으로 나가는 간선 0개, 들어오는 간선 1개
         * 들어 오는 간선은 있는데 나가는 간선이 없으면 막대 그래프 추가
         */
        for (int node : in.keySet()) {
            if (!out.containsKey(node)) {
                answer[2] += 1;
            }
        }

        /**
         * 모든 정점 기준으로 나가는 간선 1개 이상, 들어오는 간선 1개 이상
         * 생성 정점에서 out간선 개수 - 막대 - 8자
         * => 즉 전체 그래프 수 - 막대 - 8자 = 도넛 그래프 개수
         */
        answer[1] = out.get(answer[0]) - answer[2] - answer[3];

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new int[][]{{2, 3}, {4, 3}, {1, 1}, {2, 1}})));

        System.out.println(Arrays.toString(T.solution(new int[][]{{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6},
                {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}})));

    }
}

// ---------------------------------------------------------------------------------------------------------

// 다른 풀이

package 프로그래머스;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] solution(int[][] edges) {
        HashMap<Integer, int[]> nodes = new HashMap<>();

        int extraNode = 0;
        int doughnut = 0;
        int stick = 0;
        int figure8 = 0;

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            // 이 부분 없으면 기본값이 없기 때문에 개수를 셀 수가 없음.
            // getOrDefault(map, 0) 할 때 0인 것처럼.
            if(!nodes.containsKey(from)) {
                nodes.put(from, new int[]{0, 0});
            }
            if (!nodes.containsKey(to)) {
                nodes.put(to, new int[]{0, 0});
            }

            nodes.get(from)[0]++;
            nodes.get(to)[1]++;
        }

        for (int key : nodes.keySet()) {
            int[] count = nodes.get(key);

            if (count[0] >= 2 && count[1] == 0) {
                extraNode = key;
            } else if (count[0] == 0 && count[1] > 0) {
                stick++;
            } else if (count[0] >= 2 && count[1] >= 2) {
                figure8++;
            }
        }

        doughnut = nodes.get(extraNode)[0] - stick - figure8;

        return new int[]{extraNode, doughnut, stick, figure8};

    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new int[][]{{2, 3}, {4, 3}, {1, 1}, {2, 1}})));

        System.out.println(Arrays.toString(T.solution(new int[][]{{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6},
                {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}})));

    }
}

