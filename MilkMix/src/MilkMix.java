import java.io.*;
import java.util.*;

public class MilkMix {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Bucket bucketA, bucketB, bucketC;
		Scanner s = new Scanner(new File("mixmilk.in"));
		bucketA = new Bucket(s.nextInt(),s.nextInt());
		bucketB = new Bucket(s.nextInt(),s.nextInt());
		bucketC = new Bucket(s.nextInt(),s.nextInt());
		s.close();
		for (int i = 0; i < 33; i++) {
			bucketA.pour(bucketB);
			bucketB.pour(bucketC);
			bucketC.pour(bucketA);
		}
		bucketA.pour(bucketB);
		PrintWriter p = new PrintWriter("mixmilk.out");

		p.println(bucketA.getAmount());
		p.println(bucketB.getAmount());
		p.println(bucketC.getAmount());

		p.close();

	}
}
class Bucket{
	private int capacity;
	private int amount;
	Bucket (int cap, int am){
		capacity = cap;
		amount = am;
	}
	public int getCapacity() {
		return capacity;
	}
	public int getAmount() {
		return amount;
	}
	public void setCapacity(int x) {
		capacity = x;
	}
	public void setAmount(int x) {
		amount = x;
	}
	public int getEmpty() {
		return capacity-amount;
	}
	public void max() {
		amount = capacity;
	}
	
	public void increment(int val) {
		amount += val;
		//returns overflow of milk
	}
	void pour(Bucket other) {
		
		if (other.getEmpty() > this.amount) {
			other.increment(amount);
			amount = 0;
		} else {
			amount -= other.getEmpty();
			other.max();
		}
	}
	@Override
	protected void finalize() {
		//funny
	}
}
