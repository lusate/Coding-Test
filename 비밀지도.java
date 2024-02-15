import java.util.*;

public class 비밀지도 {

    // 이진수로 만드는 메서드
    public String toBinary(int num, int len){
        String result = "";
        while(num != 0){
            if(num % 2 == 1){
                result = "1" + result;
            } else {
                result = "0" + result;
            };
            num /= 2;
        }

//        while(num != 0){
//            result = num % 2 + result;
//            num /= 2;
//        }

        while (result.length() != len) {
            result = "0" + result;
        }

        return result;
    }
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            String tmp = "";
            String str1 = "";
            String str2 = "";

            str1 = toBinary(arr1[i], n);
            str2 = toBinary(arr2[i], n);

            for (int j = 0; j < n; j++) {
                if (str1.charAt(j) == '1' || str2.charAt(j) == '1') {
                    tmp += "#";
                } else tmp += " ";
            }
            answer[i] = tmp;
        }

        return answer;
    }
    public static void main(String[] args) {
        비밀지도 T = new 비밀지도();
        System.out.println(Arrays.toString(T.solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28})));
        System.out.println(Arrays.toString(T.solution(6, new int[]{46, 33, 33 ,22, 31, 50}, new int[]{27 ,56, 19, 14, 14, 10})));
    }
}
