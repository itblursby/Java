import kareltherobot.Directions;
import kareltherobot.Robot;
import kareltherobot.World;
import java.util.Scanner;
public class DiamondRobot implements Directions {
	public static void main(String[] args) {
		
		int size = 5;
		Scanner in = new Scanner(System.in);
		while(true) {
			System.out.println("gimme Size of diamond");
			if (in.hasNextInt()) {
				size = in.nextInt();
				break;
			}else {
				System.out.println("not a number");
				in.next();
			}
		}
		World.setSize(size*2-1, size*2-1);
		World.setVisible(true);
		World.setDelay(1);
		Robot r = new Robot(1,size,East,(size-1)*4);
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < size-1; j++) {
				r.move();
				r.turnLeft();
				r.move();
				turnRight(r);
				r.putBeeper();
			}
			r.turnLeft();
		}
	}
	static void turnRight(Robot r) {
		r.turnLeft();
		r.turnLeft();
		r.turnLeft();
	}

}
