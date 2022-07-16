import java.util.*;
class Main{	
	public ArrayList<Character> solution(String[] words){
		HashMap<Character, Integer> map = new HashMap<>();
		ArrayList<Character> answer = new ArrayList<>();

		for(char x : words[0].toCharArray()){ //첫 번째 문자열(steasue)만 센 것이다.
			map.put(x, map.getOrDefault(x, 0)+1);
		}
		//System.out.println("map: " + map);
		//출력하면 map: {a=1, s=2, t=1, e=2, u=1}
		
		//words.length = 3 단어가 3개 여서
		for(int i=1; i<words.length; i++){
			//tmp에는 문자열 3개의 HashMap이 모두 들어가도록
			HashMap<Character, Integer> tmp = new HashMap<>();
			for(char x : words[i].toCharArray()){
				//System.out.print(x);  steasue sasseysu kseseas
				//System.out.print(map.get(x)); 2121212 21222null21 null222212
				//System.out.print(map.getOrDefault(x, 0));
				//2121212 21222021 0222212

				if(map.getOrDefault(x, 0) > 0){
					map.put(x, map.get(x) - 1);
					//System.out.println(map);
					//-1 을 안 하면 [a, s, s, s, e, e] 이 된다
					
					tmp.put(x, tmp.getOrDefault(x, 0)+1);
					//System.out.println(tmp);
				}
			}
			map = new HashMap<Character, Integer>(tmp);
			//각 문자열에서 사용하지 않는 문자를 없애고 중복되는 문자 출력을 없애기 위해서 두 HashMap을 교집합함
		}
		
		for(char key:map.keySet()){
			for(int i=0; i<map.get(key); i++){
				answer.add(key);
			}
		}
		return answer;
	}
	public static void main (String[] args){
		Main T = new Main();
		String[] arr1 = new String[]{"steasue", "sasseysu", "kseseas"};
		System.out.println(T.solution(arr1));
		//String[] arr2 = new String[]{"ackky", "kabck", "yokkcs"};
		//System.out.println(T.solution(arr2));
		//String[] arr3 = new String[]{"longlong", "longtong", "longbig"};
		//System.out.println(T.solution(arr3));
	}
}

//get 메소드를 이용하면 value 값을 얻을 수 있다
//그런데 map의 key에 해당하는 value가 없을 경우 get 메소드를 사용하면 null이 리턴된다
//그래서 null 대신 디폴트 값을 얻고 싶은 경우에 getOrDefault() 를 사용한다.
