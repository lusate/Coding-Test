import java.util.*;
import java.io.*;
class Main {
    static int max;
    private static int binarySearch(int n, int m, int[] arr){
        int left = 0; //0분
        // 놀이기구 최대 운행 시간.
        // 학생 3명이 모두 최대 운행 시간 3번 놀이기구를 선택하면 3*9
        // 놀이기구 총 5개 이므로 27 * 5 하면 놀이기구 최대 운행 시간이 나옴.
        int right = n * max * m;
        
        int result = 0;

        //left = 0 , right = 135로 시작.
        while(left <= right){
            // mid -> 65, 33, 16, 7, 3, 1, 0
            int mid = (left + right) / 2;
            System.out.println("mid = " + mid);
            int count = m; //처음에 사람들이 놀이기구에 모두 탐.

            for(int i=0; i<m; i++){
                count += mid / arr[i]; // 시간 / 운행 시간만큼 사람들이 타게 됨.
            }

            if(n <= count){
                result = mid;
                right = mid - 1;
            }

            else{
                left = mid + 1;
            }
        }
        return result;
    }
    public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.valueOf(st.nextToken());	// 전체 명 수  
		int m = Integer.valueOf(st.nextToken());	// 전체 놀이기구 수 
		
		int[] ridesTime = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			ridesTime[i] = Integer.valueOf(st.nextToken());
			max = Math.max(max, ridesTime[i]);
		}
		
		long result = binarySearch(n, m, ridesTime);
		
		// result - 1 분일 때 총 인원 수 구하기 
		long prevTime = result - 1;
		long prevCount = m;	// 처음 0분일 때 모든 놀이기구가 비어있으므로 모든 놀이기구에 인원 투입 (m명) 
		long[] prevRidesTime = new long[m];
		for(int i = 0; i < m ; i++) {
			prevRidesTime[i] = prevTime / ridesTime[i];
			prevCount += prevRidesTime[i];
		}
		
		// 마지막 학생이 타는 놀이기구 찾기
		long nowNeedsCount = n - prevCount;
		long nowCount = 0;
		long ridesNum = n;	// 만약, n < m 인 경우에는 처음 시작할 때 n명을 탑승시킬수 있어 n번째 사람은 n번 놀이기구를 탄다.
		for(int i = 0; i < m; i++) {
			if(result / ridesTime[i] != prevRidesTime[i]) {
//				System.out.println(result / ridesTime[i] + " , " + prevRidesTime[i] + " , i 일때 : " + i);
				nowCount++;
				if(nowCount == nowNeedsCount) {
					ridesNum = i + 1;	// 놀이기구의 번호는 1 ~ M 번 까지이므로 
					break;
				}
			}
		}
		
		System.out.println(ridesNum);
	}
}


/* 입력
3 5
7 8 9 7 8


22 5
1 2 3 4 5
*/


/* 출력
3

4
*/
