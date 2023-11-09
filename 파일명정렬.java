package 프로그래머스문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class File implements Comparable<File> {
    int num; // 들어오는 순서
    String head = "";
    String number = "";
    String tail = "";

    File(String str) {
        int idx = 0;
        for (; idx < str.length(); idx++) {
            char ch = str.charAt(idx);
            if(ch >= '0' && ch <= '9') break; //숫자 만나면
            head += ch;
        }
        for (; idx < str.length(); idx++) {
            char ch = str.charAt(idx);
            if(ch < '0' || ch > '9') { //문자 만나면
                break;
            }
            number += ch;
        }
        for (; idx < str.length(); idx++) {
            char ch = str.charAt(idx);
            tail += ch;
        }
    }

    @Override
    public int compareTo(File o) {
        String str1 = this.head.toLowerCase();
        String str2 = o.head.toLowerCase();
        if (str1.equals(str2)) { // head가 같은 경우
            int num1 = Integer.parseInt(this.number);
            int num2 = Integer.parseInt(o.number);
            if (num1 == num2) { // 두 파일의 HEAD 부분과, NUMBER의 숫자도 같을 경우, 원래 입력에 주어진 순서를 유지한다.
                return this.num - o.num;
            }
            return num1 - num2;
        }
        return str1.compareTo(str2);
    }
}
public class 파일명정렬 {
    public String[] solution(String[] files) {
        String[] answer;
        ArrayList<File> result = new ArrayList<>();

        for (int i = 0; i < files.length; i++) {
            result.add(new File(files[i]));
        }
        Collections.sort(result);

        answer = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i).head + result.get(i).number + result.get(i).tail;
        }

        return answer;
    }

    public static void main(String[] args) {
        파일명정렬 T = new 파일명정렬();
        System.out.println(Arrays.toString(T.solution(new String[]{
                "img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})));
        /*System.out.println(Arrays.toString(T.solution(new String[]{
                "F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"})));*/
    }
}


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


package 프로그래머스문제;

import java.util.*;

public class 파일명정렬 {
    public String[] solution(String[] files) {
        String[] answer = {};

        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 숫자 앞부분을 잘라서 head 생성
                String head1 = o1.split("[0-9]")[0];
                String head2 = o2.split("[0-9]")[0];

                // compareTo를 사용한 비교를 위해서는 모두 소문자로 변경 후 비교
                // compareTo는 문자열의 비교, 숫자의 비교 두 방식이 존재한다.
                // 문자의 비교 같은 경우 같다(0), 그외의 숫자.
                // 숫자의 비교 같은 경우 왼쪽이 크다(1), 같다(0), 왼쪽이 작다(-1)
                int result = head1.toLowerCase().compareTo(head2.toLowerCase());
                if (result == 0) { // 같은 문자일 경우 숫자로 비교
                    result = convertNum(o1, head1) - convertNum(o2, head2);
                }
                return result;
            }
        });
        return files;
    }

    public int convertNum(String str, String head) {
        str = str.substring(head.length()); // head 길이만큼 잘라서 숫자부터 시작하게 만들어줌
        String result = "";
        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch) && result.length() < 5){
                result += ch;
            } else break;
        }
        return Integer.parseInt(result);

    }

    public static void main(String[] args) {
        파일명정렬 T = new 파일명정렬();
        System.out.println(Arrays.toString(T.solution(new String[]{
                "img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})));
        /*System.out.println(Arrays.toString(T.solution(new String[]{
                "F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"})));*/
    }
}
