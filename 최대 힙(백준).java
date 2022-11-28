import java.util.*;
 
class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        //System.out.println(pQ);
        int n = sc.nextInt();
		for(int i=0; i<n; i++){
			int num = sc.nextInt();
			if(num == 0){
				if(!pQ.isEmpty()){
					System.out.println(pQ.poll());
				}
				else{
					System.out.println(0);
				}
			}
			pQ.offer(num);
		}
    }
}

/* 입력
13
0
1
2
0
0
3
2
1
0
0
0
0
0
*/

/* 출력
0
2
1
3
2
1
0
0
*/
