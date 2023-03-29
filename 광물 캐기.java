import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int sum = picks[0] + picks[1] + picks[2];

        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < minerals.length; i += 5) {
            if (sum == 0) {
                break;
            }

            int tired = 0;
            int dia = 0;
            int iron = 0;
            int stone = 0;
            sum--;

            for (int j = i; j < i + 5; j++) {
                if(j == minerals.length) break;

                String type = minerals[j];
                if (type.equals("diamond")) {
                    tired += 25;
                    dia++;
                } else if (type.equals("iron")) {
                    tired += 5;
                    iron++;
                } else {
                    tired += 1;
                    stone++;
                }
            }

            //5개씩 묶어서 돌 곡괭이로 캤을 때 피로도를 구해서 list에 저장.ㄴ
            list.add(new int[]{tired, dia, iron, stone});
            //첫 번째 케이스의 경우 배열이 2개 추가된 것이다.
        }
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(Arrays.toString(list.get(i)));
//            [85, 3, 2, 0]
//            [31, 1, 1, 1]
//        }

        Collections.sort(list, (a, b) -> b[0] - a[0]);
        //최소한의 피로도를 return하기 위함.

        for (int i = 0; i < list.size(); i++) {
            int dia = list.get(i)[1];
            int iron = list.get(i)[2];
            int stone = list.get(i)[3];

            if (picks[0] > 0) { // 다이아 곡괭이로 캠
                answer += dia + iron + stone;
                picks[0]--;
            } else if (picks[1] > 0) { // 철 곡괭이로 
                answer += dia * 5 + iron + stone;
                picks[1]--;
            } else if (picks[2] > 0) {
                answer += dia * 25 + iron * 5 + stone;
                picks[2]--;
            } else {
                break;
            }
            System.out.println("a = " + answer);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{1, 3, 2}, new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"}));
        System.out.println(T.solution(new int[]{0, 1, 1}, new String[]{"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"}));
    }
}

/* 출력
12
50
*/
