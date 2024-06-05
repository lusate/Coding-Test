package 프로그래머스;

public class 다트게임 {
    public int solution(String dartResult) {
        int answer = 0;
        int len = dartResult.length();

        StringBuilder str = new StringBuilder();
        int[] arr = new int[3];
        int idx = 0;
        for(int i=0; i<len; i++){
            char now = dartResult.charAt(i);

            if (Character.isDigit(now)) {
                str.append(now);
            }

            else if (Character.isAlphabetic(now)) {
                int n = Integer.parseInt(String.valueOf(str));
                if (now == 'S') {
                    arr[idx++] = (int) Math.pow(n, 1);
                }
                else if (now == 'D') {
                    arr[idx++] = (int) Math.pow(n, 2);
                }
                else if (now == 'T') {
                    arr[idx++] = (int) Math.pow(n, 3);
                }

                str = new StringBuilder("");
            }

            /**
             * 여기까지 오면 idx는 2가 됨. 즉 다트 다 쏘고 옵션을 계산.
             * 옵션이 맨 앞에 위치해서 이전 것에 대해 계산을 하지 않음.
             * 그래서 idx - 2 값이 0보다 커야 이전 것에 대해 계산이 가능함.
             */
            else{
                if(now == '*'){
                    arr[idx - 1] *= 2;
                    if (idx - 2 >= 0) {
                        arr[idx - 2] *= 2;
                    }
                }

                else if(now == '#'){
                    arr[idx - 1] *= -1;
                }
            }
        }

        answer = arr[0] + arr[1] + arr[2];
        return answer;
    }

    public static void main(String[] args) {
        다트게임 T = new 다트게임();
        System.out.println(T.solution("1S2D*3T"));
        System.out.println(T.solution("1D2S#10S"));
        System.out.println(T.solution("1D2S0T"));
        System.out.println(T.solution("1S*2T*3S"));
        System.out.println(T.solution("1D#2S*3S"));
        System.out.println(T.solution("1T2D3D#"));
        System.out.println(T.solution("1D2S3T*"));
    }
}

/* answer
37
9
3
23
5
-4
59
 */
