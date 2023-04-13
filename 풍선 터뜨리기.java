import java.util.*;
class Solution {
    public int solution(int[] a) {
        int[] leftMin = new int[a.length]; //왼쪽 원소의 최솟값
        int[] rightMin = new int[a.length]; //오른쪽 원소의 최솟값

        int lt = a[0];
        int rt = a[a.length - 1];

        for (int i = 1; i < a.length - 1; i++) { //왼쪽 원소를 찾을려는 것이므로 a[1] ~ a[9]까지
            if(lt > a[i]) lt = a[i];
            leftMin[i] = lt;
            //a[i]보다 lt가 더 작으므로 leftMin에 넣어줌. 그런데 lt보다 작은 것이 있으면 교체
        }
        for (int i = a.length - 2; i > 0; i--) { //오른쪽이므로 a[8] ~ a[0]
            if (rt > a[i]) rt = a[i];
            rightMin[i] = rt;
            //a[i]보다 rt가 더 작으므로 rightMin에 넣어줌. 그런데 rt보다 작은 것이 있으면 교체
        }

        // leftMin - [0, -16, -16, -16, -16, -92, -92, -92, -92, 0]
        // rightMin - [0, -92, -92, -92, -92, -92, -71, -68, -61, 0]

        if(a.length == 1) return 1;

        // 원소가 2개 이상이면 무조건 2개 이상은 남는다.
        int answer = 2; // a에서 lt, rt 값은 항상 남을 수 있기 때문이다.
        for (int i = 1; i < a.length - 1; i++) {
            if(a[i] > leftMin[i] && a[i] > rightMin[i]) continue;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{9,-1,-5}));
        System.out.println(T.solution(new int[]{-16,27,65,-2,58,-92,-71,-68,-61,-33}));
    }
}

/* 출력
3
6
*/


/**
 * 왼쪽, 오른쪽 값의 최소값을 찾아야 하는 이유는
 * 풍선을 차례대로 큰값들만 터트린다고 가정하면, 마지막에는 왼쪽에서 가장 작은 번호와 오른쪽에서 가장 작은 번호가 남게 될 것이다.
 * 즉, 이 값들을 현재 풍선 번호와 비교하고 두 값이 모두 작지 않다면 터트려서 하나만 남길 수 있는 풍선이 된다.
 */
