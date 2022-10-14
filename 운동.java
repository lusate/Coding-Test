import java.util.*;
import java.io.*;
public class Main {
    static int INF = 10000000;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int dy[][] = new int[v+1][v+1];
        for(int i=1;i<=v;i++){
            for(int j=1;j<=v;j++){
                dy[i][j] = INF; //v번 도시에서 v번 도시로 가는 거리 모두 INF로 초기화
            }
        }

        for(int i=0; i<e; i++){ //도로 개수만큼 거리 입력
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dy[a][b] = c; //일반통행도로 
        }


        //플로이드 시작
        for(int k=1;k<=v;k++){
            for(int i=1;i<=v;i++){
                for(int j=1;j<=v;j++){
                    dy[i][j] = Math.min(dy[i][j], dy[i][k] + dy[k][j]);
                }
            }
        }


        int min = Integer.MAX_VALUE;
        for(int i=1;i<=v;i++){
            for(int j=1;j<=v;j++){
                if(dy[i][j]!=INF && dy[j][i]!=INF)
                    min = Math.min(min,dy[i][j]+dy[j][i]); //최단거리 저장
            }
        }

        System.out.println(min == Integer.MAX_VALUE?-1:min);
	}
}

//플로이드 와샬

3 4
1 2 1
3 2 1
1 3 5
2 3 2
  
//답 3  
