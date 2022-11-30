import java.util.*;
class Main {
	static int n,m=0;
	private static boolean check(String s){ //숫자인지 문자인지 판단
		for(int i=0; i<s.length(); i++){
			if(!Character.isDigit(s.charAt(i))){ //숫자가 아니면
				return false;
			}
			
		}
		return true; //숫자면
	}
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Integer> map1 = new HashMap<>();
		HashMap<Integer, String> map2 = new HashMap<>();

		n = sc.nextInt();
		m = sc.nextInt();

		for(int i=1; i<=n; i++){
			String s = sc.next();
			map1.put(s, i);
			map2.put(i, s);
		}

		for(int i=1; i<=m; i++){
			String question = sc.next();
			if(check(question)){ //숫자라면
				System.out.println(map2.get(Integer.valueOf(question))); //문자 출력
				//System.out.println("숫자" + map2.get(Integer.valueOf(question))); //문자 출력
			}
			else{ //문자라면
				System.out.println(map1.get(question));
				//System.out.println("문자" + map1.get(question));
			}
		}
    }
}


/* 입력
26 5
Bulbasaur
Ivysaur
Venusaur
Charmander
Charmeleon
Charizard
Squirtle
Wartortle
Blastoise
Caterpie
Metapod
Butterfree
Weedle
Kakuna
Beedrill
Pidgey
Pidgeotto
Pidgeot
Rattata
Raticate
Spearow
Fearow
Ekans
Arbok
Pikachu
Raichu
25
Raichu
3
Pidgey
Kakuna
*/

/* 출력
Pikachu
26
Venusaur
16
14
*/
