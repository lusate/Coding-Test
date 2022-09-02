import java.util.*;
public class Main {
	//회문했을 때 동일하지 않은 부분을 빼내야 한다.
	//abcabbakcba 라고 한다면 abbak 부분을 substring() 함수를 사용해 빼내야한다.
	//그래서 빼내기 전에 양쪽 left와 right 부분이 같은지 다른지 확인하는 함수를 만든다.
	public Boolean isPalindrome(String s){
		int left = 0;
		int right = s.length()-1;

		while(left < right){
			if(s.charAt(left) != s.charAt(right)){
				return false;
			}
			else{
				left++;
				right--;
			}
		}
		return true;
	}

	//여기서 양쪽 알파벳이 다른 부분을 뽑아냄
	public String solution(String s){
		String answer="YES";
		int left=0;
		int right=s.length()-1;

		while(left < right){
			if(s.charAt(left) != s.charAt(right)){
				//substring 했을 때 left ~ right-1 로 잘라낸다.
				String str1 = s.substring(left, right); //같지 않은 부분 잘라냄
				String str2 = s.substring(left+1, right+1);
				
				//뽑아낸 str1, str2 두 문자열이 isPalindrome으로 양쪽 알파벳이 서로 같지 않다면
				//NO를  리턴
				if(!isPalindrome(str1) && !isPalindrome(str2)){
                    return "NO";
                }
                else break;
            }
			left++;
			right--;
		}
		return answer;
	}
	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution("abcbdcba"));
		System.out.println(T.solution("abcabbakcba"));
		System.out.println(T.solution("abcacbakcba"));
	}
}


//답
//YES
//YES
//NO
