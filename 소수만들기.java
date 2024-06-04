import java.util.*;

public class Solution {
    public boolean check(int num) {
        boolean flag = true;
        if (num == 2) {
            return flag;
        }

        for (int i = 2; i < num; i++) {
            if(num % i == 0){
                flag = false;
                break;
            }
        }

        return flag;
    }
    public int solution(int[] nums) {
        int answer = 0;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int num = nums[i] + nums[j] + nums[k];
                    if(num >= 2){
                        flag = check(num);
                    }
                    if(flag){
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{1,2,3,4}));
        System.out.println(T.solution(new int[]{1,2,7,6,4}));
    }
}

/**
 * 정답
 * 1
 * 4
 */
