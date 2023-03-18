import java.util.*;
class Solution{
	HashSet<String> set;
	String[] res;
	boolean[] visit;
	public void dfs(int idx, String s, String[] user_id){
		if(idx == res.length){ //res는 banned_id의 이름들 배열
			String[] str = s.split(" ");
			// set에 저장할 문자열의 순서가 다르면 다른 문자열로 인식하기 때문에 
			// 정렬하여 뽑은 순서가 달라도 뽑은 문자열들이 같다면 같다고 생각해 주기 위함
			// 즉 str에 들어간 문자열들의 인덱스가 다르다고 해서 다른 문자열로 인식하지 않기 위해서이다.
			Arrays.sort(str);
// 			System.out.println(Arrays.toString(str));

			String newStr = "";
			for(int i=0; i<str.length; i++){
				newStr += str[i];
				// System.out.println(newStr);
			}
			set.add(newStr); //set에 넣어서 중복 없애줌.
			return;
		}

		for(int i=0; i<user_id.length; i++){
			if(visit[i] == false && user_id[i].matches(res[idx])){
				visit[i] = true;
				// frodoabc123 이처럼 문자열 추가해줄 때 띄워주지 않으면 다 붙어있게 됨.
				dfs(idx+1, s + " " + user_id[i], user_id);
				visit[i] = false;
			}
		}
	}

	public int solution(String[] user_id, String[] banned_id) {
		set = new HashSet<>();
		res = new String[banned_id.length];
		visit = new boolean[user_id.length];

		for(int i=0; i<banned_id.length; i++){
			// . 의 경우 .이 있는 위치에는 어떤 문자도 올 수 있음.
			res[i] = banned_id[i].replace("*", ".");
			// System.out.println(res[i]);
		}

		dfs(0, "", user_id);

		return set.size();
	}
	
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, 
		new String[]{"fr*d*", "abc1**"}));

		System.out.println(T.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, 
		new String[]{"*rodo", "*rodo", "******"}));

		System.out.println(T.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, 
		new String[]{"fr*d*", "*rodo", "******", "******"}));
	}
}



/* 출력
2
2
3
*/


// --------------------------------------------------------------------------------------------
  
// 다른 방법 - LinkedHashSet 사용 : 객체(데이터)를 중복 저장할 수 없지만 입력한 순서대로 데이터를 정렬
import java.util.*;
class Solution{
	Set<Set<String>> result;
	public boolean Ban(Set<String> set, String[] banned_id){
		int i=0;
		for(String user : set){
			if(!Same(user, banned_id[i++])){
				return false;
			}
		}

		return true;
	}
	public boolean Same(String a, String b){
		if(a.length() != b.length()){
			return false;
		}
		for(int i=0; i<a.length(); i++){
			if(b.charAt(i) == '*') continue;

			if(a.charAt(i) != b.charAt(i)){
				return false;
			}
		}

		return true;
	}
	public void dfs(String[] user_id, String[] banned_id, Set<String> set){
		if(set.size() == banned_id.length){
			if(Ban(set, banned_id)){
				result.add(new HashSet<>(set));
			}
			return;
		}

		for(String user : user_id){
			if(!set.contains(user)){
				set.add(user);
				dfs(user_id, banned_id, set);
				set.remove(user);
			}
		}
	}
	public int solution(String[] user_id, String[] banned_id) {
		result = new HashSet<>();
		dfs(user_id, banned_id, new LinkedHashSet<>());

		return result.size();
	}
	
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, 
		new String[]{"fr*d*", "abc1**"}));

		System.out.println(T.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, 
		new String[]{"*rodo", "*rodo", "******"}));

		System.out.println(T.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, 
		new String[]{"fr*d*", "*rodo", "******", "******"}));
	}
}



/* 출력
2
2
3
*/
