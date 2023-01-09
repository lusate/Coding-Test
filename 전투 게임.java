import java.util.*;
class Info implements Comparable<Info>{
	int num, at;
	char c;
	Info(int num, char c, int at){
		this.num=num;
		this.c=c;
		this.at=at;
	}
	@Override
	public int compareTo(Info ob){
		return this.at - ob.at;
	}
}
class Main{
	private static int[] solution(String[] students){
		HashMap<Character, Integer> map = new HashMap<>();
		ArrayList<Info> arr = new ArrayList<>();
		int[] answer = new int[students.length];
		
		for(int i=0; i<students.length; i++){ //학생들 번호를 넣기 위해.
			Character s = students[i].split(" ")[0].charAt(0);
			int num = Integer.parseInt(students[i].split(" ")[1]);

			arr.add(new Info(i, s, num));
		}

		Collections.sort(arr);

		int j=0, sum = 0;
		for(int i=1; i<students.length; i++){
			for( ; j<students.length; j++){ //j는 초기화하지 않는다.
				
				if(arr.get(j).at < arr.get(i).at){ //잡힌다면
					sum += arr.get(j).at; //팀 상관없이 at가 작으면 그냥 다 더해서 누적.
					char x = arr.get(j).c;

					//map에는 학생의 at를 저장.
					map.put(x, map.getOrDefault(x, 0)+arr.get(j).at);
				}

				else break;
			}

			answer[arr.get(i).num] = sum - map.getOrDefault(arr.get(i).c, 0);
			//map.getOrDefault(arr.get(i).c, 0); 자기 팀의 값.
		}
		//System.out.println(map);
		//{a=10, b=12, c=11, e=12}

		return answer;
	}
	
	public static void main(String[] args){
		System.out.println(Arrays.toString(solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));
		//System.out.println(solution(new int[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"}));
	}
}


/* 출력
[35, 21, 0, 10, 21]
[35, 21, 0, 10, 38, 59, 21]
*/
