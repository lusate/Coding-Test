import java.util.*;
class Info implements Comparable<Info>{
	int x, y, num;
	Info(int x, int y, int num){
		this.x=x;
		this.y=y;
		this.num=num;
	}
	Info left;
	Info right;

	@Override
	public int compareTo(Info ob){
		//x값으로 오름차순할 건데 y값이 같으면 x로 오름차순
		if(this.y == ob.y) return this.x-ob.x;
		else return ob.y-this.y;
	}
}
class Solution {
	int[][] answer;
	int idx;

	//노드 추가.
	public void addNode(Info parent, Info child){
		if(parent.x > child.x){ //부모 쪽 x의 값이 더 크면 왼쪽 노드로 삽입.
			if(parent.left == null){ //왼쪽 자식 노드가 비어있으면 왼쪽 노드로 삽입.
				parent.left = child;
			}
			else{ //비어있지 않다면 그 노드를 parent로 해서 addNode 하여 자식 노드 추가.
				addNode(parent.left, child);
			}
		}

		else{
			if(parent.right == null){
				parent.right = child;
			}
			else{
				addNode(parent.right, child);
			}
		}
	}

	public void preorder(Info root){
		if(root != null){ //null이면 값이 없으므로 넘어감.
			answer[0][idx++] = root.num;
			preorder(root.left);
			preorder(root.right);
		}
	}

	public void postorder(Info root){
		if(root != null){
			postorder(root.left);
			postorder(root.right);
			answer[1][idx++] = root.num;
		}
	}
    public int[][] solution(int[][] nodeinfo) {
		//x값을 기준으로 오름차순하여 트리를 생성.
		//노드 번호로 트리를 생성하는데 여기서 x값이 root의 값보다 작으면 왼쪽 크면 오른쪽으로 배치.
		//ex) 노드 번호 7의 x값은 8 , 다음 노드 번호 4의 x값은 3이므로 왼쪽으로 배치, 노드 번호 2의 x값은 11로 8보다 커서 오른쪽으로 배치.
		
		int n = nodeinfo.length;
		ArrayList<Info> arr = new ArrayList<>();
		for(int i=0; i<n; i++){
			arr.add(new Info(nodeinfo[i][0], nodeinfo[i][1], i+1));
		}
		Collections.sort(arr);

		Info root = arr.get(0);  //root는 첫 번째 인덱스 값.
		for(int i=1; i<n; i++){
			addNode(root, arr.get(i));  //노드 추가.
		}


		answer = new int[2][n];

		idx = 0;
		preorder(root);  //전위 순회
		idx = 0;
		postorder(root);  //후위 순회

        return answer;
    }

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.deepToString(T.solution(new int[][]{{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, 
		{1, 3}, {8, 6}, {7, 2}, {2, 2}})));
		
	}
}


/* 출력
[[7,4,6,9,1,8,5,2,3],[9,6,5,8,1,4,3,2,7]]
*/
