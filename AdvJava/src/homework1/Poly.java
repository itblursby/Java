package homework1;

public class Poly {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("bruh");
		Animal bessie = new Cow(3);
		Animal bella = new Horse(5);
	}

}
class Cow implements Comparable<Cow>,Animal{
	int position;
	Cow(int pos){
		this.position = pos;
	}
	@Override
	public int compareTo(Cow o) {
		return this.position - o.position;
	}
	@Override
	public void move(int position) {
		this.position = position;
	}
	@Override
	public void talk() {
		System.out.println("mooooo");
	}
}
class Horse implements Comparable<Horse>,Animal{
	int position;
	Horse(int pos){
		position = pos;
	}
	@Override
	public int compareTo(Horse o) {
		
		return this.position - o.position;
	}
	@Override
	public void move(int position) {
		this.position = position;
	}
	@Override
	public void talk() {
		System.out.println("neighhhh");
	}
	
}
