import java.util.*;
class Main {
    public boolean solution(int n) {
		if(n <= 0) return false;
		if(n == 1) return true;

		while(n != 1){
			if((n >> 2) * 4 != n){
				return false;
			}
			n = n >> 2;
		}//비트 연산자 16 (1 0 0 0 0) 에서 2칸 오른쪽으로 이동시키면
		//0100 으로 4가 된다. 그 다음은 1 그래서 위에서 정한대로 true
		return true;
	}

	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(16));
		System.out.println(T.solution(5));
	}
}
