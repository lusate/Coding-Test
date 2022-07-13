//충돌하는 수열
import java.util.*;
class Main{
	public ArrayList<Integer> solution(int[] nums){
		ArrayList<Integer> answer = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();

		for(int x : nums){
			if(x > 0){
				stack.push(x);
			}
			else{ //x < 0
				//스택이 비어있거나 스택 상단이 음수면
				if(stack.empty() || stack.peek() < 0){
					stack.push(x);
				}
				else{ //스택이 비어있지 않고, 스택 상단이 양수면
					boolean flag = false;
					//스택이 비어있지 않고, 스택 상단이 양수인 동안
					while(!stack.empty() && stack.peek() > 0){
						int left = stack.pop();
						System.out.println(left);
						//x 절댓값이 left 보다 크면 flag는 true하고 다시 반복
						if(Math.abs(x) > left){
							flag = true;
							//System.out.println(x);
							//[-2,-1,2,1,-3,2] 일 때 x는 -3, -3 이고
							//left = 1,2
						}
						else if(Math.abs(x) == left){
							//같은 경우로 둘 다 push하지 않고 끝냄
							flag = false;
							break;
						}
						else{ //left가 큰 경우로 left를 push하고 flag는 false로 push(x)를 하지 않는다.
							//그리고 반복 끝냄
							stack.push(left);
							flag = false;
							break;
							//left가 더 크면 반복 중지하고 push(x)
						}
					}

					if(flag){//위에서 Math.abs(x) > left 인 경우로 flag가 true이다
						//그러므로 push(x)를 한다.
						stack.push(x);
					}
				}
			}
		}
		for(int x : stack){
			answer.add(x);
		}
		return answer;
	}
	public static void main(String[] args){
		Main T = new Main();
		//int[] arr1 = new int[]{3,5,-2,-5};
		//System.out.println(T.solution(arr1));
		//int[] arr2 = new int[]{-2,2,-1,1,-3,2};
		//System.out.println(T.solution(arr2));
		int[] arr3 = new int[]{-2,-1,2,1,-3,2};
		System.out.println(T.solution(arr3));
	}
}
