import java.util.*;
class Trie{
	Trie[] child = new Trie[26];
	int cnt; //알파벳 개수.
	int a = Character.getNumericValue('a');

	//가사에 해당하는 단어를 입력으로 받아서 Trie에 추가
	public void insert(String str){
		Trie cur = this; //현재 객체부터 시작.
		for(char ch : str.toCharArray()){
			cur.cnt++; //내려갈 때 알파벳 하나 추가.
			int idx = Character.getNumericValue(ch) - a;

			if(cur.child[idx] == null){
				cur.child[idx] = new Trie();
			}

			cur = cur.child[idx];
		}

		cur.cnt++;
	}

	//해당하는 단어가 몇 개인지 반환.
	public int search(String str){
		Trie cur = this;
		for(char ch : str.toCharArray()){
			if(ch == '?'){
				return cur.cnt;
			}

			cur = cur.child[Character.getNumericValue(ch) - a];
			if(cur == null){
				return 0;
			}
		}

		return cur.cnt;
	}
}
class Solution{
	Trie[] TrieRoot = new Trie[10000];
	Trie[] ReTrieRoot = new Trie[10000];
	public int[] solution(String[] words, String[] queries) {
		int[] answer = new int[queries.length];

		int ansIdx = 0; //0부터 시작해서 기록
		for(String str : words){
			int idx = str.length() - 1;
			if(TrieRoot[idx] == null){
				TrieRoot[idx] = new Trie();
				ReTrieRoot[idx] = new Trie();
			}

			TrieRoot[idx].insert(str);
			str = new StringBuilder(str).reverse().toString();
			ReTrieRoot[idx].insert(str);
		}

		//검색
		for(String str : queries){
			int idx = str.length() - 1;
			if(TrieRoot[idx] == null){
				answer[ansIdx++] = 0;
				continue;
			}
			//Root에 값이 있는 상태
			if(str.charAt(0) != '?'){
				answer[ansIdx++] = TrieRoot[idx].search(str);
			}
			else{
				str = new StringBuilder(str).reverse().toString();
				answer[ansIdx++] = ReTrieRoot[idx].search(str);
			}
		}

		return answer;
	}

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"}, 
		new String[]{"fro??", "????o", "fr???", "fro???", "pro?"})));
	}
}


/* 출력
[3, 2, 4, 1, 0]
*/
