package 프로그래머스;

import java.util.*;

public class 뉴스_클러스터링 {
    public int solution(String str1, String str2) {
        int answer = 0;

        // 모두 대문자 + 공백 없앰.
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        ArrayList<String> first = new ArrayList<>();
        ArrayList<String> second = new ArrayList<>();

        ArrayList<String> union = new ArrayList<>();
        ArrayList<String> intersection = new ArrayList<>();

        for(int i = 0; i < str1.length()-1; i++) {
            char a = str1.charAt(i);
            char b = str1.charAt(i+1);

            // 공백 포함 된 문자열은 넣지 않도록 함.
            if(Character.isLetter(a) && Character.isLetter(b)) {
                first.add(String.valueOf(a) + String.valueOf(b));
            }
        }

        for(int i = 0; i < str2.length()-1; i++) {
            char a = str2.charAt(i);
            char b = str2.charAt(i+1);

            if(Character.isLetter(a) && Character.isLetter(b)) {
                second.add(String.valueOf(a) + String.valueOf(b));
            }
        }

        // 중복 원소 처리를 위해 두 집합 정렬
        Collections.sort(first);
        Collections.sort(second);

        for (String s : first) {
            if (second.remove(s)) { // second에 first의 s가 포함되면 제거
                intersection.add(s);
            }
            union.add(s);
        }
        for (String s : second) {
            union.add(s);
        }
        
        double jakard = 0;
        if (union.isEmpty()) {
            jakard = 1;
        } else {
            jakard = (double) intersection.size() / (double) union.size();
        }
        answer = (int) (jakard * 65536);

        return answer;
        // if 문 안에 remove() 들어가 있는 방식 알아두자.
    }

    public static void main(String[] args) {
        뉴스_클러스터링 T = new 뉴스_클러스터링();
        System.out.println(T.solution("FRANCE", "french"));
        System.out.println(T.solution("handshake", "shake hands"));
        System.out.println(T.solution("aa1+aa2", "AAAA12"));
        System.out.println(T.solution("E=M*C^2", "e=m*c^2"));
    }
}

// 정답
/*
16384
65536
43690
65536
*/
