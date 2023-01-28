import java.util.*;
class Solution {
    public String solution(String[] cities, String[] roads, String[] cars, String customer){
		String answer = "";
		int n = cities.length;
		HashMap<String, Integer> map = new HashMap<>();
		for(int i=0; i<n; i++){
			map.put(cities[i], i);
		}
		// rome = 0 , busan = 1 , daegu = 2

		int[][] dist = new int[n][n];
		for(int i=0; i<n; i++){
			Arrays.fill(dist[i], Integer.MAX_VALUE);
			dist[i][i] = 0;
		}

		for(String x : roads){
			//이어지는 도시
			int a = map.get(x.split(" ")[0]);
			int b = map.get(x.split(" ")[1]);
			int c = Integer.parseInt(x.split(" ")[2]);

			dist[a][b] = c;
			dist[b][a] = c; //양방향.
		}

		for(int k=0; i<n; i++){
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					if(dist[i][j] > dist[i][k] + dist[k][j]){
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}


		ArrayList<ArrayList<int[]>> carList = new ArrayList<>();
		for(int i=0; i<n; i++){
			carList.add(new ArrayList<>());
		}

		for(String x : cars){
			int a = map.get(x.split(" ")[0]);
			int b = Integter.parseInt(x.split(" ")[1]);
			int c = Integer.parseInt(x.split(" ")[2]);

			carList.get(a).add(new int[]{b,c});
		}
		System.out.println(carList);


		int s = map.get(customer.split(" ")[0]); //customer에서 출발 도시 번호
		int e = map.get(customer.split(" ")[0]); //도착 도시 번호
		int g = Integer.parseInt(customer.split(" ")[2]);

		int minCost = Integer.MAX_VALUE;
		int num = 0;
		for(int i=0; i<n; i++){
			int dis = dist[i][s] + dist[s][e];
			if(dis >= Integer.MAX_VALUE) continue;

			int idx = lower_bound(carList.get(i), g);
			if(idx >= carList.get(i).size()) continue;
			int cost = carList.get(i).get(idx)[1];

			cost *= dis;
			if(cost < minCost){
				minCost = cost;
				num = i;
			}
			else if(cost == minCost && cities[i].compareTo(cities[num]) < 0) num = i;
		}
		
		answer = cities[num];

		return answer;
    }

	public int lower_bound(ArrayList<int[]> list, int target){
		int lt = 0;
		int rt = list.size();

		while(lt < rt){
			int mid = (lt + rt) / 2;

			if(list.get(mid)[0] < target) lt = mid+1;
			else rt = mid;
		}

		return rt;
	}

	public static void main(String args[]){
		Solution T = new Solution();
		System.out.println(T.solution(new String[]{"rome", "busan", "daegu"}, 
		new String[]{"rome busan 1", "rome daegu 1", "busan daegu 2"}, 
		new String[]{"rome 50 10", "busan 100 20", "busan 50 15", "daegu 40 8", "rome 80 14", "rome 30 8"}, 
		"busan daegu 40"));
	}
}


/* 출력
rome
busan
*/
