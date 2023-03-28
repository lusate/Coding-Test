import java.util.*;
class Solution {
    boolean[] visited;
	int answer=0;
	public void DFS(String begin, String target, String[] words, int cnt){
		if(begin.equals(target)){
			answer = cnt;
		}
		for(int i=0; i<words.length; i++){
			if(visited[i]){ // 이미 쓴 단어면 넘어감
				continue;
			}

			//알파벳은 하나만 바꿀 수 있다.
			int k=0;
			for(int j=0; j<begin.length(); j++){
				if(begin.charAt(j) != words[i].charAt(j)){
					k++;
				}//words 안에 단어들을 모두 비교해서 몇 개가 다른지 찾는다.
			}
			//words[i].charAt(j) -> i가 0일 때 hot 이다.
			//charAt(0) => h, charAt(1) => o , charAt(2) => t

			//다른게 1개라면 탐색
			if(k == 1){
				visited[i] = true;
				DFS(words[i], target, words, cnt+1);
				visited[i] = false;
			}
		}
	}
	public int solution(String begin, String target, String[] words) {
		visited = new boolean[words.length];
		DFS(begin, target, words, 0);
		return answer;
	}
}
