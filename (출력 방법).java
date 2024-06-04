ArrayList<Integer> list = new ArrayList<Integer>();
list.add(10);
list.add(20);
list.add(30);

System.out.println(Arrays.deepToString(list.toArray())); // [10, 20, 30]


// -------------------------------------------------------------------------------------------------------------------------------------------------------------------

class Info implements Comparable<Info>{
	public String name;
	public int time;
	Info(String name, int time){
		this.name=name;
		this.time=time;
	}
	@Override
	public int compareTo(Info ob){
		return this.time - ob.time; //시간을 기준으로 오름차순.
	}
}


ArrayList<Info> arr = new ArrayList<>(); // 타입이 클래스로 있으면
for(Info ob : arr){
  System.out.println(ob.name + " " + ob.time);
}


// -------------------------------------------------------------------------------------------------------------------------------------------------------------------

## 그래프
ArrayList<Integer>[] graph = new ArrayList[n];
for(int i=0; i<=n; i++){
    graph[i] = new ArrayList<>();
}

for(int i=0; i<edges.length; i++){
    int a = edges[i][0];
    int b = edges[i][1];

    graph[a].add(b);
서; i++) {
    st = new StringTokenizer(br.readLine());
    int u = Integer.parseInt(st.nextToken());
    int v = Integer.parseInt(st.nextToken());

    graph[u].add(new Node(v, 1));
    graph[v].add(new Node(u, 1));
}

// --------------------------------------------------------------------------------------------------------------------------------------

// 정렬하는 방법
1. ArrayList<T>
//오름차순, 내림차순
Collections.sort(), Collections.sort(arr, Collections.reverseOrder())

2. ArrayList<T> arr = new ArrayList<>(Arrays.asList(5,3,1,4,2)); // List.sort()
// 오름차순, 내림차순
arr.sort(Comparator.naturalOrder()); , arr.sort(Comparator.reverseOrder());

3. ArrayList<int[]> list = new ArrayList<>();
list.sort((a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);


4. PriorityQueue 정렬
PriorityQueue<Time> pq = new PriorityQueue<>((a, b) -> a.end - b.end);

// --------------------------------------------------------------------------------------------------------------------------------------
/*
아스키 코드
알파벳 소문자 -> 97 ~ 122
알파벳 대문자 -> 65 ~ 90
문자 0 ~ 9 -> 48 ~ 57
*/
