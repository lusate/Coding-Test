import java.util.*;
public class Main {
	public ArrayList<Integer> solution(int N, int K, int[] arr){
		ArrayList<Integer> answer = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		int left = 0;
		for(int i=0; i<K-1; i++){ //처음에 3개
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}

		for(int right=K-1; right<N; right++){
			map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

			answer.add(map.size());
			map.put(arr[left], map.getOrDefault(arr[left], 0) - 1);
			if(map.get(arr[left]) == 0){
				map.remove(arr[left]);
			}
			left++;
		}

		return answer;
	}


    public static void main(String[] args){
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		int[] arr = new int[N];
		for(int i=0; i<N; i++){
			arr[i] = sc.nextInt();
		}

		for(int x : T.solution(N, K, arr)) System.out.print(x + " ");
	}
}
