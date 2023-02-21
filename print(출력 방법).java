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
