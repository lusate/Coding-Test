import java.util.*;
class Main{
    public int solution(int W, int H, int[] arr){
        // 투포인터로 밀고 나가면서 진행.
        int answer=0;
        
        // 왼쪽 max와 오른쪽 max를 따로 구해준다.
        // 왼쪽 벽 오른쪽 벽 최대를 구하는 알고리즘 암기.
        for(int right=1; right<W-1; right++){
            int leftmax = arr[right]; //인덱스 아님
            
            for(int j=right-1; j>=0; j--){
                if(arr[j] > arr[right]){
                    leftmax = Math.max(leftmax, arr[j]);
                }
            }
            int rightmax = arr[right];
            for(int j=right+1; j<W; j++){
                if(arr[j] > arr[right]){
                    rightmax = Math.max(rightmax, arr[j]);
                }
            }
            
            if(Math.min(leftmax, rightmax) > arr[right]){ //현재 벽보다 높은 벽이 양쪽에 있는 경우
                answer += (Math.min(leftmax, rightmax) - arr[right]);
            }
        }
        System.out.println(answer);
        return answer;
    }
    public static void main(String[] args) throws Exception{
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt(); // 4
        int W = sc.nextInt(); // 8
        int[] arr = new int[W];

        for(int i=0; i<W; i++){
            arr[i] = sc.nextInt();
        }

        T.solution(W, H, arr);
    }
}


/* 입력
4 4
3 0 1 4

4 8
3 1 2 3 4 1 1 2
*/

/* 출력
5

5
*/
