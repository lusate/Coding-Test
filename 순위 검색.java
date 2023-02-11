import java.util.*;
class Solution {
	public int[] solution(String[] info, String[] query) {
		HashMap<String, ArrayList<Integer>> map = new HashMap<>();

		for(String x : info){
			String[] data = x.split(" ");
			String[] lans = {data[0], "-"};
			String[] jobs = {data[1], "-"};
			String[] careers = {data[2], "-"};
			String[] foods = {data[3], "-"};
			int score = Integer.parseInt(data[4]);

			for(String lan : lans){
				for(String job : jobs){
					for(String career : careers){
						for(String food : foods){
							String[] keyData = {lan, job, career, food};
							String key = String.join(" ", keyData);
							ArrayList<Integer> arr = map.getOrDefault(key, new ArrayList<Integer>());

							arr.add(score);
							map.put(key, arr);
						}
					}
				}
			}
		}
		// System.out.println(map);
		
		//이분 탐색 해야하므로 Value를 정렬해야 한다.
		for(ArrayList<Integer> arr : map.values()){
			arr.sort(null); // value들을 정렬
		}

		
		int[] answer = new int[query.length];
		int idx = 0;
		for(String x : query){
			String[] data = x.split(" and ");
			int target = Integer.parseInt(data[3].split(" ")[1]);
			data[3] = data[3].split(" ")[0]; // "pizza 100" 에서 다시 pizza로 바꿈.

			String key = String.join(" ", data);
			// System.out.println(key);
			
			if(map.containsKey(key)){
				//arr은 map에서 설정한 score가 들어있음.
				ArrayList<Integer> arr = map.get(key);
				
				//여기서 lower-bound 시작
				int lt = 0;
				int rt = arr.size();
				while(lt < rt){
					int mid = (rt + lt) / 2;
					if(arr.get(mid) >= target){
						rt = mid;
					}
					else lt = mid+1;
				}

				//mid를 찾았으면 전체 사이즈에서 lt를 빼주면 끝
				answer[idx] = arr.size() - lt;
			}
			idx++;
		}

        return answer;
    }

	public static void main(String args[]){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(new String[]{"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"}, 
        new String[]{"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"})));
	}
}


/* 출력
[1,1,1,1,2,4]
*/


//java backend junior pizza -> Key , 150 -> Value
//-도 반영이 되도록 함.  -를 모두 반영을 한다면 총 16개의 조합이 나옴.
//그러면 Key가 ---chicken 이라 한다면 Value는 [150, 210, 80, 50]
//---- 이면 Value는 [50, 80, 150, 150, 210, 260]
//여기서 150 이상이라 하면 이분 탐색(lower-bound)으로 전체 사이즈에서 해당 인덱스 값을 빼줘서 6 - 2.
