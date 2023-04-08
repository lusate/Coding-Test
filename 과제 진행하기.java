import java.util.*;
class Info implements Comparable<Info> {
    String sub;
    int st, play;

    Info(String sub, int st, int play) {
        this.sub = sub;
        this.st = st;
        this.play = play;
    }

    @Override
    public int compareTo(Info ob) {
        return this.st - ob.st;
    }
}

class Solution{
    public int getTime(String s) {
        int H = Integer.parseInt(s.split(":")[0]);
        int M = Integer.parseInt(s.split(":")[1]);

        return H * 60 + M;
    }

    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        int idx = 0;
        PriorityQueue<Info> pq = new PriorityQueue<>();
        // 멈춰둔 과제가 여러 개일 경우, 가장 최근에 멈춘 과제부터 시작하기 위해 stack이 필요.
        Stack<Info> stack = new Stack<>();

        for (int i = 0; i < plans.length; i++) {
            pq.add(new Info(plans[i][0], getTime(plans[i][1]), Integer.parseInt(plans[i][2])));
        }

        Info cur = pq.poll();
        while (!pq.isEmpty()) {
            Info next = pq.poll();

            // 현재 끝나는 시간이 다음 시작하는 시간보다 짧음.
            if (cur.st + cur.play <= next.st) { //중간에 멈추지 않고 바로 이어감.
                answer[idx++] = cur.sub;

                int rest = next.st - (cur.st + cur.play); // 현재 과제가 끝나고 다음 과제까지 남은 시간.
                
                // 과제를 끝낸 시각에 새로 시작해야 되는 과제와 잠시 멈춰둔 과제가 모두 있다면, 새로 시작해야 하는 과제부터 진행
                while (!stack.isEmpty()) {
                    Info tmp = stack.pop();
                    if (tmp.play <= rest) { // ???? 나중에 다시
                        rest -= tmp.play;
                        answer[idx++] = tmp.sub;
                    }
                    else{
                        tmp.play -= rest;
                        stack.push(new Info(tmp.sub, tmp.st, tmp.play));
                        break;
                    }
                }
            }
            else{
                stack.push(new Info(cur.sub, cur.st, cur.play - (next.st - cur.st)));
            }

            cur = next; //현재를 다음 과목으로 갱신.
        }

        answer[idx++] = cur.sub;

        while (!stack.isEmpty()) {
            answer[idx++] = stack.pop().sub;
        }

        return answer;
    }


    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new String[][]{{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}})));
        System.out.println(Arrays.toString(T.solution(new String[][]{{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}})));
        System.out.println(Arrays.toString(T.solution(new String[][]{{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}})));
    }
}
