import java.io.*;
import java.util.*;

class Time{
    int time, end;
    Time(int time, int end) {
        this.time = time;
        this.end = end;
    }
}
class Main{
    /**
     * ArrayList<Time> 으로 해서 0번 인덱스를 계속 삭제하려 했으나 객체 타입으로 들어가면 remove 사용 불가.
     * Queue로는 정렬 불가능 따라서 PriorityQueue를 사용.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /**
         * Queue로는 정렬 불가능
         */
        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Time> pq = new PriorityQueue<>((a, b) -> a.end - b.end);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken()); // 걸리는 시간
            int E = Integer.parseInt(st.nextToken()); // 끝내야 하는 시간

            pq.add(new Time(T, E));
        }


        int start = 0;
        int min = Integer.MAX_VALUE;
        boolean flag = true;

        while (!pq.isEmpty()) {
            Time now = pq.poll();

            start += now.time;
            if(start > now.end){
                flag = false;
                break;
            }
            /**
             * start는 가장 처음 시작 시간을 구해야 하므로 min으로 잡아야 한다.
             * 최소값을 구할 때 바로 첫 번째 일의 시작 시간을 구하면 안 된다.
             * 예시의 경우 끝내야 하는 시간을 초과하게 된다. -> start(3) + time(3) = 6
             * 그래서 끝내야 하는 시간에서 시작 시간을 뺀 값으로 min을 비교해야 한다.
             */
            min = Math.min(min, now.end - start);
//            System.out.println("start = " + start);
        }
        if(!flag) System.out.println(-1);
        else System.out.println(min);

    }
}

/*
4
3 5
8 14
5 20
1 16
*/
