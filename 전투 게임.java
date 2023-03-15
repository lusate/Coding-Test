import java.util.*;
class Info implements Comparable<Info>{
	int num;
	char team;
	int at;
	Info(int num, char team, int at){
		this.num=num;
		this.team=team;
		this.at=at;
	}
	@Override
	public int compareTo(Info ob){
		return this.at - ob.at;
	}
}
class Solution{
	public int[] solution(String[] students){
		int n = students.length;
		int[] answer = new int[n];
		HashMap<Character, Integer> map = new HashMap<>();
		ArrayList<Info> arr = new ArrayList<>();

		for(int i=0; i<n; i++){ //학생들 번호를 넣기 위해.
			char c = students[i].split(" ")[0].charAt(0); //문자로
			int st = Integer.parseInt(students[i].split(" ")[1]); //숫자로
			arr.add(new Info(i, c, st));
		}
		
		Collections.sort(arr);

		/*
		 * 2  a  10   j 시작    	0으로 더할 게 없으므로 패스
		 * 3  c  11	  i 시작
		 * 1  b  12
		 * 4  e  12
		 * 0  a  20
		 */

		int sum=0, j = 0;
		for(int i=1; i<n; i++){
			for( ; j<n; j++){
				if(arr.get(i).at > arr.get(j).at){
					sum += arr.get(j).at;
					char x = arr.get(j).team;
					//sum에 더했던 학생들의 at를 저장
					map.put(x, map.getOrDefault(x, 0) + arr.get(j).at);
				}

				else break; //잡지 못하면 at를 더하지 못하므로 빠져나옴.
			}
			//{a=10, b=12, c=11, e=12}
			answer[arr.get(i).num] = sum - map.getOrDefault(arr.get(i).team, 0);
			//answer[3] = 10 - 0
			//answer[1] = 21 - 0
			//answer[2] = 0
			//answer[4] = 21
			//answer[0] = 45 - 10
		}
		
		return answer;
	}
	
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(Arrays.toString(solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"}))));
		System.out.println(T.solution(Arrays.toString(solution(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"}))));
	}
}


/* 출력
[35, 21, 0, 10, 21]
[35, 21, 0, 10, 38, 59, 21]
*/
