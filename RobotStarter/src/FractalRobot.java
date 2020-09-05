//import java.awt.Color;
import kareltherobot.Directions;
import kareltherobot.Robot;
import kareltherobot.World;
public class FractalRobot implements Directions{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Color red = new Color(255,255,0,0);
		//World.setStreetColor(java.awt.Color.black);

		int ITERATIONS = 5;
		int length = 1 << (ITERATIONS-1);
		System.out.println(length);
		World.setDelay(1);
		World.setSize(length << 1, length << 1);
		World.setVisible(true);
		Robot drawer = new Robot(1,1,North,Integer.MAX_VALUE);
		sierpinski(drawer,length);
		
	}
	static void sierpinski(Robot r,int l) {
		if (l >= 1) {
			sierpinski(r,l >> 1);
			for (int i = 0; i < l; i++) {
				r.move();
			}
			sierpinski(r,l >> 1);
			r.turnLeft();
			r.turnLeft();
			for (int i = 0; i < l; i++) {
				r.move();
			}
			r.turnLeft();
			//r.turnLeft();
			for (int i = 0; i < l; i++) {
				r.move();
			}
			r.turnLeft();
			sierpinski(r,l>>1);
			r.turnLeft();
			for (int i = 0; i < l; i++) {
				r.move();
			}
			r.turnLeft();
			r.turnLeft();
			r.turnLeft();
		}else {
			r.putBeeper();//r.putBeeper();
		}
	}
}
