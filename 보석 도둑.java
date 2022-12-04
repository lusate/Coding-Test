import java.util.*;
class Edge implements Comparable<Edge>{
    public int weight, value;
    public Edge(int weight, int value){
        this.weight=weight;
        this.value=value;
    }
    public int compareTo(Edge ob){
        if(this.weight == ob.weight){
            return ob.value - this.value; //무게 같으면 값을 기준 내림차순
        }
        else return this.weight - ob.weight; // 무게 기준 오름차순
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //보석 개수
        int k = sc.nextInt(); //가방 개수
        ArrayList<Edge> jewel = new ArrayList<>();

        for(int i=0; i<n; i++){
            int m = sc.nextInt();
            int v = sc.nextInt();

            jewel.add(new Edge(m, v));
        }
        Collections.sort(jewel);

        //가방 하나에 하나의 보석만 넣을 수 있다.
        
        //예를 들어 가방 무게가 10부터 나오면 무게가 1인 값65가 들어가고 
        //다음 가방 무게 2에 무게가 3인 값 99가 나오면 가방에 더 이상 넣을 수 없는 상황이 발생한다.
        //그래서 가방 무게를 오름차순한다.
        ArrayList<Integer> bag = new ArrayList<>();
        for(int i=0; i<k; i++){
            int c = sc.nextInt(); //가방 최대 무게
            bag.add(c);
        }
        Collections.sort(bag); //가방으로 오름차순

        //최대힙으로.
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        long priceSum = 0L;
        int idx = 0;
        for(int i=0; i<k; i++){ // 가방 개수만큼 보석을 한개 넣음
            //idx는 ArrayList jewel 의 인덱스
            //idx 가 보석 개수를 넘을 때까지 반복, 보석의 무게가 가방의 무게보다 작아야함.
            while(idx < n && jewel.get(idx).weight <= bag.get(i)){
                pQ.offer(jewel.get(idx).value);
                idx++;
            }
            if(!pQ.isEmpty()) priceSum += pQ.poll();
        }
        System.out.println(priceSum);
    }
}


/* 입력
2 1
5 10
100 100
11
*/

/* 출력
10
*/
