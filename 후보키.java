import java.util.*;
class Solution{
	//비트를 담는 list.
	List<Integer> res = new ArrayList<>();

	//부분 집합 여부. 즉 최소성 확인.
	public boolean check(int i) {
		for (int j : res) {
			// i가 j의 부분집합인지에 대한 여부를 묻는 것.
			if ((i & j) == j) return false;
		}
		return true;
	}

	public int solution(String[][] relation) {
		int answer = 0;
		int n = relation.length;
		int m = relation[0].length;

		int cnt = 1 << m; //부분 집합 개수.
		for (int i = 0; i < cnt; i++) {
			//유일성을 위해 set
			HashSet<String> set = new HashSet<>();
			//배열의 전체를 도는 for loop
			for(int j = 0; j < n; j++){
				String tmp = "";
				//배열의 요소를 도는 for loop
				for(int k = 0; k < m; k++){
					// 1 << k 하면 k번째 비트가 켜짐.
					// i의 k번째 비트가 켜져있는지 확인.
					if((i & 1 << k) != 0){ //0이 아니라면 k가 포함되어 있어서 k를 사용할 수 있다.
						tmp += (relation[j][k]);
					}
				}
				set.add(tmp);
			}
			//유일성을 만족하고 최소성을 만족한다면 
			if(set.size() == n && check(i)){
				res.add(i);
			}
		}
		answer = res.size();
		return answer;
	}

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new String[][]{{"100","ryan","music","2"}, 
		{"200","apeach","math","2"}, {"300","tube","computer","3"}, {"400","con","computer","4"}, 
		{"500","muzi","music","3"}, {"600","apeach","music","2"}}));
	}
}


/* 출력
2
*/
