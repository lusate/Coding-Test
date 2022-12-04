import java.util.*;
class Main {
    //말 사이의 거리를 5로 했을 때 몇 마리를 배치할 수 있는지 카운트
    private static int count(int[] arr, int dist){
        int cnt = 1; // 말 한마리 배치
        int ep = arr[0]; //제일 왼쪽에 배치.

        //mid -> dist
        for(int i=1; i<arr.length; i++){
            if(arr[i] - ep >= dist){
                cnt++;
                ep = arr[i];
            }
        }
        return cnt;
    }
    // 말 사이의 거리는 5보다 크거나 같게 배치
    // arr[i] - end >= 5 이어야 다음 말을 넣을 수 있다.
    // 즉 1에 말이 배치 되어 있으니 5보다 크거나 같을려면 8에 위치해야 한다.
    // 말은 3 개의 마구간에 배치해야 한다.
    private static int binary(int n, int m, int[] arr){
        int answer = 0;
        int left = 1;
        int right = arr[n-1];
        Arrays.sort(arr);

        while(left <= right){
            int mid = (left+right) / 2;
            if(count(arr, mid) >= m){
                answer = mid;
                left = mid + 1;
            }
            else right = mid-1;
        }
        
        return answer;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // DVD에 n개의 곡
        int m = sc.nextInt(); // M개의 DVD에 모든 동영상을 녹화.
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(binary(n, m, arr));

    }
}


/* 입력
5 3
1 2 8 4 9
*/


/* 출력
3
*/
