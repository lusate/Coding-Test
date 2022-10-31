import java.util.*;
class Point{
	int x, y;
	Point(int x, int y){
		this.x=x;
		this.y=y;
	}
}
class Main {
	//n이 도시 크기, m은 살아남은 피자집 개수, len은 피자집 개수
	//len 중에서 m개를 뽑음
	static int n, m, len;
	static int answer = Integer.MAX_VALUE;
	static int[] combi;
	static ArrayList<Point> hs, pz;
	public void DFS(int L, int s){ //조합
		//L은 레벨, s는 시작점
		if(L == m){
			//최소 거리를 구함.
			// for(int x : combi){ //combi 는 인덱스 번호
			// 	System.out.print(x + " ");
			// }
			// System.out.println(); 조합 구함

			int sum = 0; //도시의 피자 배달 거리.
			for(Point h : hs){
				int dis = Integer.MAX_VALUE;
				for(int i : combi){
					dis = Math.min(dis, Math.abs(h.x - pz.get(i).x) + Math.abs(h.y - pz.get(i).y));
					//좌표로 거리값 구함
				}
				sum += dis; //각 집마다 피자 배달 거리를 누적해서 합함
			}
			answer = Math.min(answer, sum);
		}
		else{
			//조합을 함
			for(int i=s; i<len; i++){ //0 ~ 5 까지 돔
				combi[L] = i; //L번째에다가 i를 저장.
				DFS(L+1, i+1);
			}
		}
	}


	public static void main(String[] args){
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		hs = new ArrayList<>(); //집 좌표를 저장.
		pz = new ArrayList<>(); //피자 좌표를 저장.
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				int tmp = sc.nextInt(); //도시 지도 정보
				//집이면 그 위치를 hs ArrayList에 저장
				if(tmp == 1) hs.add(new Point(i, j));
				//피자집이면 그 위치를 pz ArrayList에 저장
				else if(tmp == 2) pz.add(new Point(i, j));
			}
		}
		len = pz.size();
		combi = new int[m];
		T.DFS(0, 0);
		System.out.println(answer);
	}
}



/* 입력
4 4
0 1 2 0
1 0 2 1
0 2 1 2
2 0 1 2
*/

/* 출력
6
*/
