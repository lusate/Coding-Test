import java.util.*;
class Main{
	public void DFS(int v){ //v가 부모
		if(v>7) return;
		else{
			//전위 순회
			System.out.println(v+" "); //부모
			DFS(v*2); //왼쪽 자식
			DFS(v*2+1); //오른쪽 자식

			//중위 순회
			DFS(v*2); //왼쪽 자식
			System.out.println(v+" "); //부모
			DFS(v*2+1); //오른쪽 자식

			//후위 순회
			DFS(v*2); //왼쪽 자식
			DFS(v*2+1); //오른쪽 자식
			System.out.println(v+" "); //부모
		}
	}
	public static void main(String[] args){
		Main T = new Main();
		T.DFS(1);
	}
}


///////////////////////////////////////////////////////////////////////////////////////////////

package 인프런_입문.BFSDFS그래프;

class Node {
    int data; // 1 ~ 7
    Node lt, rt; // 왼쪽과 오른쪽 자식 노드

    Node(int val) {
        data = val;
        lt = rt = null;
    }
}
public class 이진트리순회 {
    Node root;
    public void DFS(Node root) {
        if (root == null) { // 말단 노드까지 왔으므로 null
            return;
        } else {
            // 전위 순회
            System.out.print(root.data + " ");
            DFS(root.lt);
            DFS(root.rt);


            // 중위순회
            DFS(root.lt);
            System.out.print(root.data + " ");
            DFS(root.rt);


            // 후위순회
            DFS(root.lt);
            DFS(root.rt);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        이진트리순회 tree = new 이진트리순회();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.DFS(tree.root);
    }
}

