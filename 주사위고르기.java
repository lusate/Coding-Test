import java.util.*;

public class Solution {
    static int n;
    static List<Integer> choice = new ArrayList<>();
    static int[][] dices;
    static ArrayList<Integer> arrA;
    static ArrayList<Integer> arrB;
    static int[] answer;
    static int max = Integer.MIN_VALUE;

    /**
     * 합을 구하기 위한 메서드
     * arr은 주사위 굴려서 나온 2개의 숫자를 더한 값이다.
     */
    public static void makeArr(int L, int[][] dice, int sum, List<Integer> arr) {
        if (L == n / 2) {
            arr.add(sum);
            return;
        }
        for (int i = 0; i < 6; i++) {
            int newSum = sum + dice[L][i];
            makeArr(L + 1, dice, newSum, arr);
        }
    }

    /**
     * arrA, arrB 각각에 A가 선택한 주사위의 값을 넣기 위해서 choice.contains
     *
     */
    public static void makeArrAB() {
        arrA = new ArrayList<>();
        arrB = new ArrayList<>();

        int[][] diceA = new int[n / 2][6];
        int[][] diceB = new int[n / 2][6];
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            if (choice.contains(i)) { // choice는 A가 선택한 주사위
                diceA[a] = dices[i];
                a++;
            }
            else {
                diceB[b] = dices[i];
                b++;
            }
        }

        /**
         * makeArr을 통해 arrA와 arrB에 주사위에서 나온 숫자 2개를 더한 값이 들어간다.
         * 그러면 arrA와 arrB에 각각 36개의 sum 값이 들어간다.
         */
        makeArr(0, diceA, 0, arrA);
        makeArr(0, diceB, 0, arrB);
    }

    /**
     * 이분 탐색을 통해 A의 합이 더 큰 경우를 찾아서 count
     */
    public static int calculateWinningPercentage() {
        int count = 0;
        makeArrAB();

        Collections.sort(arrB);

        for (int i = 0; i < arrA.size(); i++) {
            int number = arrA.get(i); // number는 A 주사위의 합
            int lt = 0, rt = arrB.size() - 1;
            int idx = Integer.MIN_VALUE;
            while (lt <= rt) {
                int mid = (lt + rt) / 2;
                if (arrB.get(mid) < number) { // number가 더 크므로 A가 이기는 경우
                    lt = mid + 1;
                    idx = Math.max(idx, mid);
                }
                else{
                    rt = mid - 1;
                }
            }

            if (idx != Integer.MIN_VALUE) {
                count += idx + 1;
            }
        }
        return count;
    }
    public void dfs(int L, int start) { // A가 이길 수 있는 경우의 수
        if (L == n / 2) { // A가 n/2개 선택했을 때
            int winning = calculateWinningPercentage();
            System.out.println(choice.get(0) + ", " + choice.get(1) + " => " + winning);

            if (max < winning) {
                max = winning;
                for (int i = 0; i < choice.size(); i++) {
                    answer[i] = choice.get(i) + 1; // 주사위 번호는 1부터이므로 1 더해줌.
                }
            }
            return;
        }

        for (int i = start; i < n; i++) {
            choice.add(i);
            dfs(L + 1, i + 1);
            choice.remove(choice.size() - 1);
        }
    }
    public int[] solution(int[][] dice) {
        n = dice.length;
        dices = dice;
        answer = new int[n / 2];
        dfs(0, 0);

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new int[][]{{1, 2, 3, 4, 5, 6}, {3, 3, 3, 3, 4, 4}, {1, 3, 3, 4, 4, 4}, {1, 1, 4, 4, 5, 5}})));
//        System.out.println(Arrays.toString(T.solution(new int[][]{{1, 2, 3, 4, 5, 6}, {2, 2, 4, 4, 6, 6}})));
//        System.out.println(Arrays.toString(T.solution(new int[][]{{40, 41, 42, 43, 44, 45}, {43, 43, 42, 42, 41, 41}, {1, 1, 80, 80, 80, 80}, {70, 70, 1, 1, 70, 70}})));
    }
}


/*
(1) n / 2개의 주사위를 선택하는 조합을 구한다.
(2) A의 주사위로 얻을 수 있는 점수를 구한다.
(3) B의 주사위로 얻을 수 있는 점수를 구한다.
(4) A의 몇 번 이기는지 구한다.
(5) 현재 주사위 번호가 0부터 시작하기 때문에 1씩 더해준다.
(6) n / 2개의 주사위를 모두 골랐을 경우 주사위 번호 조합을 리스트에 추가한다.
(7) B가 가져간 나머지 n / 2개의 주사위 번호를 가져온다.
(8) A가 가져간 주사위 번호를 true 처리한다.
(9) n / 2개의 주사위를 모두 굴렸을 경우 나오는 점수를 리스트에 추가한다.
(10) 이분 탐색하여 A의 점수로 이길 수 있는 B의 점수의 개수를 구한다.
 */
