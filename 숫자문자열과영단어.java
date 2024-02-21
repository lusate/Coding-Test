package 프로그래머스;

public class 숫자문자열과영단어 {
    static String[] words = {"zero","one", "two", "three",
            "four", "five", "six", "seven", "eight", "nine"};
    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < 10; i++) {
            s = s.replace(words[i], Integer.toString(i));
            System.out.println(s);
        }

        answer = Integer.parseInt(s);
        return answer;
    }

    public static void main(String[] args) {
        숫자문자열과영단어 T = new 숫자문자열과영단어();
        System.out.println(T.solution("one4seveneight"));
//        System.out.println(T.solution("23four5six7"));
//        System.out.println(T.solution("2three45sixseven"));
//        System.out.println(T.solution("123"));
    }
}
