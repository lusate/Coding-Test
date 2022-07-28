import java.util.*;
class Main {
	int[] unf;
	public int Find(int v){
		if(v == unf[v]) return v;
		else return unf[v] = Find(unf[v]);
	}
	public void Union(int a, int b){
		int fa = Find(a);
		int fb = Find(b);
		if(fa != fb) unf[fa] = fb;
	}

    public String solution(int n, int[][] friend, int s1, int s2) {
		unf = new int[n+1];
		for(int i=1; i<=n; i++){
			unf[i] = i;
		}
		for(int[] x : friend){
			Union(x[0], x[1]);
		}
		int fa = Find(s1);
		int fb = Find(s2);
		System.out.println(fa);
		System.out.println(fb);
		if(fa == fb) return "YES";
		else return "NO";

    }
	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(9, new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 5}, {6, 7}, {7, 8}, {8, 9}}, 6, 9));
	}
}
