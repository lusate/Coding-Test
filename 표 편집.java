import java.util.*;
class Solution{
	public String solution(int n, int k, String[] cmd) {
		//삭제된 것을 복구할 때는 stack에 저장했었던 것을 위에서부터 빼면 됨.
		Stack<Integer> stack = new Stack<>();

		int table = n;
		for(String x : cmd){
			char c = ' ';
			int num = 0;
			if(x.contains(" ")){
				c = x.split(" ")[0].charAt(0);
				num = Integer.parseInt(x.split(" ")[1]);
			}
			else c = x.charAt(0);

			//stack에 들어가는 것들은 모두 인덱스가 아닌 이름들.
			if(c == 'D'){
				k += num;
			}
			else if(c == 'U'){
				k -= num;
			}
			else if(c == 'C'){
				stack.push(k);
				table--;

				// 마지막 인덱스의 번호가 없어지면 k를 -1해서 교체해줌으로써 table의 마지막 인덱스가 되도록 해줌.
				if(k == table) k--;
			}
			else if(c == 'Z'){
				table++;
				if(stack.pop() <= k) k++;
				//0 1 2 4 에서 3이 최근에 없어졌다 가정했을 때 k가 4이면 한 칸 밀려서 5가 됨.
			}
		}

		StringBuilder builder = new StringBuilder();
        for(int i=0; i<table; i++)
            builder.append("O");
        while(!stack.isEmpty())
            builder.insert(stack.pop(), "X");
        String answer=builder.toString();
        
		return answer;
		
    }
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(8, 2, new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z"}));
		System.out.println(T.solution(8, 2, new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"}));
	}
}


/* 출력
OOOOXOOO
OOXOXOOO
ArrayList 사용하면 시간 초과 생겨서 StringBuilder 사용
*/
