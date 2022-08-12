import java.util.*;
public class Main {
	boolean[] visited;
    ArrayList<String> result = new ArrayList<>();
	//path : 현재 진행된 경로
    public void DFS(String[][] tickets,String start,String path,int count){
        if(count == tickets.length){ //count는 지나온 경로 개수로
            result.add(path);//개수가 ticket의 개수와 같아지면 현재 경로 추가
            return;
        }
        for(int i = 0; i< tickets.length;i++){
			//방문하지 않았는데 tickets의 0번째가 시작을 가리키는 문자열과 같으면
            if(!visited[i] && tickets[i][0].equals(start)){
                visited[i] = true;
                DFS(tickets,tickets[i][1],path + " " + tickets[i][1],count+1);
				//count의 개수는 1 증가시키고 시작점은 tickets의 원소의 1번째로 바꾼다
                visited[i] = false;
            }
        }
    }

    public String[] solution(String[][] tickets){
		String[] answer = {};
        visited = new boolean[tickets.length];
        DFS(tickets,"ICN","ICN",0);
        Collections.sort(result);
		//만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
        answer = result.get(0).split(" ");
        return answer;
    }
	public static void main(String[] args){
		Main T = new Main();
		String[][] tickets1 = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		String[][] tickets2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};

		for(String x : T.solution(tickets1)){
			System.out.print(x + " ");
		}
		System.out.println();
		for(String x : T.solution(tickets2)){
			System.out.print(x + " ");
		}
	}
}
