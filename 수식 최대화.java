import java.util.*;

class Solution {
    long answer;

    char[] prior = {'+', '-', '*'};
    boolean[] check = new boolean[3];
    ArrayList<Long> nums;
    ArrayList<Character> ops;

    public long calculate(long num1, long num2, char op) {
        if (op == '+') {
            return num1 + num2;
        }
        else if (op == '-') {
            return num1 - num2;
        }
        else{
            return num1 * num2;
        }
    }

    public void dfs(int count, char[] p){
        if(count == 3){
            ArrayList<Long> cNums = new ArrayList<>(nums);
            ArrayList<Character> cOps = new ArrayList<>(ops);

            for(int i=0;i<p.length;i++){
                for(int j=0; j< cOps.size(); j++){
                    if(p[i] == cOps.get(j)){
                        Long res = calculate(cNums.remove(j), cNums.remove(j), p[i]);
                        cNums.add(j, res);
                        cOps.remove(j);
                        j--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(cNums.get(0)));
            return;
        }

        for(int i=0; i< 3; i++){
            if(!check[i]){
                check[i] = true;
                p[count] = prior[i];
                dfs(count+1,p);
                check[i] = false;
            }
        }
    }

    public long solution(String expression) {
        answer = 0;
        nums = new ArrayList<>();
        ops = new ArrayList<>();

        String num="";
        for(int i=0;i<expression.length();i++){
            if(expression.charAt(i) >= '0' && expression.charAt(i) <= '9'){
                num += expression.charAt(i);
            }else{
                nums.add(Long.parseLong(num));
                num = "";
                ops.add(expression.charAt(i));
            }
        }
        nums.add(Long.parseLong(num));
        dfs(0, new char[3]);

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("100-200*300-500+20"));
        System.out.println(T.solution("50*6-3*2"));
    }
}


/* 출력
60420
300
*/
