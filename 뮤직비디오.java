import java.util.*;
class Main {
    // capacity 이 용량으로 했을 때 DVD  m장 안에 담을 수 있는지를 카운트
    private static int count(int[] arr, int capacity){
        int cnt = 1, sum = 0; //DVD 장 수, DVD에 담아내는 곡들의 합
        for(int x : arr){
            if(sum + x > capacity){ // capacity -> 27
                cnt++; //용량보다 크다면 DVD 장 수를 늘려야 한다.
                sum = x;
            }
            else sum += x;
            // sum += x -> 1+2+3+4+5+6 = 21 이 되었고 7을 더하게 되면 28이 되어 capacity 보다 크므로
            // DVD 하나 늘리고 sum -> x 로 저장한다. 그렇게 해서 DVD 장 수를 카운드.
        }
        return cnt;
    }
    private static int binary(int n, int m, int[] arr){
        int answer = 0;
        // left는 arr에서 최대값 -> 최소한 DVD 한 장의 용량이 9는 되어야 하기 때문에
        int left = Arrays.stream(arr).max().getAsInt(); //배열에서 stream으로 최대값 찾기.
        //stream 에서 max(), min() 은 getAsInt()를 사용해주어야 함.

        int right = Arrays.stream(arr).sum(); //배열에 있는 모든 값을 더함.

        while(left <= right){
            int mid = (left + right) / 2; //DVD 한 장 용량
            if(count(arr, mid) <= m){ // DVD m장 보다 작게 담을 수 있다면 가능하다.
                answer = mid;
                right = mid - 1;
            }
            else left = mid + 1;
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
9 3
1 2 3 4 5 6 7 8 9
*/


/* 출력
17
*/
