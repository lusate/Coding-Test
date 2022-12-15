import java.util.*;

class Main {
	//moeum : 모음 개수, jaeum : 자음 개수
	static int L,C, moeum, jaeum;
	static char[] str;
	private static void dfs(int length, int index, String s){
		if(length == L){
			moeum = 0;
			jaeum = 0;
			for(int i=0; i<L; i++){
				//str 배열에 aeiou 모음이 있으면 모음 개수 카운트
				if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u'){
					moeum++;
				}
				else jaeum++;
			}
			
			//모음 개수 한개, 자음 개수 2개 이상이면 암호 출력.
			if(moeum >= 1 && jaeum >= 2){
				System.out.println(s);
			}
		}

		else{
			//문자열이 입력한 문자 개수 L이 아니라면 길이 늘리고 문자를 더해준다.
			for(int i=index; i<C; i++){
				dfs(length+1, i+1, s + str[i]);
			}
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		str = new char[C];

		for(int i=0; i<C; i++){
			str[i] = sc.next().charAt(0);
		}

		Arrays.sort(str);
		dfs(0, 0, "");
	}
}



/* 입력
4 6
a t c i s w
*/


/* 출력
acis
acit
aciw
acst
acsw
actw
aist
aisw
aitw
astw
cist
cisw
citw
istw
*/
