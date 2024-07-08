package 프로그래머스;

import java.util.PriorityQueue;

public class 붕대감기 {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for (int i = 0; i < attacks.length; i++) {
            pq.add(new int[]{attacks[i][0], attacks[i][1]});
        }

        int time = 0; // 현재 시간
        int band = 0; // 붕대 성공 횟수


        while(!pq.isEmpty()){
            int[] tmp = pq.poll(); // 공격 받은 시간과 공격력

            if (time == tmp[0]) { // 공격을 받은 경우
                band = 0;
                answer -= tmp[1];
                if(answer <= 0) return -1;
            }
            else{
                // 현재 시간과 공격받은 시간이 일치하지 않음
                pq.add(new int[]{tmp[0], tmp[1]}); // 그래서 다시 넣어줌.
                answer += bandage[1];
                band++;

                if (band == bandage[0]) {
                    answer += bandage[2];
                    band = 0; // 연속 붕대 성공했으므로 초기화
                }
                if(answer > health) answer = health;
            }


            // 5초가 되면


            time++;
        }

        return answer;
    }

    public static void main(String[] args) {
        붕대감기 T = new 붕대감기();
        System.out.println(T.solution(new int[]{5, 1, 5}, 30,
                new int[][]{{2, 10}, {9, 15}, {10, 5}, {11, 5}}));

        System.out.println(T.solution(new int[]{3, 2, 7}, 20,
                new int[][]{{1, 15}, {5, 16}, {8, 6}}));

        System.out.println(T.solution(new int[]{4, 2, 7}, 20,
                new int[][]{{1, 15}, {5, 16}, {8, 6}}));

        System.out.println(T.solution(new int[]{1, 1, 1}, 5,
                new int[][]{{1, 2}, {3, 2}}));
    }
}


/*
다른 풀이
import java.util.PriorityQueue;

public class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int idx = 0;
        int band = 0;

        for(int i=1; i<=attacks[attacks.length-1][0]; i++){
            if(i != attacks[idx][0]){
                answer += bandage[1];
                band++;
                if(band == bandage[0]){
                    answer += bandage[2];
                    band = 0;
                }
                if(answer > health) answer = health;
            }

            else{
                band = 0;
                answer -= attacks[idx][1];
                idx++;
                if(answer <= 0) return -1;
            }
        }



        return answer;
    }
}

 */
