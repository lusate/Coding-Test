import java.util.*;
public class Solution {
	public int solution(String word) {
		int answer=word.length();
		char[] ch = {'A','E','I','O','U'};
		//I는 전체에서 가운데. 따라서 I가 1563이라면 A와 I 사이에 있는 E는 1563 / 2 = 781
		int[] num = {781, 156, 31, 6, 1}; //자릿수마다 모음이 바뀔 때 몇을 +해주는지.
		//5번째라면 +1, 4번째라면 +6, 세번째라면 +31, 첫번째라면 781

		for(int i=0; i<word.length(); i++){
			for(int j=0; j<5; j++){
				if(word.charAt(i) == ch[j]){
					answer += num[i] * j;
				}
			}
		}
		return answer;
	}
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution("AAAAE"));
		System.out.println(T.solution("AAAE"));
		System.out.println(T.solution("I"));
		System.out.println(T.solution("EIO"));
	}
}


// ------------------------------------------------------------------------------------------------------------------------------------------------
	
	
import java.util.*;
class Solution {
    String[] arr;
    ArrayList<String> list;
    public void recursion(String word, String str, int L) {
        list.add(str);
        if (L == 5) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            recursion(word, str + arr[i], L + 1);
        }
    }
    public int solution(String word){
        int answer = 0;
        list = new ArrayList<>();
        arr = new String[]{"A", "E", "I", "O", "U"};

        recursion(word, "", 0);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("AAAAE"));
//        System.out.println(T.solution("AAAE"));
//        System.out.println(T.solution("I"));
//        System.out.println(T.solution("EIO"));
    }
}
